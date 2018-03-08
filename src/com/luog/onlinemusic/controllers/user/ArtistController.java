package com.luog.onlinemusic.controllers.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luog.onlinemusic.entity.commons.Album;
import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.services.AlbumService;
import com.luog.onlinemusic.services.SingerService;
import com.luog.onlinemusic.services.SongService;

@Controller
@RequestMapping("artist")
public class ArtistController {

	@Autowired
	private SingerService singerService;

	@Autowired
	private SongService songService;

	@Autowired
	private AlbumService albumService;

	private final int LIST_SONG_LIMIT = 7;

	/**
	 * @author luog
	 */
	@RequestMapping(value = { "/singer/index", "/singer", "singer/info" }, method = RequestMethod.GET)
	public String index(@RequestParam(value = "id", required = false) Integer id, ModelMap modelMap) {
		String tileName = "home.index";
		if (id != null) {
			Singer currentSinger = singerService.find(id);
			if (currentSinger != null) {
				List<Song> videos = songService.randomSong(4, true, currentSinger);
				List<Album> albums = albumService.randomAlbumOfSinger(4, currentSinger);
				modelMap.put("albums", albums);
				modelMap.put("videos", videos);
				modelMap.put("singer", currentSinger);
				modelMap.put("topSongs", songService.getTopSongs(currentSinger, LIST_SONG_LIMIT));
				tileName = "artist.singer.index";
			}
		}
		return tileName;
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = { "/singer/allsinger", "singer/list" }, method = RequestMethod.GET)
	public String allSingers(HttpServletRequest request, ModelMap modelMap) {
		List<Singer> singers = singerService.findAll();
		PagedListHolder<Singer> pagedListHolder = new PagedListHolder<>(singers);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(30);
		System.out.println(pagedListHolder.getPageList().size());
		modelMap.put("singers", pagedListHolder);
		return "artist.singer.allsinger";
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = "/singer/play-list", method = RequestMethod.GET)
	public String playTopSongs(@RequestParam(value = "id", required = false) Integer id, ModelMap modelMap) {
		String tileName = "home.index";
		if (id != null) {
			Singer currentSinger = singerService.find(id);
			if (currentSinger != null) {
				modelMap.put("singer", currentSinger);
				modelMap.put("songs", songService.getTopSongs(currentSinger, LIST_SONG_LIMIT));
				tileName = "list.song.play";
			}
		}
		return tileName;
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = "/singer/song", method = RequestMethod.GET)
	public String singerSong(HttpServletRequest request, @RequestParam(value = "id", required = false) Integer id,
			ModelMap modelMap) {
		String tileName = "home.index";
		if (id != null) {
			Singer currentSinger = singerService.find(id);
			if (currentSinger != null) {
				List<Song> songs = songService.getTopSongs(currentSinger, null);
				PagedListHolder<Song> pagedListHolder = new PagedListHolder<>(songs);
				int page = ServletRequestUtils.getIntParameter(request, "page", 0);
				pagedListHolder.setPage(page);
				pagedListHolder.setPageSize(12);
				modelMap.put("songs", pagedListHolder);
				modelMap.put("singer", currentSinger);
				tileName = "artist.singer.song";
			}
		}
		return tileName;
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = "/singer/album", method = RequestMethod.GET)
	public String singerAlbum(HttpServletRequest request, @RequestParam(value = "id", required = false) Integer id,
			ModelMap modelMap) {
		String tileName = "home.index";
		if (id != null) {
			Singer currentSinger = singerService.find(id);
			if (currentSinger != null) {
				List<Album> albums = albumService.getAlbums(currentSinger);
				PagedListHolder<Album> pagedListHolder = new PagedListHolder<>(albums);
				int page = ServletRequestUtils.getIntParameter(request, "page", 0);
				pagedListHolder.setPage(page);
				pagedListHolder.setPageSize(20);
				modelMap.put("albums", pagedListHolder);
				modelMap.put("singer", currentSinger);
				tileName = "artist.singer.album";
			}
		}
		return tileName;
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = "/singer/video", method = RequestMethod.GET)
	public String singerVideo(HttpServletRequest request, @RequestParam(value = "id", required = false) Integer id,
			ModelMap modelMap) {
		String tileName = "home.index";
		if (id != null) {
			Singer currentSinger = singerService.find(id);
			if (currentSinger != null) {
				List<Song> songs = songService.getTopSongs(currentSinger, null);
				PagedListHolder<Song> pagedListHolder = new PagedListHolder<>(songs);
				int page = ServletRequestUtils.getIntParameter(request, "page", 0);
				pagedListHolder.setPage(page);
				pagedListHolder.setPageSize(20);
				modelMap.put("songs", pagedListHolder);
				modelMap.put("singer", currentSinger);
				tileName = "artist.singer.video";
			}
		}
		return tileName;
	}

	/**
	 * @author luog
	 */
	@RequestMapping(value = "/singer/story", method = RequestMethod.GET)
	public String singerStory(HttpServletRequest request, @RequestParam(value = "id", required = false) Integer id,
			ModelMap modelMap) {
		String tileName = "home.index";
		if (id != null) {
			Singer currentSinger = singerService.find(id);
			if (currentSinger != null) {
				modelMap.put("singer", currentSinger);
				tileName = "artist.singer.story";
			}
		}
		return tileName;
	}

}
