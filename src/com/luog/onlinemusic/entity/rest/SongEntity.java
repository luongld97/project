package com.luog.onlinemusic.entity.rest;

import java.util.List;

public class SongEntity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String link;
	private String lyric;
	private int listen;
	private boolean show;
	private boolean status;
	private boolean video;
	private String videoPhoto;
	private String videoLink;
	private String uploadedTime;
	private String uploadedBy;
	private List<Integer> singers;
	private List<Integer> authors;
	private List<Integer> categories;

	public SongEntity() {
	}

	public SongEntity(Integer id, String name, String link, String lyric, int listen, boolean show, boolean status,
			boolean video, String videoPhoto, String videoLink, String uploadedTime, String uploadedBy, List<Integer> singers,
			List<Integer> authors, List<Integer> categories) {
		this.id = id;
		this.name = name;
		this.link = link;
		this.lyric = lyric;
		this.listen = listen;
		this.show = show;
		this.status = status;
		this.video = video;
		this.videoPhoto = videoPhoto;
		this.videoLink = videoLink;
		this.uploadedTime = uploadedTime;
		this.uploadedBy = uploadedBy;
		this.singers = singers;
		this.authors = authors;
		this.categories = categories;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getListen() {
		return listen;
	}

	public void setListen(int listen) {
		this.listen = listen;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isVideo() {
		return video;
	}

	public void setVideo(boolean video) {
		this.video = video;
	}

	public String getVideoPhoto() {
		return videoPhoto;
	}

	public void setVideoPhoto(String videoPhoto) {
		this.videoPhoto = videoPhoto;
	}
	
	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public String getUploadedTime() {
		return uploadedTime;
	}

	public void setUploadedTime(String uploadedTime) {
		this.uploadedTime = uploadedTime;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public List<Integer> getSingers() {
		return singers;
	}

	public void setSingers(List<Integer> singers) {
		this.singers = singers;
	}

	public List<Integer> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Integer> authors) {
		this.authors = authors;
	}

	public List<Integer> getCategories() {
		return categories;
	}

	public void setCategories(List<Integer> categories) {
		this.categories = categories;
	}

}
