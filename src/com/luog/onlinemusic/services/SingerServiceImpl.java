package com.luog.onlinemusic.services;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luog.onlinemusic.dao.SingerDAO;
import com.luog.onlinemusic.entity.commons.Singer;
import com.luog.onlinemusic.entity.rest.SingerEntity;

@Transactional
@Service("singerService")
public class SingerServiceImpl implements SingerService {

	@Autowired
	private SingerDAO singerDAO;

	@Override
	public List<Singer> findAll() {
		return singerDAO.findAll();
	}

	@Override
	public Singer find(int id) {
		return singerDAO.find(id);
	}
	
	@Override
	public boolean create(Singer singer) {
		return singerDAO.create(singer);
	}
	
	@Override
	public boolean update(Singer singer) {
		return singerDAO.update(singer);
	}
	
	/**
	 * @author luog
	 */
	@Override
	public boolean create(SingerEntity temp) {
		boolean result = false;
		SimpleDateFormat simpleDateFormat = null;
		try {
			Singer singer = new Singer();
			singer.setName(temp.getName());
			singer.setNickName(temp.getNickName());
			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			singer.setDateOfBirth(
					simpleDateFormat.parse(temp.getDateOfBirth())
				);
			singer.setGender(temp.getGender());
			singer.setDescription(temp.getDescription());
			singer.setPhoto(temp.getPhoto());
			result = singerDAO.create(singer);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	
	/**
	 * @author luog
	 */
	@Override
	public boolean update(SingerEntity temp) {
		boolean result = false;
		SimpleDateFormat simpleDateFormat = null;
		try {
			Singer singer = singerDAO.find(temp.getId());
			if (singer != null) {
				singer.setName(temp.getName());
				singer.setNickName(temp.getNickName());
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				singer.setDateOfBirth(
						simpleDateFormat.parse(temp.getDateOfBirth())
					);
				singer.setGender(temp.getGender());
				singer.setDescription(temp.getDescription());
				if (temp.getPhoto() != null)
					singer.setPhoto(temp.getPhoto());
				result = singerDAO.update(singer);
			} else result = false;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	
	@Override
	public boolean delete(Singer singer) {
		return singerDAO.delete(singer);
	}

	@Override
	public List<SingerEntity> findSingerEntities(String keyWord) {
		return singerDAO.findSingerEntities(keyWord);
	}


}
