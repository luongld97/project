package com.luog.onlinemusic.services;

import java.util.List;

import com.luog.onlinemusic.entity.commons.AlbumSinger;
import com.luog.onlinemusic.entity.rest.AlbumSingerEntity;

public interface AlbumSingerService {

	public List<AlbumSinger> findAll();

	public AlbumSinger find(int id);

	public boolean create(AlbumSinger albumSinger);

	public boolean update(AlbumSinger albumSinger);

	public boolean delete(AlbumSinger albumSinger);

	public List<AlbumSingerEntity> findAlbumSinger();
}
