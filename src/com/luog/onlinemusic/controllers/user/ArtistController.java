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

import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.services.SingerService;
import com.luog.onlinemusic.services.SongService;

@Controller
@RequestMapping("artist")
public class ArtistController {

	@Autowired
	private SingerService singerService;

	@Autowired
	private SongService songService;

	/**
	 * @author luog
	 */
	@RequestMapping(value = { "/singer/index", "/singer", "singer/info" }, method = RequestMethod.GET)
	public String index(@RequestParam(value = "id", required = false) Integer id, ModelMap modelMap) {
		String tileName = "home.index";
		if (id != null) {
			Singer currentSinger = singerService.find(id);
			if (currentSinger != null) {
				modelMap.put("singer", currentSinger);
				modelMap.put("topSongs", songService.getTopSongs(currentSinger, 5));
				tileName = "artist.singer.index";
			}
		}
		return tileName;
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
				modelMap.put("songs", songService.getTopSongs(currentSinger, 5));
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
}
