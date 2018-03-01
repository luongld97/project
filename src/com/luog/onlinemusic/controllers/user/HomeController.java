package com.luog.onlinemusic.controllers.user;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luog.onlinemusic.entity.commons.Chart;
import com.luog.onlinemusic.services.ChartService;

@Controller
@RequestMapping("home")
public class HomeController {

	@Autowired
	private ChartService chartService;

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

}
