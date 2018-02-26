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

import com.luog.onlinemusic.entity.commons.PlayList;
import com.luog.onlinemusic.services.PlayListService;

@RestController
@RequestMapping("playlist")
public class PlaylistRestController {
	
	@Autowired
	private PlayListService playlistService;
	
	/**
	 * find all of song
	 * */
	@RequestMapping(value ="findall", 
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			headers  = "Accept=application/json")
	public ResponseEntity<List<PlayList>> findAll(){
		try {
			return new  ResponseEntity<List<PlayList>>(playlistService.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<List<PlayList>>(HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * find id PlayList
	 * */
	@RequestMapping(value ="find/{id}", 
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			headers  = "Accept=application/json")
	public ResponseEntity<PlayList> find(@PathVariable("id") int id){
		try {
			
			return new  ResponseEntity<PlayList>(playlistService.find(id),HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<PlayList>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * create PlayList
	 * */
	@RequestMapping(value = "create", 
			method = RequestMethod.POST
		)
	public ResponseEntity<Void> create(
			@RequestBody PlayList playList) {
		try {
			playlistService.create(playList);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * update PlayList
	 * */
	
	
	@RequestMapping(value = "update", 
			method = RequestMethod.POST
		)
	public ResponseEntity<Void> update(
			@RequestBody PlayList playList) {
		try {
			playlistService.update(playList);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * delete PlayList
	 * */
	
	@RequestMapping(value = "delete/{id}", 
			method = RequestMethod.DELETE
	)
	public ResponseEntity<Void> delete(
			@PathVariable("id") int id) {
		try {
			playlistService.delete(playlistService.find(id));
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	

}
