package com.luog.onlinemusic.entity.rest;

import java.util.List;

import com.luog.onlinemusic.entity.commons.Singer;

public class ChartEntity {
	
	private int songId;
	private String songName;
	private boolean video;
	private String link;
	private String lyric;
	private List<Singer> singers;
	private String date;
	private int listen;
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public boolean isVideo() {
		return video;
	}
	public void setVideo(boolean video) {
		this.video = video;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getLyric() {
		return lyric;
	}
	public void setLyric(String lyric) {
		this.lyric = lyric;
	}
	public List<Singer> getSingers() {
		return singers;
	}
	public void setSingers(List<Singer> singers) {
		this.singers = singers;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getListen() {
		return listen;
	}
	public void setListen(int listen) {
		this.listen = listen;
	}
	public ChartEntity(int songId, String songName, boolean video, String link, String lyric, List<Singer> singers,
			String date, int listen) {
		super();
		this.songId = songId;
		this.songName = songName;
		this.video = video;
		this.link = link;
		this.lyric = lyric;
		this.singers = singers;
		this.date = date;
		this.listen = listen;
	}
	public ChartEntity() {
		super();
	}
	
}
