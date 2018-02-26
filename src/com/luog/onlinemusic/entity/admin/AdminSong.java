package com.luog.onlinemusic.entity.admin;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import com.luog.onlinemusic.entity.commons.Author;


public class AdminSong implements java.io.Serializable{

	private Integer id;
	private String name;
	private String link;
	private String lyric;
	private int listen;
	private boolean show;
	private boolean status;
	private boolean video;
	private String videoPhoto;
	private Date uploadedTime;
	private String uploadedBy;
	private List<Integer> authors;
	private List<Integer> categories;
	private List<Integer> singers;

	public AdminSong() {

	}

	public AdminSong(Integer id, String name, String link, String lyric, int listen, boolean show, boolean status,
			boolean video, String videoPhoto, Date uploadedTime, String uploadedBy, List<Integer> authors,
			List<Integer> categories, List<Integer> singers) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.lyric = lyric;
		this.listen = listen;
		this.show = show;
		this.status = status;
		this.video = video;
		this.videoPhoto = videoPhoto;
		this.uploadedTime = uploadedTime;
		this.uploadedBy = uploadedBy;
		this.authors = authors;
		this.categories = categories;
		this.singers = singers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotEmpty(message = "Name is required!")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@NotEmpty(message = "Lynk is required!")
	@URL(message = "Enter valid url!")
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

	public Date getUploadedTime() {
		return uploadedTime;
	}

	public void setUploadedTime(Date uploadedTime) {
		this.uploadedTime = uploadedTime;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	@NotEmpty(message = "Author is required!")
	public List<Integer> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Integer> authors) {
		this.authors = authors;
	}

	@NotEmpty(message = "Category is required!")
	public List<Integer> getCategories() {
		return categories;
	}

	public void setCategories(List<Integer> categories) {
		this.categories = categories;
	}

	@NotEmpty(message = "Singer is required!")
	public List<Integer> getSingers() {
		return singers;
	}

	public void setSingers(List<Integer> singers) {
		this.singers = singers;
	}

}
