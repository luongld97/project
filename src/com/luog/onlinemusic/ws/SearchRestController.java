package com.luog.onlinemusic.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luog.onlinemusic.services.SearchService;

@RestController
@RequestMapping("search")
public class SearchRestController {

	@Autowired
	private SearchService searchService;
	
	@RequestMapping(
			value = "searchname", 
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE
		)
	public ResponseEntity<List<Object>> findSongs(@RequestParam("keyword") String keyWord) {
		List<Object> result = null;
		try {
			result = searchService.searchWS(keyWord);
			return new ResponseEntity<List<Object>>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Object>>(HttpStatus.BAD_REQUEST);
		}
	}
}
