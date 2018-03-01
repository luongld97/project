package com.luog.onlinemusic.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.CommentEntity;
import com.luog.onlinemusic.services.CommentService;
import com.luog.onlinemusic.services.SongService;

@RestController
@RequestMapping("comment")
public class CommentRestController {

	@Autowired
	private SongService songService;

	@Autowired
	private CommentService commentService;

	/**
	 * @author luog
	 */
	@RequestMapping(
			value = "getallcomments", 
			method = RequestMethod.POST, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE
		)
	public ResponseEntity<List<CommentEntity>> findAllComments(@RequestBody(required = false) Integer id) {
		try {
			List<CommentEntity> commentEntities = null;
			if (id != null) {
				Song currentSong = songService.find(id);
				if (currentSong != null) {
					commentEntities = commentService.getComments(currentSong);
				}
			} else
				commentEntities = new ArrayList<>();
			return new ResponseEntity<List<CommentEntity>>(commentEntities, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<CommentEntity>>(HttpStatus.BAD_REQUEST);
		}
	}

}
