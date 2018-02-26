package com.luog.onlinemusic.controllers.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.PlayList;
import com.luog.onlinemusic.entity.commons.Role;
import com.luog.onlinemusic.services.AccountService;
import com.luog.onlinemusic.services.PlayListService;
import com.luog.onlinemusic.services.RoleService;

@Controller
@RequestMapping("account")
public class AccountController {

	@Autowired
	public AccountService accountService;

	@Autowired
	public RoleService roleService;

	@Autowired
	public PlayListService playListService;

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
	public String registerProccess(@ModelAttribute("account") Account account, ModelMap modelMap) {
		Role role = roleService.find(3);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());
		;
		try {
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
	public String getPlayList(@RequestParam("username") String username, HttpServletRequest request,
			HttpSession httpSession, ModelMap modelMap) {
		Account currentAccount = (Account) httpSession.getAttribute("currentAccount");
		List<PlayList> playLists = null;
		playLists = currentAccount != null ? playListService.getUserPlayList(currentAccount) : new ArrayList<>();
		PagedListHolder<PlayList> pagedListHolder = new PagedListHolder<>(playLists);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("playLists", pagedListHolder);
		modelMap.put("currentPage", page);
		return "user.playlist";
	}

}
