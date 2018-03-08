package com.luog.onlinemusic.controllers.admin;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;

import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.services.AccountService;

@Controller
@RequestMapping("admin/account**")
public class AdminAccountManagementController implements ServletContextAware{
	
	private ServletContext servletContext;
	
	@Autowired
	private AccountService accountService ;
	
	@RequestMapping(value = { "", "/allaccount", "/index" }, method = RequestMethod.GET)
	public String allAccounts(HttpServletRequest request, ModelMap modelMap) {
		List<Account> accounts = accountService.findAll();
		PagedListHolder<Account> pagedListHolder = new PagedListHolder<>(accounts);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("currentTab", "account");
		modelMap.put("accounts", pagedListHolder);
		modelMap.put("currentPage", page);
		return "admin.account.allaccount";
	}
	
	@RequestMapping(value = { "/changestatus" }, method = RequestMethod.GET)
	public String changeStatus(HttpServletRequest request, @RequestParam(value = "username", required = false) String username,
			ModelMap modelMap) {
		if (username != null) {
			Account currentAccount = accountService.find(username);
			if (currentAccount != null)
				accountService.changeStatus(currentAccount);
		}
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		modelMap.put("currentPage", page);
		return "redirect:../account.html";
	}
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
