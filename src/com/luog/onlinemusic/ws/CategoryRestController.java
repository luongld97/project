package com.luog.onlinemusic.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luog.onlinemusic.entity.commons.Category;
import com.luog.onlinemusic.services.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryRestController {
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * find all of song
	 * */
	@RequestMapping(value ="findall", 
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			headers  = "Accept=application/json")
	public ResponseEntity<List<Category>> findAll(){
		try {
			return new  ResponseEntity<List<Category>>(categoryService.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<List<Category>>(HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * find id Category
	 * */
	@RequestMapping(value ="find/{id}", 
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			headers  = "Accept=application/json")
	public ResponseEntity<Category> find(@PathVariable("id") int id){
		try {
			
			return new  ResponseEntity<Category>(categoryService.find(id),HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<Category>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * create Category
	 * */
	@RequestMapping(value = "create", 
			method = RequestMethod.POST
		)
	public ResponseEntity<Void> create(
			@RequestBody Category category) {
		try {
			categoryService.create(category);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * update Category
	 * */
	
	
	@RequestMapping(value = "update", 
			method = RequestMethod.POST
		)
	public ResponseEntity<Void> update(
			@RequestBody Category category) {
		try {
			categoryService.update(category);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * delete Category
	 * */
	
	@RequestMapping(value = "delete/{id}", 
			method = RequestMethod.DELETE
	)
	public ResponseEntity<Void> delete(
			@PathVariable("id") int id) {
		try {
			categoryService.delete(categoryService.find(id));
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	

}
