package com.luog.onlinemusic.controllers.admin;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
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

import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.SongEntity;
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

	@RequestMapping(value = { "", "/allsong", "/index" }, method = RequestMethod.GET)
	public String allSongs(HttpServletRequest request, ModelMap modelMap) {
		List<Song> songs = songService.findAll(null);
		PagedListHolder<Song> pagedListHolder = new PagedListHolder<>(songs);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("currentTab", "song");
		modelMap.put("songs", pagedListHolder);
		modelMap.put("currentPage", page);
		return "admin.song.allsong";
	}

	@RequestMapping(value = { "/addsong", "/create", "/newsong" }, method = RequestMethod.GET)
	public String addSongForm(@RequestParam(value = "error", required = false) String error, ModelMap modelMap) {
		SongEntity songEntity = new SongEntity();
		songEntity.setShow(true);
		return initForm("admin.song.addsong", modelMap, songEntity);
	}

	@RequestMapping(value = { "/addsong", "/create", "/newsong" }, method = RequestMethod.POST)
	public String addSongAction(@ModelAttribute("song") @Valid SongEntity temp, BindingResult bindingResult,
			@RequestParam(value = "photo", required = false) MultipartFile image, ModelMap modelMap,
			HttpSession session) {
		//
		songValidator.validate(temp, bindingResult);
		//
		if (!bindingResult.hasErrors()) {
			if (!image.isEmpty()) {
				if (!ImageHelper.validateImage(image)) {
					modelMap.put("fileTypeError", "This file is not support!");
					return initForm("admin.song.addsong", modelMap, temp);
				} else {
					String imageName = ImageHelper.saveImage(servletContext, image);
					temp.setVideoPhoto(imageName);
				}
			}
			Account admin = (Account) session.getAttribute("currentAccount");
			temp.setUploadedBy(admin.getUsername());
			return songService.create(temp) ? "redirect:../song.html" : initForm("admin.song.addsong", modelMap, temp);
		}
		return "admin.song.addsong";
	}

	@RequestMapping(value = { "/updatesong", "/update" }, method = RequestMethod.GET)
	public String updateSongForm(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "id", required = false) Integer id, ModelMap modelMap) {
		if (id != null) {
			SongEntity songEntity = SongHelper.toSongEntity(songService.find(id));
			if (songEntity != null)
				return initForm("admin.song.updatesong", modelMap, songEntity);
		}
		return "redirect:../song.html";
	}

	@RequestMapping(value = { "/updatesong", "/update" }, method = RequestMethod.POST)
	public String updateSongAction(@ModelAttribute("song") @Valid SongEntity temp, BindingResult bindingResult,
			@RequestParam(value = "photo", required = false) MultipartFile image, ModelMap modelMap,
			HttpSession session) {
		//
		songValidator.validate(temp, bindingResult);
		//
		if (!bindingResult.hasErrors()) {
			if (!image.isEmpty()) {
				if (!ImageHelper.validateImage(image)) {
					modelMap.put("fileTypeError", "This file is not support!");
					return initForm("admin.song.updatesong", modelMap, temp);
				} else {
					String imageName = ImageHelper.saveImage(servletContext, image);
					temp.setVideoPhoto(imageName);
				}
			}
			return songService.update(temp) ? "redirect:../song.html"
					: initForm("admin.song.updatesong", modelMap, temp);
		}
		return "admin.song.updatesong";
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = { "/changestatus" }, method = RequestMethod.GET)
	public String changeStatus(HttpServletRequest request, @RequestParam(value = "id", required = false) Integer id,
			ModelMap modelMap) {
		if (id != null) {
			Song currentSong = songService.find(id);
			if (currentSong != null)
				songService.changeStatus(currentSong);
		}
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		modelMap.put("currentPage", page);
		return "redirect:../song.html";
	}

	/**
	 * @author luog
	 */
	private String initForm(String tileName, ModelMap modelMap, SongEntity songEntity) {
		modelMap.put("song", songEntity);
		modelMap.put("singers", singerService.findAll());
		modelMap.put("categories", categoryService.findAll());
		modelMap.put("authors", authorService.findAll());
		modelMap.put("currentTab", "song");
		return tileName;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
