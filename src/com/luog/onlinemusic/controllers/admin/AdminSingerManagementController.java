package com.luog.onlinemusic.controllers.admin;

import java.util.Date;
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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.helpers.DateHelper;
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

	@RequestMapping(value = { "", "allsinger", "index" }, method = RequestMethod.GET)
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

	@RequestMapping(value = { "addsinger", "newsinger", "create" }, method = RequestMethod.GET)
	public String addsingerForm(ModelMap modelMap) {
		modelMap.put("currentTab", "singer");
		modelMap.put("singer", new Singer());
		return "admin.singer.addsinger";
	}

	@RequestMapping(value = { "addsinger", "create" }, method = RequestMethod.POST)
	public String addsingerAction(@ModelAttribute("singer") @Valid Singer temp, BindingResult bindingResult,
			@RequestParam(value = "photo", required = false) MultipartFile image, ModelMap modelMap) {
		singerValidator.validate(temp, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin.singer.addsinger";
		} else {
			if (image != null) {
				if (ImageHelper.validateImage(image)) {
					temp.setPhoto(ImageHelper.saveImage(servletContext, image));
				} else {
					modelMap.put("fileTypeError", "This file is not support!");
					modelMap.put("currentTab", "singer");
					modelMap.put("singer", new Singer());
					return "admin.singer.addsinger";
				}
			} else {
				temp.setPhoto("default-avatar.png");
			}
			singerService.create(temp);
			return "redirect:../singer.html";
		}
	}

	@RequestMapping(value = { "updatesinger" }, method = RequestMethod.GET)
	public String updatesingerForm(@RequestParam("id") int id, ModelMap modelMap) {
		Singer currentSinger = singerService.find(id);
		modelMap.put("singer", currentSinger);
		return "admin.singer.updatesinger";
	}

	@RequestMapping(value = { "updatesinger" }, method = RequestMethod.POST)
	public String updatesingerAction(@ModelAttribute("singer") @Valid Singer temp, BindingResult bindingResult,
			ModelMap modelMap) {
		singerValidator.validate(temp, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin.singer.updatesinger";
		} else {
			singerService.update(temp);
			return "redirect:../singer.html";
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Date.class, new DateHelper());
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
