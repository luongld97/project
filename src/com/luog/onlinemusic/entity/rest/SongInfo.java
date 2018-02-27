package com.luog.onlinemusic.entity.rest;

import java.io.Serializable;

public class SongInfo implements Serializable{
	private int songId;
	private String songName;
	private int singerId;
	private String singerName;
	private String singerPhoto;
	private String linkSong;
	private int albumId;
	private String lyricSong;
	private boolean songVideo;
	
	public boolean isSongVideo() {
		return songVideo;
	}
	public void setSongVideo(boolean songVideo) {
		this.songVideo = songVideo;
	}
	public String getLyricSong() {
		return lyricSong;
	}
	public void setLyricSong(String lyricSong) {
		this.lyricSong = lyricSong;
	}
	public String getLinkSong() {
		return linkSong;
	}
	public void setLinkSong(String linkSong) {
		this.linkSong = linkSong;
	}
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
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
	public SongInfo(int songId, String songName, int singerId, String singerName, String singerPhoto, String linkSong, int albumId, String lyricSong, boolean songVideo) {
		super();
		this.songId = songId;
		this.songName = songName;
		this.singerId = singerId;
		this.singerName = singerName;
		this.singerPhoto = singerPhoto;
		this.linkSong = linkSong;
		this.albumId = albumId;
		this.lyricSong = lyricSong;
		this.songVideo = songVideo;
	}	
	public SongInfo() {
		super();
	}
	
	

}
