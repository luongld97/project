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

import com.luog.onlinemusic.entity.commons.Author;
import com.luog.onlinemusic.entity.commons.Category;
import com.luog.onlinemusic.services.AuthorService;
import com.luog.onlinemusic.services.CategoryService;
import com.luog.onlinemusic.validators.AuthorValidator;
import com.luog.onlinemusic.validators.CategoryValidator;

@Controller
@RequestMapping("admin/author**")
public class AdminAuthorManagementController {

	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private AuthorValidator authorValidator;

	@RequestMapping(value = { "", "allauthor", "index" }, method = RequestMethod.GET)
	public String allCategory(ModelMap modelMap, HttpServletRequest request) {
		List<Author> authors = authorService.findAll();
		PagedListHolder<Author> pagedListHolder = new PagedListHolder<>(authors);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("currentTab", "author");
		modelMap.put("authors", pagedListHolder);
		modelMap.put("currentPage", page);
		return "admin.author.allauthor";
	}

	@RequestMapping(value = { "addauthor", "newauthor", "create" }, method = RequestMethod.GET)
	public String addAuthorForm(ModelMap modelMap) {
		modelMap.put("currentTab", "author");
		modelMap.put("author", new Author());
		return "admin.author.addauthor";
	}

	@RequestMapping(value = { "addauthor" }, method = RequestMethod.POST)
	public String addCategoryAction(@ModelAttribute("author") @Valid Author temp, BindingResult bindingResult,
			ModelMap modelMap) {
		authorValidator.validate(temp, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin.author.addauthor";
		} else {
			authorService.create(temp);
			return "redirect:../author.html";
		}
	}

	@RequestMapping(value = { "updateauthor" }, method = RequestMethod.GET)
	public String updateCategoryForm(@RequestParam("id") int id, ModelMap modelMap) {
		Author currentAuthor = authorService.find(id);
		modelMap.put("author", currentAuthor);
		return "admin.author.updateauthor";
	}

	@RequestMapping(value = { "updateauthor" }, method = RequestMethod.POST)
	public String updateCategoryAction(@ModelAttribute("category") @Valid Author temp, BindingResult bindingResult,
			ModelMap modelMap) {
		authorValidator.validate(temp, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin.author.updateauthor";
		} else {
			authorService.update(temp);
			return "redirect:../author.html";
		}
	}
}
