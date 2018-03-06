package com.luog.onlinemusic.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.ChartDAO;
import com.luog.onlinemusic.entity.commons.Chart;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.ChartEntity;

@Transactional
@Service("chartService")
public class ChartServiceImpl implements ChartService {

	@Autowired
	private ChartDAO chartDAO;

	@Override
	public List<Chart> findAll() {
		return chartDAO.findAll();
	}
	
	@Override
	public Chart find(int id) {
		return chartDAO.find(id);
	}

	@Override
	public boolean create(Chart chart) {
		return chartDAO.create(chart);
	}

	@Override
	public boolean update(Chart chart) {
		return chartDAO.update(chart);
	}

	@Override
	public boolean delete(Chart chart) {
		return chartDAO.delete(chart);
	}

	@Override
	public Chart findChart(Song song, Date currentDate, boolean isVideo) {
		return chartDAO.findChart(song, currentDate, isVideo);
	}

	@Override
	public List<Chart> getChartsByMonth(Date currentDate, Integer limit) {
		return chartDAO.getChartsByMonth(currentDate, limit);
	}

	@Override
	public boolean increaseChartListen(Chart chart) {
		boolean result = false;
		try {
			int currentChartListen = chart.getListen();
			chart.setListen(currentChartListen + 1);
			result = chartDAO.update(chart);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	@Override
	public List<ChartEntity> getTopSongs(boolean isVideo, Integer limit) {
		return chartDAO.getTopSongs(isVideo, limit);
	}

}
