package com.luog.onlinemusic.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.PlayList;
import com.luog.onlinemusic.entity.commons.PlayListDetail;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.PlayListEntity;
import com.luog.onlinemusic.services.PlayListDetailService;
import com.luog.onlinemusic.services.PlayListService;
import com.luog.onlinemusic.services.SongService;

@RestController
@RequestMapping("playlist")
public class PlaylistRestController {

	@Autowired
	private PlayListService playListService;

	@Autowired
	private SongService songService;

	@Autowired
	private PlayListDetailService playListDetailService;

	/**
	 * find all of song
	 */
	@RequestMapping(value = "findall", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public ResponseEntity<List<PlayList>> findAll() {
		try {
			return new ResponseEntity<List<PlayList>>(playListService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<PlayList>>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * find id PlayList
	 */
	@RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public ResponseEntity<PlayList> find(@PathVariable("id") int id) {
		try {

			return new ResponseEntity<PlayList>(playListService.find(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<PlayList>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * create PlayList
	 */
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody PlayList playList) {
		try {
			playListService.create(playList);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * update PlayList
	 */

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResponseEntity<Void> update(@RequestBody PlayList playList) {
		try {
			playListService.update(playList);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * delete PlayList
	 */

	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		try {
			playListService.delete(playListService.find(id));
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "getsongplaylist/{playListId}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public ResponseEntity<List<PlayListEntity>> getSongPlayList(@PathVariable("playListId") int playListId) {
		try {
			return new ResponseEntity<List<PlayListEntity>>(
					playListService.getSongPlayList(playListService.find(playListId)), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<List<PlayListEntity>>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = {
			"/quickadd" }, method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> quickAddPlayList(HttpSession session, @RequestBody String name) {
		try {
			if (!name.isEmpty()) {
				if (playListService.isExist(name))
					return new ResponseEntity<String>("Play list already exist!", HttpStatus.ACCEPTED);
				else {
					Account currentAccount = (Account) session.getAttribute("currentAccount");
					if (currentAccount != null) {
						PlayList playList = new PlayList();
						playList.setName(name);
						playList.setAccount(currentAccount);
						playList.setCreatedTime(new Date());
						playList.setPhoto("playlist-default.png");
						return playListService.create(playList)
								? new ResponseEntity<String>(playList.getId() + "", HttpStatus.OK)
								: new ResponseEntity<String>("Error, try again!", HttpStatus.ACCEPTED);
					}
					throw new Exception();

				}
			}
			return new ResponseEntity<String>("Name is required!", HttpStatus.ACCEPTED);

		} catch (Exception e) {
			return new ResponseEntity<String>("Hava some error, login and try again!", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = {
			"/removesong" }, method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> removeSongFromList(@RequestBody String data, HttpSession session,
			@RequestBody String name) {
		boolean result = false;
		try {
			Account account = (Account) session.getAttribute("currentAccount");
			if (account != null) {
				String[] arr = data.split(":");
				int playListId = Integer.parseInt(arr[0]);
				int songId = Integer.parseInt(arr[1]);
				PlayList playList = playListService.find(playListId);
				Song song = songService.find(songId);
				if (playList != null || song != null) {
					Set<PlayListDetail> playListDetails = playList.getPlayListDetails();
					int setSize = playListDetails.size();
					if (setSize > 0) {
						for (PlayListDetail playListDetail : playListDetails) {
							if (song.getId() == playListDetail.getSong().getId()) {
								result = playListDetailService.delete(playListDetail);
								break;
							}
						}
						if (result)
							return new ResponseEntity<String>(result + "", HttpStatus.OK);
					}

				}
			}
			throw new Exception();
		} catch (Exception e) {
			return new ResponseEntity<String>("Hava some error, login and try again!", HttpStatus.BAD_REQUEST);
		}
	}

}
