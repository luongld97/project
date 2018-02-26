package com.luog.onlinemusic.ws;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luog.onlinemusic.entity.commons.Chart;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.SongEntity;
import com.luog.onlinemusic.services.ChartService;
import com.luog.onlinemusic.services.SongService;

@RestController
@RequestMapping("song")
public class SongRest {

	@Autowired
	private SongService songService;

	@Autowired
	private ChartService chartService;

	@RequestMapping(value = "changelisten", method = RequestMethod.POST)
	public ResponseEntity<Boolean> changeListen(@RequestBody String id) {

		boolean result = false;
		try {
			Date currentTime = new Date();
			Song currentSong = songService.find(Integer.parseInt(id));
			Chart currentChart = chartService.findChart(currentSong, currentTime);
			if (currentChart != null) {
				result = chartService.increaseChartListen(currentChart);
			} else {
				currentChart = new Chart();
				currentChart.setSong(currentSong);
				currentChart.setDate(currentTime);
				currentChart.setListen(1);
				result = chartService.create(currentChart);
			}
			result = songService.increaseSongListen(currentSong);
			return new ResponseEntity<Boolean>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(
			value = "getsong", 
			method = RequestMethod.POST, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<SongEntity> getSong(@RequestBody int id) {
		try {
			SongEntity songEntity = songService.getSongEntity(id);
			return new ResponseEntity<SongEntity>(songEntity, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<SongEntity>(HttpStatus.BAD_REQUEST);
		}
	}
}
