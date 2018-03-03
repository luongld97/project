package com.luog.onlinemusic.controllers.admin;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;

import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.services.AuthorService;
import com.luog.onlinemusic.services.CategoryService;
import com.luog.onlinemusic.services.SingerService;
import com.luog.onlinemusic.services.SongService;
import com.luog.onlinemusic.validators.SongValidator;

@Controller
@RequestMapping("admin/song**")
public class AdminSongManagementController implements ServletContextAware {

	private ServletContext servletContext;

	@Autowired
	private SongService songService;

	@Autowired
	private SingerService singerService;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SongValidator songValidator;

	@RequestMapping(value = { "", "allsong", "index" }, method = RequestMethod.GET)
	public String allSongs(HttpServletRequest request, ModelMap modelMap) {
		List<Song> songs = songService.findAll();
		PagedListHolder<Song> pagedListHolder = new PagedListHolder<>(songs);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(10);
		modelMap.put("currentTab", "song");
		modelMap.put("songs", pagedListHolder);
		modelMap.put("currentPage", page);
		return "admin.song.allsong";
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
