package com.luog.onlinemusic.entity.rest;

public class ChartEntity {
	
	private int songId;
	private String songName;
	private boolean video;
	private String link;
	private String lyric;
	private String singerName;
	private String singerPhoto;
	private String date;
	private int listen;
	
	public boolean isVideo() {
		return video;
	}
	public void setVideo(boolean video) {
		this.video = video;
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
	public String getLyric() {
		return lyric;
	}
	public void setLyric(String lyric) {
		this.lyric = lyric;
	}
	public String getSingerName() {
		return singerName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	public String getSingerPhoto() {
		return singerPhoto;
	}
	public void setSingerPhoto(String singerPhoto) {
		this.singerPhoto = singerPhoto;
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
	public ChartEntity(int songId, String songName, String link, String lyric, String singerName, String singerPhoto,
			String date, int listen, boolean video) {
		super();
		this.songId = songId;
		this.songName = songName;
		this.link = link;
		this.lyric = lyric;
		this.singerName = singerName;
		this.singerPhoto = singerPhoto;
		this.date = date;
		this.listen = listen;
		this.video = video;
	}
	public ChartEntity() {
		super();
	}
	
}
