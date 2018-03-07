package com.luog.onlinemusic.controllers.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import com.luog.onlinemusic.entity.commons.AlbumSong;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.services.AlbumService;
import com.luog.onlinemusic.services.SongService;

@Controller
@RequestMapping("album")
public class AlbumController {

	@Autowired
	private AlbumService albumService;

	@Autowired
	private SongService songService;

	@RequestMapping(value = { "/", "/allalbum", "/index" }, method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap modelMap) {
		List<Album> albums = albumService.findAll();
		PagedListHolder<Album> pagedListHolder = new PagedListHolder<>(albums);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(20);
		modelMap.put("albums", pagedListHolder);
		return "album.index";
	}

	@RequestMapping(value = { "/play" }, method = RequestMethod.GET)
	public String playAlbum(ModelMap modelMap, @RequestParam(value = "id", required = false) Integer id) {
		if (id != null) {
			Album album = albumService.find(id);
			List<Song> songs = new ArrayList<>();
			Set<AlbumSong> albumSongs = album.getAlbumSongs();
			for (AlbumSong albumSong : albumSongs) {
				songs.add(albumSong.getSong());
			}
			modelMap.put("songs", songs);
			List<Song> suggestedSongs = songService.randomSong(10, null);
			modelMap.put("suggestedSongs", suggestedSongs);
			return "list.song.play";
		}
		return "redirect:../album/index.html";
	}
}
