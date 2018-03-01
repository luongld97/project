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

import com.luog.onlinemusic.entity.commons.Chart;
import com.luog.onlinemusic.services.ChartService;

@RestController
@RequestMapping("chart")
public class ChartRestController {
	
	@Autowired
	private ChartService chartService;
	
	/**
	 * find all of chart
	 * */
	@RequestMapping(value ="findall", 
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			headers  = "Accept=application/json")
	public ResponseEntity<List<Chart>> findAll(){
		try {
			return new  ResponseEntity<List<Chart>>(chartService.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<List<Chart>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * find id chart
	 * */
	@RequestMapping(value ="find/{id}", 
			method = RequestMethod.GET, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			headers  = "Accept=application/json")
	public ResponseEntity<Chart> find(@PathVariable("id") int id){
		try {
			
			return new  ResponseEntity<Chart>(chartService.find(id),HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<Chart>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * create chart
	 * */
	@RequestMapping(value = "create", 
			method = RequestMethod.POST
		)
	public ResponseEntity<Void> create(
			@RequestBody Chart chart) {
		try {
			chartService.create(chart);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * update chart
	 * */
	
	
	@RequestMapping(value = "update", 
			method = RequestMethod.POST
		)
	public ResponseEntity<Void> update(
			@RequestBody Chart chart) {
		try {
			chartService.update(chart);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	/**
	 * delete chart,
	 * */
	
	@RequestMapping(value = "delete/{id}", 
			method = RequestMethod.DELETE
	)
	public ResponseEntity<Void> delete(
			@PathVariable("id") int id) {
		try {
			chartService.delete(chartService.find(id));
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
}
