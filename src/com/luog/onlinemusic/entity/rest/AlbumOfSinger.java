package com.luog.onlinemusic.entity.rest;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AlbumOfSinger implements Serializable{
	private int albumId;
	private String albumName;
	private int singerId;
	private String singerName;
	private String singerPhoto;
	
	public String getSingerPhoto() {
		return singerPhoto;
	}
	public void setSingerPhoto(String singerPhoto) {
		this.singerPhoto = singerPhoto;
	}
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
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
	public AlbumOfSinger(int albumId, String albumName, int singerId, String singerName, String singerPhoto) {
		super();
		this.albumId = albumId;
		this.albumName = albumName;
		this.singerId = singerId;
		this.singerName = singerName;
		this.singerPhoto = singerPhoto;
	}
	public AlbumOfSinger() {
		super();
	}
	
	
}
