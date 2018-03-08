package com.luog.onlinemusic.controllers.user;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.multipart.MultipartFile;

import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.commons.Author;
import com.luog.onlinemusic.entity.commons.PlayList;
import com.luog.onlinemusic.entity.commons.Role;
import com.luog.onlinemusic.services.AccountService;
import com.luog.onlinemusic.services.PlayListService;
import com.luog.onlinemusic.services.RoleService;
import com.sun.xml.internal.ws.api.pipe.Fiber;

@Controller
@RequestMapping("account")
public class AccountController {

	@Autowired
	ServletContext context;

	@Autowired
	private AccountService accountService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PlayListService playListService;

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
	public String registerProccess(@ModelAttribute("account") Account account, ModelMap modelMap, MultipartFile file) {
		Role role = roleService.find(3);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());

		try {
			if (!file.isEmpty()) {
				String path = context.getRealPath("/assets/images") + File.separator + file.getOriginalFilename();
				file.transferTo(new File(path));
			}
			account.setPhoto(file.getOriginalFilename());
			account.setCreatedTime(dateFormat.parse(date));
			account.setStatus(true);
			account.setRole(role);
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
	@RequestMapping(value = { "/playlist/addplaylist" }, method = RequestMethod.GET)
	public String getPlayList(HttpSession session, ModelMap modelMap) {
		Account currentAccount = (Account) session.getAttribute("currentAccount");
		if (currentAccount != null) {
			modelMap.put("album", new Album());
			return "user.playlist.add";
		}
		return "redirect:/account/login.html";
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = { "/playlist/update" }, method = RequestMethod.GET)
	public String updatePlayList(@RequestParam(value = "id", required = false) Integer id, HttpSession session,
			ModelMap modelMap) {
		if (id != null) {
			Account currentAccount = (Account) session.getAttribute("currentAccount");
			if (currentAccount != null) {
				PlayList playList = playListService.find(id);
				modelMap.put("playList", playList);
				return "user.playlist.update";
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
	public String updateAccountAction(@ModelAttribute("account") Account account, ModelMap modelMap) {
		Role role = roleService.find(3);
		account.setRole(role);
		boolean currentAccount = accountService.update(account);
		if (currentAccount) {
			Account acc = accountService.find(account.getUsername());
			modelMap.put("account", acc);
			return "redirect:../account/accountinfo.html";
		} else {
			modelMap.put("message", "Update Fail!");
			return "user.editaccount";
		}
	}

	@RequestMapping(value = "/accountinfo", method = RequestMethod.GET)
	public String getInfoAccount(ModelMap modelMap, HttpSession httpSession) {
		return "user.accountinfo";
	}

}