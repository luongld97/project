package com.luog.onlinemusic.controllers.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luog.onlinemusic.services.ChartService;

@Controller
@RequestMapping("home")
public class HomeController {

	@Autowired
	private ChartService chartService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("charts", chartService.getChartsByMonth(new Date(), 5));
		return "home.index";
	}

}
