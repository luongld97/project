package com.luog.onlinemusic.controllers.admin;

import java.util.List;

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

import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.services.SingerService;
import com.luog.onlinemusic.validators.SingerValidator;

@Controller
@RequestMapping("admin/singer**")
public class AdminSingerManagementController {

	@Autowired
	private SingerService singerService;

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

	@RequestMapping(value = { "addsinger" }, method = RequestMethod.POST)
	public String addsingerAction(@ModelAttribute("singer") @Valid Singer temp, BindingResult bindingResult,
			ModelMap modelMap) {
		SingerValidator singerValidator = new SingerValidator();
		singerValidator.validate(temp, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin.singer.addsinger";
		} else {
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
		SingerValidator singerValidator = new SingerValidator();
		singerValidator.validate(temp, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin.singer.updatesinger";
		} else {
			singerService.update(temp);
			return "redirect:../singer.html";
		}
	}
}
