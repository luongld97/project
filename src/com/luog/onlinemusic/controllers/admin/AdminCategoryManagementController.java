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

import com.luog.onlinemusic.entity.commons.Category;
import com.luog.onlinemusic.services.CategoryService;
import com.luog.onlinemusic.validators.CategoryValidator;

@Controller
@RequestMapping("admin/category**")
public class AdminCategoryManagementController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = { "", "allcategory", "index" }, method = RequestMethod.GET)
	public String allCategory(ModelMap modelMap, HttpServletRequest request) {
		List<Category> categories = categoryService.findAll();
		PagedListHolder<Category> pagedListHolder = new PagedListHolder<>(categories);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("currentTab", "category");
		modelMap.put("categories", pagedListHolder);
		modelMap.put("currentPage", page);
		return "admin.category.allcategory";
	}

	@RequestMapping(value = { "addcategory", "newcategory", "create" }, method = RequestMethod.GET)
	public String addCategoryForm(ModelMap modelMap) {
		modelMap.put("currentTab", "category");
		modelMap.put("category", new Category());
		return "admin.category.addcategory";
	}

	@RequestMapping(value = { "addcategory" }, method = RequestMethod.POST)
	public String addCategoryAction(@ModelAttribute("category") @Valid Category temp, BindingResult bindingResult,
			ModelMap modelMap) {
		CategoryValidator categoryValidator = new CategoryValidator();
		categoryValidator.validate(temp, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin.category.addcategory";
		} else {
			categoryService.create(temp);
			return "redirect:../category.html";
		}
	}

	@RequestMapping(value = { "updatecategory" }, method = RequestMethod.GET)
	public String updateCategoryForm(@RequestParam("id") int id, ModelMap modelMap) {
		Category currentCategory = categoryService.find(id);
		modelMap.put("category", currentCategory);
		return "admin.category.updatecategory";
	}
	
	@RequestMapping(value = { "updatecategory" }, method = RequestMethod.POST)
	public String updateCategoryAction(@ModelAttribute("category") @Valid Category temp, BindingResult bindingResult,
			ModelMap modelMap) {
		CategoryValidator categoryValidator = new CategoryValidator();
		categoryValidator.validate(temp, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin.category.updatecategory";
		} else {
			categoryService.update(temp);
			return "redirect:../category.html";
		}
	}
}
