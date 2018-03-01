package com.luog.onlinemusic.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.services.SingerService;
import com.luog.onlinemusic.services.SongService;

@Controller
@RequestMapping("artist")
public class ArtistController {
	
	@Autowired
	private SingerService singerService;
	
	@Autowired
	private SongService songService;

	@RequestMapping(value = { "/index", "/", "info" }, method = RequestMethod.GET)
	public String index(@RequestParam(value = "id", required = false) Integer id, ModelMap modelMap) {
		String tileName = "home.index";
		if (id != null) {
			Singer currentSinger = singerService.find(id);
			if (currentSinger != null) {
				modelMap.put("singer", currentSinger);
				modelMap.put("topSongs", songService.getTopSongs(currentSinger, 7));
				tileName = "artist.singer.index";
			}
		}
		return tileName;
	}
}
