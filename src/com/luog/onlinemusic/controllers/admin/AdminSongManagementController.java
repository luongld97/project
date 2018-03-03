package com.luog.onlinemusic.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.luog.onlinemusic.entity.admin.AdminSong;
import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.helpers.ImageHelper;
import com.luog.onlinemusic.helpers.SongHelper;
import com.luog.onlinemusic.services.AuthorService;
import com.luog.onlinemusic.services.CategoryService;
import com.luog.onlinemusic.services.SingerService;
import com.luog.onlinemusic.services.SongService;
import com.luog.onlinemusic.validators.SongValidator;

@Controller
@RequestMapping("admin/song**")
public class AdminSongManagementController implements ServletContextAware {

	private ServletContext servletContext;

	@Autowired
	private SongService songService;

	@Autowired
	private SingerService singerService;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SongValidator songValidator;

	@RequestMapping(value = { "", "allsong", "index" }, method = RequestMethod.GET)
	public String allSongs(HttpServletRequest request, ModelMap modelMap) {
		List<Song> songs = songService.findAll();
		PagedListHolder<Song> pagedListHolder = new PagedListHolder<>(songs);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("currentTab", "song");
		modelMap.put("songs", pagedListHolder);
		modelMap.put("currentPage", page);
		return "admin.song.allsong";
	}

	@RequestMapping(value = "addsong", method = RequestMethod.GET)
	public String addSongForm(ModelMap modelMap) {
		return initAddSongPage(new AdminSong(), modelMap);
	}

	@RequestMapping(value = "addsong", method = RequestMethod.POST, params = "addsong")
	public String addSongAction(@ModelAttribute("song") @Valid AdminSong temp, BindingResult bindingResult,
			@RequestParam(value = "photo", required = false) MultipartFile image, ModelMap modelMap, HttpSession session) {
		String result = "";
		songValidator.validate(temp, bindingResult);
		if (bindingResult.hasErrors()) {
			result = initAddSongPage(null, modelMap);
		} else
			try {
				if (temp.isVideo()) {
					if (ImageHelper.validateImage(image))
						temp.setVideoPhoto(ImageHelper.saveImage(servletContext, image));
					else {
						modelMap.put("fileTypeError", "This file is not support!");
						result = initAddSongPage(temp, modelMap);
					}
				}
				UserDetails userDetails = (UserDetails) session.getAttribute("admin");
				temp.setUploadedBy(userDetails.getUsername());
				result = songService.create(temp) ? "redirect:/admin/song.html" : initAddSongPage(new AdminSong(), modelMap);
			} catch (Exception e) {
				e.printStackTrace();
				result = initAddSongPage(new AdminSong(), modelMap);
			}
		return result;
	}

	@RequestMapping(value = "addsong", method = RequestMethod.POST, params = "addcategory")
	public String goAddCategory(@ModelAttribute("song") AdminSong temp) {
		return "admin.home.index";
	}

	@RequestMapping(value = "addsong", method = RequestMethod.POST, params = "addauthor")
	public String goAddAuthor(@ModelAttribute("song") AdminSong temp) {

		return "admin.home.index";
	}

	@RequestMapping(value = "addsong", method = RequestMethod.POST, params = "addsinger")
	public String goAddSinger(@ModelAttribute("song") AdminSong temp) {

		return "admin.home.index";
	}

	@RequestMapping(value = "updatesong", method = RequestMethod.GET)
	public String updateSongForm(@RequestParam(value = "id", required = false) Integer id, ModelMap modelMap) {
		modelMap.put("currentTab", "song");
		modelMap.put("song", SongHelper.toAdminSong(songService.find(id)));
		modelMap.put("singers", singerService.findAll());
		modelMap.put("authors", authorService.findAll());
		modelMap.put("categories", categoryService.findAll());
		return "admin.song.updatesong";
	}

	@RequestMapping(value = "updatesong", method = RequestMethod.POST)
	public String updateSongAction(@ModelAttribute("song") @Valid AdminSong temp, BindingResult bindingResult,
			@RequestParam(value = "photo", required = false) MultipartFile image, ModelMap modelMap, HttpSession session) {
		String result = "";
		songValidator.validate(temp, bindingResult);
		if (bindingResult.hasErrors()) {
			result = initAddSongPage(null, modelMap);
		} else
			try {
				if (temp.isVideo()) {
					if (ImageHelper.validateImage(image))
						temp.setVideoPhoto(ImageHelper.saveImage(servletContext, image));
					else {
						modelMap.put("fileTypeError", "This file is not support!");
						result = initAddSongPage(temp, modelMap);
					}
				}
				Account currentAccount = (Account) session.getAttribute("currentAccount");
				temp.setUploadedBy(currentAccount.getUsername());
				result = songService.update(temp) ? "redirect:/admin/song.html" : initAddSongPage(temp, modelMap);
			} catch (Exception e) {
				e.printStackTrace();
				result = initAddSongPage(temp, modelMap);
			}
		return result;
	}

	private String initAddSongPage(AdminSong temp, ModelMap modelMap) {
		modelMap.put("currentTab", "song");
		if (temp != null)
			modelMap.put("song", temp);
		modelMap.put("singers", singerService.findAll());
		modelMap.put("authors", authorService.findAll());
		modelMap.put("categories", categoryService.findAll());
		return "admin.song.addsong";
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
