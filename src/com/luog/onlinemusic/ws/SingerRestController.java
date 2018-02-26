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

import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.services.SingerService;

@RestController
@RequestMapping("singer")
public class SingerRestController {
	
	@Autowired
	private SingerService singerService;
	
	/**
	 * find all of song
	 * */
	@RequestMapping(value ="findall", 
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			headers  = "Accept=application/json")
	public ResponseEntity<List<Singer>> findAll(){
		try {
			return new  ResponseEntity<List<Singer>>(singerService.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<List<Singer>>(HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * find id Singer
	 * */
	@RequestMapping(value ="find/{id}", 
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			headers  = "Accept=application/json")
	public ResponseEntity<Singer> find(@PathVariable("id") int id){
		try {
			
			return new  ResponseEntity<Singer>(singerService.find(id),HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<Singer>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * create Singer
	 * */
	@RequestMapping(value = "create", 
			method = RequestMethod.POST
		)
	public ResponseEntity<Void> create(
			@RequestBody Singer singer) {
		try {
			singerService.create(singer);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * update Singer
	 * */
	
	
	@RequestMapping(value = "update", 
			method = RequestMethod.POST
		)
	public ResponseEntity<Void> update(
			@RequestBody Singer singer) {
		try {
			singerService.update(singer);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * delete Singer
	 * */
	
	@RequestMapping(value = "delete/{id}", 
			method = RequestMethod.DELETE
	)
	public ResponseEntity<Void> delete(
			@PathVariable("id") int id) {
		try {
			singerService.delete(singerService.find(id));
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	

}
