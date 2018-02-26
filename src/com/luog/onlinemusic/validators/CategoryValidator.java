package com.luog.onlinemusic.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.luog.onlinemusic.entity.commons.Category;
import com.luog.onlinemusic.services.CategoryService;

@Component
public class CategoryValidator implements Validator {

	@Autowired
	private CategoryService categoryDAO;

	@Override
	public boolean supports(Class<?> arg0) {
		return Category.class.equals(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Category category = (Category) object;
		if (categoryDAO != null) {
			if (categoryDAO.isExist(category.getName()))
				errors.rejectValue("name", "category.exist");
		} else {
			System.out.println("CategoryDAO is not autowired");
		}

	}

}
