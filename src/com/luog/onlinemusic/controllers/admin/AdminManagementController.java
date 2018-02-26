package com.luog.onlinemusic.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.services.AccountService;
import com.luog.onlinemusic.services.SongService;

@Controller
@RequestMapping("admin/management**")
public class AdminManagementController implements ServletContextAware{
	
	private ServletContext servletContext;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private SongService songService;
	
	@RequestMapping(value = "account", method = RequestMethod.GET)
	public String account(HttpServletRequest request, ModelMap modelMap) {
		List<Account> accounts = accountService.findAll();
		PagedListHolder<Account> pagedListHolder = new PagedListHolder<>(accounts);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("accounts", pagedListHolder);
		modelMap.put("currentTab", "account");
		modelMap.put("currentPage", page);
		return "admin.management.account";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "account/block")
	public String accountBlock(@RequestParam("id") String username, @RequestParam("status") boolean status,
			@RequestParam("page") int page) {
		boolean result = false;
		try {
			Account currentAccount = accountService.find(username);
			if (currentAccount != null) {
				currentAccount.setStatus(status);
				result = accountService.update(currentAccount);
			}
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result ? "redirect:../account.html?page=" + page : "redirect:error.html";
	}
	
	@RequestMapping(value = "song", method = RequestMethod.GET)
	public String song(HttpServletRequest request, ModelMap modelMap) {
		List<Song> songs = songService.findAll();
		PagedListHolder<Song> pagedListHolder = new PagedListHolder<>(songs);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("songs", pagedListHolder);
		modelMap.put("currentTab", "song");
		modelMap.put("currentPage", page);
		return "admin.management.song";
	}
	
	
	@RequestMapping(value = "song/add", method = RequestMethod.GET)
	public String songAddForm(ModelMap modelMap) {
		modelMap.put("song", new Song());
		return "admin.management.song.add";
	}
	
	@RequestMapping(value = "song/add", method = RequestMethod.POST)
	public String songAddAction(@ModelAttribute("song") Song song, 
			@RequestParam(value = "song", required = false) MultipartFile file) {
		if (null != file) {
			String filename= saveSong(file);
			String songLink = servletContext.getRealPath("/") + "/assets/songs/" + filename;
			System.out.println(songLink);
		}
		return "redirect:../../home.html";
	}
	
	private String saveSong(MultipartFile song) {
		try {
			File file = new File(
					servletContext.getRealPath("/") + "/assets/songs/" + song.getOriginalFilename());
			FileUtils.writeByteArrayToFile(file, song.getBytes());
			return song.getOriginalFilename();
		} catch (IOException e) {
			return null;
		}
	}
//	@RequestMapping(value= "/login" , method = RequestMethod.GET)
//	public String loginForm(ModelMap modelMap) {
//		modelMap.put("account", new Account());
//		return "login";
//	}
//	
//	@RequestMapping(value= "/login" , method = RequestMethod.POST)
//	public String loginAction(@ModelAttribute("account") Account account) {
//		System.out.println(account.getUsername());
//		return "redirect:home.html";
//	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		
	}
	
	
}
