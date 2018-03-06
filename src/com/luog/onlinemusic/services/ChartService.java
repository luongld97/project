package com.luog.onlinemusic.services;

import java.util.Date;
import java.util.List;

import com.luog.onlinemusic.entity.commons.Chart;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.ChartEntity;

public interface ChartService {
	public List<Chart> findAll();

	public Chart find(int id);

	public boolean create(Chart chart);

	public boolean update(Chart chart);

	public boolean delete(Chart chart);

	public List<ChartEntity> getTopSongs(boolean isVideo, Integer limit);

	/**
	 * @author luog
	 */
	public Chart findChart(Song song, Date currentDate, boolean isVideo);

	/**
	 * @author luog
	 */
	public List<Chart> getChartsByMonth(Date currentDate, Integer limit);

	/**
	 * @author luog
	 */
	public boolean increaseChartListen(Chart chart);
}
