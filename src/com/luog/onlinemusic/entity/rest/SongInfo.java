package com.luog.onlinemusic.entity.rest;

import java.io.Serializable;

public class SongInfo implements Serializable{
	private int id;
	private String name;
	private int singerId;
	private String singerName;
	private String singerPhoto;
	private String link;
	private int albumId;
	private String lyric;
	private boolean isVideo;
	private String videoLink;
	
	public String getVideoLink() {
		return videoLink;
	}
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}
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
	public int getSingerId() {
		return singerId;
	}
	public void setSingerId(int singerId) {
		this.singerId = singerId;
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
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
	public SongInfo() {
		super();
	}
	
	public SongInfo(int id, String name, int singerId, String singerName, String singerPhoto, String link, int albumId,
			String lyric, boolean isVideo, String videoLink) {
		super();
		this.id = id;
		this.name = name;
		this.singerId = singerId;
		this.singerName = singerName;
		this.singerPhoto = singerPhoto;
		this.link = link;
		this.albumId = albumId;
		this.lyric = lyric;
		this.isVideo = isVideo;
		this.videoLink = videoLink;
	}
	
}
