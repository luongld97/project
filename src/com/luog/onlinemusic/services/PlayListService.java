package com.luog.onlinemusic.services;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Account;
import com.luog.onlinemusic.entity.commons.PlayList;
import com.luog.onlinemusic.entity.commons.Song;
import com.luog.onlinemusic.entity.rest.PlayListEntity;

public interface PlayListService {

	public List<PlayList> findAll();

	public PlayList find(int id);

	public boolean create(PlayList playList);

	public boolean update(PlayList playList);

	public boolean delete(PlayList playList);

	public List<PlayList> getPlayLists(Account account);

	public boolean contain(Song song, PlayList inPlayList);

	public List<PlayListEntity> getSongPlayList(PlayList playList);

	public boolean isExist(String name);

	public List<PlayList> randomPlayList(Account account, int limit, PlayList current);
}
