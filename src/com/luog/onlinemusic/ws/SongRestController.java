package com.luog.onlinemusic.ws;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luog.onlinemusic.entity.commons.Chart;
import com.luog.onlinemusic.entity.commons.PlayList;
import com.luog.onlinemusic.entity.commons.PlayListDetail;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.ChartEntity;
import com.luog.onlinemusic.entity.rest.SongEntity;
import com.luog.onlinemusic.entity.rest.SongInfo;
import com.luog.onlinemusic.services.CategoryService;
import com.luog.onlinemusic.services.ChartService;
import com.luog.onlinemusic.services.PlayListDetailService;
import com.luog.onlinemusic.services.PlayListService;
import com.luog.onlinemusic.services.SingerService;
import com.luog.onlinemusic.services.SongService;

@RestController
@RequestMapping("song")
public class SongRestController {

	@Autowired
	private SongService songService;

	@Autowired
	private ChartService chartService;

	@Autowired
	private SingerService singerService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PlayListService playListService;

	@Autowired
	private PlayListDetailService playListDetailService;

	/**
	 * find all of song
	 */
	@RequestMapping(value = "findall", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public ResponseEntity<List<Song>> findAll() {
		try {
			return new ResponseEntity<List<Song>>(songService.randomSong(songService.find(1), true, 10), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Song>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "findsonginfo/{limit}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public ResponseEntity<List<SongInfo>> findSongInfo(@PathVariable("limit") int limit) {
		try {
			return new ResponseEntity<List<SongInfo>>(songService.findSongInfo(limit), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<SongInfo>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "findsongincategory/{categoryId}/{limit}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public ResponseEntity<List<SongInfo>> findSongInCategory(@PathVariable("categoryId") int categoryId, @PathVariable("limit") int limit) {
		try {
			return new ResponseEntity<List<SongInfo>>(songService.findSongInCategory(categoryService.find(categoryId), limit),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<SongInfo>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "findsongbysinger/{singerId}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public ResponseEntity<List<SongInfo>> findSongBySinger(@PathVariable("singerId") int singerId) {
		try {
			return new ResponseEntity<List<SongInfo>>(songService.findSongBySinger(singerService.find(singerId)),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<SongInfo>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "findmvsonginfo/{limit}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public ResponseEntity<List<SongInfo>> findMVSongInfo(@PathVariable("limit") int limit) {
		try {
			return new ResponseEntity<List<SongInfo>>(songService.findMVSongInfo(limit), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<SongInfo>>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * find id song
	 */
	@RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public ResponseEntity<Song> find(@PathVariable("id") int id) {
		try {

			return new ResponseEntity<Song>(songService.find(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Song>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * create song
	 */
	/*
	 * @RequestMapping(value = "create", method = RequestMethod.POST ) public
	 * ResponseEntity<Void> create(
	 * 
	 * @RequestBody Song song) { try { //songService.create(song); return new
	 * ResponseEntity<Void>(HttpStatus.OK); } catch (Exception e) { return new
	 * ResponseEntity<Void>(HttpStatus.BAD_REQUEST); } }
	 */
	/**
	 * update song
	 */

	/*
	 * @RequestMapping(value = "update", method = RequestMethod.POST ) public
	 * ResponseEntity<Void> update(
	 * 
	 * @RequestBody Song song) { try { //songService.update(song); return new
	 * ResponseEntity<Void>(HttpStatus.OK); } catch (Exception e) { return new
	 * ResponseEntity<Void>(HttpStatus.BAD_REQUEST); } }
	 */
	/**
	 * delete song
	 */

	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		try {
			// songService.delete(songService.find(id));
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = "/changelisten", method = RequestMethod.POST)
	public ResponseEntity<String> changeListen(@RequestBody String id,
			@RequestParam(value = "video", required = false) String video) {

		boolean result = false;
		try {
			boolean isVideo = video != null ? true : false;
			Date currentTime = new Date();
			Song currentSong = songService.find(Integer.parseInt(id));
			Chart currentChart = chartService.findChart(currentSong, currentTime, isVideo);
			if (currentChart != null) {
				result = chartService.increaseListen(currentChart);
			} else {
				currentChart = new Chart();
				currentChart.setSong(currentSong);
				currentChart.setDate(currentTime);
				currentChart.setListen(1);
				currentChart.setVideo(isVideo);
				result = chartService.create(currentChart);
			}
			String resultStr = result ? songService.getListen(currentSong, isVideo) + "" : result + "";
			return new ResponseEntity<String>(resultStr, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = "/getlisten", method = RequestMethod.GET)
	public ResponseEntity<String> getListen(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "video", required = false) String video) {
		try {
			if (id == null)
				throw new Exception();
			else {
				boolean isVideo = video != null ? true : false;
				Song currentSong = songService.find(id);
				Long listen = songService.getListen(currentSong, isVideo);
				return new ResponseEntity<String>((listen == null ? 0 : listen) + "", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = "/getsong", method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<SongEntity> getSong(@RequestBody int id) {
		try {
			SongEntity songEntity = songService.getSongEntity(id);
			return new ResponseEntity<SongEntity>(songEntity, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<SongEntity>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SongEntity>> findSongs(@RequestParam("keyword") String keyWord) {
		List<SongEntity> songEntities = null;
		try {
			songEntities = songService.findSongEntities(keyWord);
			return new ResponseEntity<List<SongEntity>>(songEntities, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<SongEntity>>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = "/tolist", method = RequestMethod.POST)
	public ResponseEntity<String> toPlayList(@RequestParam(value = "id", required = false) Integer id,
			@RequestBody String[] playListIds) {
		boolean result = false;
		try {
			if (playListIds != null && id != null) {
				Song currentSong = songService.find(id);
				if (currentSong != null) {
					int length = playListIds.length;
					for (int i = 0; i < length; i++) {
						int playListId = Integer.parseInt(playListIds[i]);
						PlayList currentPlayList = playListService.find(playListId);
						if (currentPlayList != null) {
							if (!playListService.contain(currentSong, currentPlayList)) {
								PlayListDetail playListDetail = new PlayListDetail();
								playListDetail.setPlayList(currentPlayList);
								playListDetail.setSong(currentSong);
								result = playListDetailService.create(playListDetail);
							} else {
								String returnStr = "'" + currentSong.getName() + "' already in: '"
										+ currentPlayList.getName() + "'";
								return new ResponseEntity<String>(returnStr, HttpStatus.BAD_REQUEST);
							}
						}
					}
				}
			} else {
				throw new Exception();
			}
			return new ResponseEntity<String>(result + "", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "gettopsong/{video}/{limit}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public ResponseEntity<List<SongEntity>> getTopSongs(@PathVariable("video") boolean isVideo,
			@PathVariable("limit") Integer limit) {
		try {
			return new ResponseEntity<List<SongEntity>>(songService.getTopSong(isVideo, new Date(), limit),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<SongEntity>>(HttpStatus.BAD_REQUEST);
		}
	}

}
