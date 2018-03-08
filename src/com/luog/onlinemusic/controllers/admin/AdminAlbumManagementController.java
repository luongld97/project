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

import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.rest.AlbumEntity;
import com.luog.onlinemusic.helpers.ImageHelper;
import com.luog.onlinemusic.helpers.EntityHelper;
import com.luog.onlinemusic.services.AlbumService;
import com.luog.onlinemusic.services.SingerService;
import com.luog.onlinemusic.services.SongService;
import com.luog.onlinemusic.validators.AlbumValidator;
import com.luog.onlinemusic.validators.CategoryValidator;

@Controller
@RequestMapping("admin/album**")
public class AdminAlbumManagementController implements ServletContextAware {

	private ServletContext servletContext;

	@Autowired
	private AlbumService albumService;

	@Autowired
	private SingerService singerService;

	@Autowired
	private SongService songService ;
	
	@Autowired
	private AlbumValidator albumValidator;

	@RequestMapping(value = { "", "/allalbum", "/index" }, method = RequestMethod.GET)
	public String allAlbums(HttpServletRequest request, ModelMap modelMap) {
		List<Album> albums = albumService.findAll();
		PagedListHolder<Album> pagedListHolder = new PagedListHolder<>(albums);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("currentTab", "album");
		modelMap.put("albums", pagedListHolder);
		modelMap.put("currentPage", page);
		return "admin.album.allalbum";
	}

	@RequestMapping(value = { "/addalbum", "/create", "/newalbum" }, method = RequestMethod.GET)
	public String addAlbumForm(@RequestParam(value = "error", required = false) String error, ModelMap modelMap) {
		AlbumEntity  albumEntity = new AlbumEntity();
		return initForm("admin.album.addalbum", modelMap, albumEntity);
	}

	@RequestMapping(value = { "/addalbum", "/create", "/newalbum" }, method = RequestMethod.POST)
	public String addAlbumAction(@ModelAttribute("album") @Valid AlbumEntity temp, BindingResult bindingResult,
			@RequestParam(value = "album-photo", required = false) MultipartFile image, ModelMap modelMap,
			HttpSession session) {
		albumValidator.validate(temp, bindingResult);
		if (!bindingResult.hasErrors()) {
			if (!image.isEmpty()) {
				if (!ImageHelper.validateImage(image)) {
					modelMap.put("fileTypeError", "This file is not support!");
					return initForm("admin.album.addalbum", modelMap, temp);
				} else {
					String imageName = ImageHelper.saveImage(servletContext, image);
					temp.setPhoto(imageName);
				}
			}
			temp.setPhoto("default_album.png");
			return albumService.create(temp) ? "redirect:../album.html" : initForm("admin.album.addalbum", modelMap, temp);
		}
		return initForm("admin.album.addalbum", modelMap, temp);
	}

	@RequestMapping(value = { "/updatealbum", "/update" }, method = RequestMethod.GET)
	public String updateAlbumForm(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "id", required = false) Integer id, ModelMap modelMap) {
		if (id != null) {
			AlbumEntity albumEntity = EntityHelper.toAlbumEntity(albumService.find(id));
			if (albumEntity != null)
				return initForm("admin.album.updatealbum", modelMap, albumEntity);
		}
		return "redirect:../album.html";
	}

	@RequestMapping(value = { "/updatealbum", "/update" }, method = RequestMethod.POST)
	public String updateAlbumAction(@ModelAttribute("album") @Valid AlbumEntity temp, BindingResult bindingResult,
			@RequestParam(value = "photo", required = false) MultipartFile image, ModelMap modelMap,
			HttpSession session) {
		albumValidator.validate(temp, bindingResult);
		if (!bindingResult.hasErrors()) {
			if (!image.isEmpty()) {
				if (!ImageHelper.validateImage(image)) {
					modelMap.put("fileTypeError", "This file is not support!");
					return initForm("admin.album.updatealbum", modelMap, temp);
				} else {
					String imageName = ImageHelper.saveImage(servletContext, image);
					temp.setPhoto(imageName);
				}
			}
			return albumService.update(temp) ? "redirect:../album.html"
					: initForm("admin.album.updatealbum", modelMap, temp);
		}
		return initForm("admin.album.updatealbum", modelMap, temp);
	}

	
	/**
	 * @author luog
	 */
	private String initForm(String tileName, ModelMap modelMap, AlbumEntity albumEntity) {
		modelMap.put("album", albumEntity);
		modelMap.put("singers", singerService.findAll());
		modelMap.put("songs", songService.findAll(true));
		modelMap.put("currentTab", "album");
		return tileName;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
