package com.luog.onlinemusic.dao;

import java.util.Date;
import java.util.List;

import com.luog.onlinemusic.entity.commons.Chart;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.ChartEntity;

public interface ChartDAO {
	public List<Chart> findAll();
	
	public Chart find(int id);

	public boolean create(Chart chart);

	public boolean update(Chart chart);

	public boolean delete(Chart chart);
	
	public List<ChartEntity> getTopSongs(boolean isVideo, Integer limit);
	
	public Chart findChart(Song song, Date currentDate, boolean isVideo);
	
	public List<Chart> getChartsByMonth(Date currentDatem, Integer limit);
	
}
