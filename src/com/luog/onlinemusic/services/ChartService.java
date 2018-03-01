package com.luog.onlinemusic.services;

import java.util.Date;
import java.util.List;

import com.luog.onlinemusic.entity.commons.Chart;
import com.luog.onlinemusic.entity.commons.Song;

public interface ChartService {
	public List<Chart> findAll();
	
	public Chart find(int id);

	public boolean create(Chart chart);
	
	public boolean update(Chart chart);
	
	public boolean delete(Chart chart);
	
	/**
	 * @author luog
	 */
	public Chart findChart(Song song, Date currentDate);
	
	/**
	 * @author luog
	 */
	public List<Chart> getChartsByMonth(Date currentDate, Integer limit);
	
	/**
	 * @author luog
	 */
	public boolean increaseChartListen(Chart chart);
}
