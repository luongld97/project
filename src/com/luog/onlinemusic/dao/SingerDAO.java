package com.luog.onlinemusic.dao;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Singer;

public interface SingerDAO {

	public List<Singer> findAll();

	public Singer find(int id);

	public boolean create(Singer singer);

	public boolean update(Singer singer);

	public boolean delete(Singer singer);
}