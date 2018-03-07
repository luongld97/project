package com.luog.onlinemusic.controllers.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.Chart;
import com.luog.onlinemusic.entity.commons.PlayList;
import com.luog.onlinemusic.entity.commons.PlayListDetail;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.services.ChartService;
import com.luog.onlinemusic.services.PlayListService;
import com.luog.onlinemusic.services.SongService;

@Controller
@RequestMapping("song")
public class SongController {

	@Autowired
	private SongService songService;

	@Autowired
	private PlayListService playListService;

	@Autowired
	private ChartService chartService;

	@RequestMapping(value = "/play", method = RequestMethod.GET)
	public String playSong(@RequestParam(value = "id", required = false) Integer songid, ModelMap modelMap,
			@RequestParam(value = "video", required = false) String video) {
		if (songid != null) {
			Song song = songService.find(songid);
			if (song != null) {
				List<Song> suggestedSongs = songService.randomSong(10, song);
				boolean isVideo = (video != null && song.isVideo()) ? true : false;
				modelMap.put("song", song);
				modelMap.put("suggestedSongs", suggestedSongs);
				modelMap.put("isVideo", isVideo);
				modelMap.put("listen", songService.getListen(song, isVideo));
				return "song.play";
			}

		}
		return "redirect:../home.html";
	}

	@RequestMapping(value = "/playlist", method = RequestMethod.GET)
	public String playListSong(@RequestParam(value = "id", required = false) Integer id, ModelMap modelMap) {
		List<Song> songs = new ArrayList<>();
		if (id == null) {
			List<Chart> charts = chartService.getChartsByMonth(new Date(), 20);
			for (Chart chart : charts)
				songs.add(chart.getSong());
		} else {
			PlayList currentPlayList = playListService.find(id);
			for (PlayListDetail playListDetail : currentPlayList.getPlayListDetails()) {
				songs.add(playListDetail.getSong());
			}
		}
		modelMap.put("songs", songs);
		List<Song> suggestedSongs = songService.randomSong(10, null);
		modelMap.put("suggestedSongs", suggestedSongs);
		return "list.song.play";
	}

	@RequestMapping(value = { "/tolist" }, method = RequestMethod.GET)
	public String toPlayListForm(HttpSession session, ModelMap modelMap) {
		Account currentAccount = (Account) session.getAttribute("currentAccount");
		modelMap.put("playLists", playListService.getPlayLists(currentAccount));
		return "song.to.play.list";

	}

}
