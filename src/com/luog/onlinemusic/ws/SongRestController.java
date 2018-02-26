package com.luog.onlinemusic.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.SongInfo;
import com.luog.onlinemusic.services.SongService;

@RestController
@RequestMapping("song")
public class SongRestController {
	
	@Autowired
	private SongService songService;
	
	/**
	 * find all of song
	 * */
	@RequestMapping(value ="findall", 
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			headers  = "Accept=application/json")
	public ResponseEntity<List<Song>> findAll(){
		try {
			return new  ResponseEntity<List<Song>>(songService.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<List<Song>>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value ="findsonginfo",
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			headers  = "Accept=application/json")
	public ResponseEntity<List<SongInfo>> findSongInfo(){
		try {
			return new  ResponseEntity<List<SongInfo>>(songService.findSongInfo(), HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<List<SongInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	/**
	 * find id song
	 * */
	@RequestMapping(value ="find/{id}", 
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			headers  = "Accept=application/json")
	public ResponseEntity<Song> find(@PathVariable("id") int id){
		try {
			
			return new  ResponseEntity<Song>(songService.find(id),HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<Song>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * create song
	 * */
	/*@RequestMapping(value = "create", 
			method = RequestMethod.POST
		)
	public ResponseEntity<Void> create(
			@RequestBody Song song) {
		try {
			//songService.create(song);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}*/
	/**
	 * update song
	 * */
	
	
	/*@RequestMapping(value = "update", 
			method = RequestMethod.POST
		)
	public ResponseEntity<Void> update(
			@RequestBody Song song) {
		try {
			//songService.update(song);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}*/
	/**
	 * delete song
	 * */
	
	@RequestMapping(value = "delete/{id}", 
			method = RequestMethod.DELETE
	)
	public ResponseEntity<Void> delete(
			@PathVariable("id") int id) {
		try {
			//songService.delete(songService.find(id));
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	

}