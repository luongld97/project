package com.luog.onlinemusic.controllers.admin;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("authentication")
public class AuthenticationController {

	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "redirect:/authentication/login.html";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			ModelMap modelMap) {
		if (error != null) {
			modelMap.addAttribute("error",
					"Invalid username and password! Try again!");
		}
		if (logout != null) {
			modelMap.addAttribute("logout", "You've been logged out successfully.");
		}
		return "authentication.login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "redirect:../authentication/login.html?logout";
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accesssDenied(ModelMap modelMap) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			modelMap.addAttribute("username", userDetail.getUsername());
		}
		return "authentication.accessdenied";
	}
	
	@RequestMapping(value = "/logging", method = RequestMethod.GET)
	public String logging() {
		return "redirect:../admin/home.html";
	}
	
}
