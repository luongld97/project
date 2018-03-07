package com.luog.onlinemusic.entity.rest;


import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

public class SongEntity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String link;
	private String lyric;
	private Integer listen;
	private boolean status;
	private boolean video;
	private Integer view;
	private String videoPhoto;
	private String videoLink;
	private String uploadedTime;
	private String uploadedBy;
	private String singers;
	private String authors;
	private String categories;

	public SongEntity() {
	}

	public SongEntity(Integer id, String name, String link, String lyric, Integer listen, boolean status, boolean video,
			Integer view, String videoPhoto, String videoLink, String uploadedTime, String uploadedBy, String singers,
			String authors, String categories) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.lyric = lyric;
		this.listen = listen;
		this.status = status;
		this.video = video;
		this.view = view;
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

	@NotEmpty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@URL
	@NotEmpty
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

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public void setListen(Integer listen) {
		this.listen = listen;
	}

	public Integer getListe() {
		return this.listen;
	}

	public String getVideoPhoto() {
		return videoPhoto;
	}

	public void setVideoPhoto(String videoPhoto) {
		this.videoPhoto = videoPhoto;
	}

	@URL
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

	public String getSingers() {
		return singers;
	}

	public void setSingers(String singers) {
		this.singers = singers;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

}
