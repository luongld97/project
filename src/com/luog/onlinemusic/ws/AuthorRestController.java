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

import com.luog.onlinemusic.entity.commons.Author;
import com.luog.onlinemusic.entity.commons.Author;
import com.luog.onlinemusic.services.AuthorService;

@RestController
@RequestMapping("author")
public class AuthorRestController {
	
	@Autowired
	private AuthorService authorService;
	
	/**
	 * find all of song
	 * */
	@RequestMapping(value ="findall", 
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			headers  = "Accept=application/json")
	public ResponseEntity<List<Author>> findAll(){
		try {
			return new  ResponseEntity<List<Author>>(authorService.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<List<Author>>(HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * find id Author
	 * */
	@RequestMapping(value ="find/{id}", 
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			headers  = "Accept=application/json")
	public ResponseEntity<Author> find(@PathVariable("id") int id){
		try {
			
			return new  ResponseEntity<Author>(authorService.find(id),HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<Author>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * create Author
	 * */
	@RequestMapping(value = "create", 
			method = RequestMethod.POST
		)
	public ResponseEntity<Void> create(
			@RequestBody Author author) {
		try {
			authorService.create(author);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * update Author
	 * */
	
	
	@RequestMapping(value = "update", 
			method = RequestMethod.POST
		)
	public ResponseEntity<Void> update(
			@RequestBody Author author) {
		try {
			authorService.update(author);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * delete Author
	 * */
	
	@RequestMapping(value = "delete/{id}", 
			method = RequestMethod.DELETE
	)
	public ResponseEntity<Void> delete(
			@PathVariable("id") int id) {
		try {
			authorService.delete(authorService.find(id));
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	

}
