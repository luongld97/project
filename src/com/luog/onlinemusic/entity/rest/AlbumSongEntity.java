package com.luog.onlinemusic.entity.rest;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AlbumSongEntity implements Serializable{
	private int id;
	private String name;
	private int songId;
	private String songName;
	private String link;
	private String singerName;
	private String lyric;
	private boolean isVideo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getSingerName() {
		return singerName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	public String getLyric() {
		return lyric;
	}
	public void setLyric(String lyric) {
		this.lyric = lyric;
	}
	public boolean isVideo() {
		return isVideo;
	}
	public void setVideo(boolean isVideo) {
		this.isVideo = isVideo;
	}
	public AlbumSongEntity() {
		super();
	}
	
}
