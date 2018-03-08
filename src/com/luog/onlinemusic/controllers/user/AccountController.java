package com.luog.onlinemusic.controllers.user;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.commons.Author;
import com.luog.onlinemusic.entity.commons.PlayList;
import com.luog.onlinemusic.entity.commons.PlayListDetail;
import com.luog.onlinemusic.entity.commons.Role;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.helpers.BCrypt;
import com.luog.onlinemusic.helpers.ImageHelper;
import com.luog.onlinemusic.services.AccountService;
import com.luog.onlinemusic.services.PlayListService;
import com.luog.onlinemusic.services.RoleService;
import com.luog.onlinemusic.validators.AccountValidator;
import com.sun.xml.internal.ws.api.pipe.Fiber;

@Controller
@RequestMapping("account")
public class AccountController implements ServletContextAware {

	@Autowired
	private ServletContext servletContext;

	@Autowired
	private AccountService accountService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PlayListService playListService;

	@Autowired
	private AccountValidator accountValidator;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error, ModelMap modelMap) {
		modelMap.put("account", new Account());
		if (error != null) {
			modelMap.addAttribute("error", "Account Ivalid");
		}
		return "user.login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginProccess(@ModelAttribute("account") Account loginAccount, ModelMap modelMap,
			HttpSession httpSession) {
		Account currentAccount = accountService.login(loginAccount.getUsername(), loginAccount.getPassword());
		if (currentAccount != null) {
			httpSession.setAttribute("currentAccount", currentAccount);
		} else {
			return "redirect:/account/login.html?error";
		}

		return "redirect:../home.html";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(@RequestParam(value = "error", required = false) String error, ModelMap modelMap) {
		modelMap.put("account", new Account());
		if (error != null) {
			modelMap.addAttribute("errors", "Account Ivalid");
		} else {
			modelMap.addAttribute("Success", "Welcome");
		}
		return "user.register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerProccess(@ModelAttribute("account") @Valid Account account, ModelMap modelMap,
			@RequestParam("file") MultipartFile image, BindingResult bindingResult) {
		accountValidator.validate(account, bindingResult);
		Role role = roleService.find(3);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());

		try {
			if (!image.isEmpty()) {
				if (ImageHelper.validateImage(image)) {
					account.setPhoto(ImageHelper.saveImage(servletContext, image));
				}
			} else {
				account.setPhoto("default_avatar.png");
			}
			account.setCreatedTime(dateFormat.parse(date));
			account.setStatus(true);
			account.setRole(role);
			account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt()));
			if (accountService.create(account)) {
				return "redirect:/account/login.html";
			} else {
				return "redirect:/account/register.html?error";
			}
		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/account/login.html";
	}

	@RequestMapping(value = { "/logout", "/signout" }, method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("currentAccount");
		return "redirect:/";
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = { "/playlist" }, method = RequestMethod.GET)
	public String getPlayList(@RequestParam(value = "username", required = false) String username,
			HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		Account currentAccount = (Account) session.getAttribute("currentAccount");
		if (currentAccount != null) {
			List<PlayList> playLists = null;
			playLists = currentAccount != null ? playListService.getPlayLists(currentAccount) : new ArrayList<>();
			PagedListHolder<PlayList> pagedListHolder = new PagedListHolder<>(playLists);
			int page = ServletRequestUtils.getIntParameter(request, "page", 0);
			pagedListHolder.setPage(page);
			pagedListHolder.setPageSize(3);
			modelMap.put("playLists", pagedListHolder);
			modelMap.put("currentPage", page);
			modelMap.put("account", currentAccount);
			return "user.playlist";
		}
		return "redirect:/account/login.html";
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = { "/playlist/update" }, method = RequestMethod.GET)
	public String updatePlayList(@RequestParam(value = "id", required = false) Integer id, HttpServletRequest request,
			HttpSession session, ModelMap modelMap) {
		if (id != null) {
			Account currentAccount = (Account) session.getAttribute("currentAccount");
			if (currentAccount != null) {
				PlayList playList = playListService.find(id);
				List<Song> songs = new ArrayList<>();
				Set<PlayListDetail> playListDetails = playList.getPlayListDetails();
				for (PlayListDetail playListDetail : playListDetails)
					songs.add(playListDetail.getSong());
				PagedListHolder<Song> pagedListHolder = new PagedListHolder<>(songs);
				int page = ServletRequestUtils.getIntParameter(request, "page", 0);
				pagedListHolder.setPage(page);
				pagedListHolder.setPageSize(10);
				modelMap.put("songs", pagedListHolder);
				modelMap.put("playList", playList);
				return "user.playlist.update";
			}
			return "redirect:/account/login.html";
		}
		return "redirect:/";
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = { "/playlist/update" }, method = RequestMethod.POST)
	public String updatePlayListAction(@ModelAttribute("playList") @Valid PlayList playList,
			BindingResult bindingResult, @RequestParam(value = "albumPhoto", required = false) MultipartFile image,
			HttpSession session, HttpServletRequest request, ModelMap modelMap) {
		Account currentAccount = (Account) session.getAttribute("currentAccount");
		if (currentAccount != null) {
			if (!bindingResult.hasErrors()) {
				PlayList currentPlayList = playListService.find(playList.getId());
				if (!image.isEmpty()) {
					if (ImageHelper.validateImage(image)) {
						currentPlayList.setPhoto(ImageHelper.saveImage(servletContext, image));
					} else {
						modelMap.put("fileTypeError", "This file is not support!");
						List<Song> songs = new ArrayList<>();
						Set<PlayListDetail> playListDetails = playList.getPlayListDetails();
						for (PlayListDetail playListDetail : playListDetails)
							songs.add(playListDetail.getSong());
						PagedListHolder<Song> pagedListHolder = new PagedListHolder<>(songs);
						int page = ServletRequestUtils.getIntParameter(request, "page", 0);
						pagedListHolder.setPage(page);
						pagedListHolder.setPageSize(2);
						modelMap.put("songs", pagedListHolder);
						modelMap.put("playList", currentPlayList);
						return "user.playlist.update";
					}
				}

				currentPlayList.setName(playList.getName());
				playList.setAccount(currentAccount);
				boolean result = playListService.update(currentPlayList);
				if (result)
					return "redirect: ../playlist.html";
			}
		}
		return "redirect:/account/login.html";
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = { "/playlist/delete" }, method = RequestMethod.GET)
	public String deletePlayList(@RequestParam(value = "id", required = false) Integer id) {
		if (id != null) {
			PlayList playList = playListService.find(id);
			if (playList != null) {
				boolean result = playListService.delete(playList);
				return "redirect:/account/playlist.html";
			}
		}
		return "redirect:/account/playlist.html";
	}

	@RequestMapping(value = "/updateAccount", method = RequestMethod.GET)
	public String updateAccount(@RequestParam(value = "acc", required = false) String username, ModelMap modelMap) {
		Account account = accountService.find(username);
		modelMap.put("account", account);
		return "user.editaccount";
	}

	@RequestMapping(value = "/doUpdateAccount", method = RequestMethod.POST)
	public String updateAccountAction(@ModelAttribute("account") Account account, ModelMap modelMap,
			HttpSession httpSession, @RequestParam("file") MultipartFile image) {

		Account acc = accountService.find(account.getUsername());
		if (acc != null) {
			modelMap.put("account", acc);
			if (account.getPassword() != null) {
				acc.setPassword(account.getPassword());
			}
			acc.setDateOfBirth(account.getDateOfBirth());
			acc.setGender(account.getGender());
			if (!image.isEmpty()) {
				if (ImageHelper.validateImage(image)) {
					acc.setPhoto(ImageHelper.saveImage(servletContext, image));
				}
			}
			if (account.getPhone() != null) {
				acc.setPhone(account.getPhone());
			}
			boolean currentAccount = accountService.update(acc);
			if (currentAccount)
				httpSession.setAttribute("currentAccount", acc);
			return "redirect:../account/accountinfo.html";
		} else {
			modelMap.put("massage", "Update Fail!");
			return "user.editaccount";
		}

	}

	@RequestMapping(value = "/accountinfo", method = RequestMethod.GET)
	public String getInfoAccount(ModelMap modelMap, HttpSession httpSession) {
		return "user.accountinfo";
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public String getChangePassword(@RequestParam(value = "username", required = false) String username,
			ModelMap modelMap) {
		Account account = accountService.find(username);
		modelMap.put("account", account);
		return "user.changepassword";
	}

	@RequestMapping(value = "/updatepassword", method = RequestMethod.POST)
	public String getUpdatePassword(@RequestParam(value = "username") String username,
			@RequestParam(value = "oldpassword") String oldPassword,
			@RequestParam(value = "newpassword") String newPassword, ModelMap modelMap) {
		Account account = accountService.find(username);
		if (!BCrypt.checkpw(oldPassword, account.getPassword())) {
			modelMap.put("error", "Old password is wrong!");
			modelMap.put("account", account);
			return "user.changepassword";
		}
		account.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt()));
		accountService.update(account);
		return "redirect:../account/accountinfo.html";
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}