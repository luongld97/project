package com.luog.onlinemusic.controllers.admin;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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

import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.rest.SingerEntity;
import com.luog.onlinemusic.helpers.EntityHelper;
import com.luog.onlinemusic.helpers.ImageHelper;
import com.luog.onlinemusic.services.SingerService;
import com.luog.onlinemusic.validators.SingerValidator;

@Controller
@RequestMapping("admin/singer**")
public class AdminSingerManagementController implements ServletContextAware {

	private ServletContext servletContext;

	@Autowired
	private SingerService singerService;

	@Autowired
	private SingerValidator singerValidator;

	@RequestMapping(value = { "", "/allsinger", "/index" }, method = RequestMethod.GET)
	public String allsinger(ModelMap modelMap, HttpServletRequest request) {
		List<Singer> singers = singerService.findAll();
		PagedListHolder<Singer> pagedListHolder = new PagedListHolder<>(singers);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("currentTab", "singer");
		modelMap.put("singers", pagedListHolder);
		modelMap.put("currentPage", page);
		return "admin.singer.allsinger";
	}

	@RequestMapping(value = { "/addsinger", "/newsinger", "/create" }, method = RequestMethod.GET)
	public String addsingerForm(ModelMap modelMap) {
		return initForm("admin.singer.addsinger", modelMap, new SingerEntity());
	}

	@RequestMapping(value = { "/addsinger", "/create" }, method = RequestMethod.POST)
	public String addsingerAction(@ModelAttribute("singer") @Valid SingerEntity temp, BindingResult bindingResult,
			@RequestParam(value = "avatar", required = false) MultipartFile image, ModelMap modelMap) {
		//
		singerValidator.validate(temp, bindingResult);
		//
		if (!bindingResult.hasErrors()) {
			if (!image.isEmpty()) {
				if (ImageHelper.validateImage(image)) {
					temp.setPhoto(ImageHelper.saveImage(servletContext, image));
				} else {
					modelMap.put("fileTypeError", "This file is not support!");
					return initForm("admin.singer.addsinger", modelMap, temp);
				}
			} else {
				temp.setPhoto("default-avatar.png");
			}
			return singerService.create(temp) ? "redirect:../singer.html"
					: initForm("admin.singer.addsinger", modelMap, temp);
		}
		return initForm("admin.singer.addsinger", modelMap, temp);
	}

	@RequestMapping(value = { "/updatesinger", "/update" }, method = RequestMethod.GET)
	public String updatesingerForm(@RequestParam(value = "id", required = false) Integer id, ModelMap modelMap) {
		if (id != null) {
			Singer currentSinger = singerService.find(id);
			if (currentSinger != null)
				return initForm("admin.singer.updatesinger", modelMap, EntityHelper.toSingerEntity(currentSinger));
		}
		return "redirect:../singer.html";
	}

	@RequestMapping(value = { "/updatesinger", "/update" }, method = RequestMethod.POST)
	public String updatesingerAction(@ModelAttribute("singer") @Valid SingerEntity temp, BindingResult bindingResult,
			@RequestParam(value = "avatar", required = false) MultipartFile image, ModelMap modelMap) {
		//
		singerValidator.validate(temp, bindingResult);
		//
		if (!bindingResult.hasErrors()) {
			if (!image.isEmpty()) {
				if (ImageHelper.validateImage(image)) {
					temp.setPhoto(ImageHelper.saveImage(servletContext, image));
				} else {
					modelMap.put("fileTypeError", "This file is not support!");
					return initForm("admin.singer.updatesinger", modelMap, temp);
				}
			}
			return singerService.update(temp) ? "redirect:../singer.html"
					: initForm("admin.singer.updatesinger", modelMap, temp);
		}
		return initForm("admin.singer.updatesinger", modelMap, temp);
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	/**
	 * @author luog
	 */
	private String initForm(String tileName, ModelMap modelMap, SingerEntity singerEntity) {
		modelMap.put("currentTab", "singer");
		modelMap.put("singer", singerEntity);
		return tileName;
	}
}
