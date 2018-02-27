package com.luog.onlinemusic.entity.rest;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AlbumSingerEntity implements Serializable{
	private int id;
	private String name;
	private int singerId;
	private String singerName;
	private String singerPhoto;
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
	public AlbumSingerEntity(int id, String name, int singerId, String singerName, String singerPhoto) {
		super();
		this.id = id;
		this.name = name;
		this.singerId = singerId;
		this.singerName = singerName;
		this.singerPhoto = singerPhoto;
	}
	public AlbumSingerEntity() {
		super();
	}
	
}
