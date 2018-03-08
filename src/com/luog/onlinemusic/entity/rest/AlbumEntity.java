package com.luog.onlinemusic.entity.rest;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class AlbumEntity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String photo;
	private String releasedTime;
	
	private String singers, songs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotEmpty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getReleasedTime() {
		return releasedTime;
	}

	public void setReleasedTime(String releasedTime) {
		this.releasedTime = releasedTime;
	}

	@NotEmpty
	public String getSingers() {
		return singers;
	}

	public void setSingers(String singers) {
		this.singers = singers;
	}

	@NotEmpty
	public String getSongs() {
		return songs;
	}

	public void setSongs(String songs) {
		this.songs = songs;
	}

	public AlbumEntity(Integer id, String name, String photo, String releasedTime, String singers, String songs) {
		super();
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.releasedTime = releasedTime;
		this.singers = singers;
		this.songs = songs;
	}

	public AlbumEntity() {
		super();
	}
	
	
	

}
