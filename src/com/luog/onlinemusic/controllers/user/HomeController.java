package com.luog.onlinemusic.controllers.user;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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

import com.luog.onlinemusic.entity.commons.Chart;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.SingerEntity;
import com.luog.onlinemusic.entity.rest.SongEntity;
import com.luog.onlinemusic.services.ChartService;
import com.luog.onlinemusic.services.SearchService;
import com.luog.onlinemusic.services.SongService;

@Controller
@RequestMapping("home")
public class HomeController {

	@Autowired
	private SearchService searchService;

	@Autowired
	private ChartService chartService;

	@Autowired
	private SongService songService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		List<Chart> currentCharts = null;
		Date chartTime = new Date();
		try {
			LocalDate localDate = chartTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			currentCharts = chartService.getChartsByMonth(chartTime, 5);
			if (currentCharts.isEmpty() || currentCharts.size() < 5) {
				chartTime = Date.from(localDate.minusMonths(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
				currentCharts = chartService.getChartsByMonth(chartTime, 5);
			}
		} catch (Exception e) {
			e.printStackTrace();
			currentCharts = new ArrayList<>();
		}
		modelMap.put("charts", currentCharts);
		return "home.index";
	}

	@RequestMapping(value = { "/video" }, method = RequestMethod.GET)
	public String video(HttpServletRequest request, ModelMap modelMap) {
		List<Song> videos = songService.findAll(true);
		PagedListHolder<Song> pagedListHolder = new PagedListHolder<>(videos);
		int page = ServletRequestUtils.getIntParameter(request, "page", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(20);

		modelMap.put("videos", pagedListHolder);
		return "home.video";
	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public String search(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "keyword", required = false) String keyWord) {
		if (keyWord != null) {
			List<Object> result = searchService.search(keyWord);
			PagedListHolder<Object> pagedListHolder = new PagedListHolder<>(result);
			int page = ServletRequestUtils.getIntParameter(request, "page", 0);
			pagedListHolder.setPage(page);
			pagedListHolder.setPageSize(20);

			modelMap.put("result", pagedListHolder);
			return "home.search";
		}
		return "redirect: ../home.html";
	}
}
