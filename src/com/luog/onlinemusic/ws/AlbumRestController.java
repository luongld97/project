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

import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.commons.AlbumSinger;
import com.luog.onlinemusic.entity.rest.AlbumSongEntity;
import com.luog.onlinemusic.entity.rest.AlbumSingerEntity;
import com.luog.onlinemusic.services.AlbumService;
import com.luog.onlinemusic.services.AlbumSingerService;
import com.luog.onlinemusic.services.AlbumSongService;

@RestController
@RequestMapping("album")
public class AlbumRestController {
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private AlbumSongService albumSongService;
	
	@Autowired
	private AlbumSingerService albumSingerService;
	
	/**
	 * find all of Album
	 * */
	@RequestMapping(value ="findall", 
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			headers  = "Accept=application/json")
	public ResponseEntity<List<Album>> findAll(){
		try {
			return new  ResponseEntity<List<Album>>(albumService.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<List<Album>>(HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * find id Album
	 * */
	@RequestMapping(value ="find/{id}", 
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			headers  = "Accept=application/json")
	public ResponseEntity<Album> find(@PathVariable("id") int id){
		try {
			
			return new  ResponseEntity<Album>(albumService.find(id),HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<Album>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	@RequestMapping(value ="findalbumsinger",
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			headers  = "Accept=application/json")
	public ResponseEntity<List<AlbumSingerEntity>> findAlbumSinger(){
		try {
			List<AlbumSingerEntity> albumsingers = albumSingerService.findAlbumSinger();
			System.out.println(albumsingers.get(0));
			return new  ResponseEntity<List<AlbumSingerEntity>>(albumsingers, HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<List<AlbumSingerEntity>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value ="findalbumsong",
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			headers  = "Accept=application/json")
	public ResponseEntity<List<AlbumSongEntity>> findAlbumSong(){
		try {
			return new  ResponseEntity<List<AlbumSongEntity>>(albumSongService.findAlbumSong(), HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<List<AlbumSongEntity>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(value ="getsongbyalbum/{albumId}", 
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			headers  = "Accept=application/json")
	public ResponseEntity<List<AlbumSongEntity>> findSongByAlbum(@PathVariable("albumId") int albumId){
		try {
			
			return new ResponseEntity<List<AlbumSongEntity>>(albumSongService.getSongByAlbum(albumService.find(albumId)), HttpStatus.OK);
			
		} catch (Exception e) {
			return new  ResponseEntity<List<AlbumSongEntity>>(HttpStatus.BAD_REQUEST);
		}
	}
	

}
