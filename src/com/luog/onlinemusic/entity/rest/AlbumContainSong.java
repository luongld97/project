package com.luog.onlinemusic.entity.rest;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AlbumContainSong implements Serializable{
	private int albumId;
	private String albumName;
	private int songId;
	private String songName;
	private String linkSong;
	private String singerName;
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
	public String getSingerName() {
		return singerName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
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
	public String getLinkSong() {
		return linkSong;
	}
	public void setLinkSong(String linkSong) {
		this.linkSong = linkSong;
	}
	public AlbumContainSong(int albumId, String albumName, int songId, String songName, String linkSong, String singerName, String lyricSong, boolean songVideo) {
		super();
		this.albumId = albumId;
		this.albumName = albumName;
		this.songId = songId;
		this.songName = songName;
		this.linkSong = linkSong;
		this.singerName = singerName;
		this.lyricSong = lyricSong;
		this.songVideo = songVideo;
	}
	public AlbumContainSong() {
		super();
	}
	
}
