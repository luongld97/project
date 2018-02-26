package com.luog.onlinemusic.entity.rest;

public class PlayListEntity {
	private int playListId;
	private String playListName;
	private int songId;
	private String songName;
	private String songLink;
	private String songLyric;
	public int getPlayListId() {
		return playListId;
	}
	public void setPlayListId(int playListId) {
		this.playListId = playListId;
	}
	public String getPlayListName() {
		return playListName;
	}
	public void setPlayListName(String playListName) {
		this.playListName = playListName;
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
	public String getSongLink() {
		return songLink;
	}
	public void setSongLink(String songLink) {
		this.songLink = songLink;
	}
	public String getSongLyric() {
		return songLyric;
	}
	public void setSongLyric(String songLyric) {
		this.songLyric = songLyric;
	}
	public PlayListEntity(int playListId, String playListName, int songId, String songName, String songLink,
			String songLyric) {
		super();
		this.playListId = playListId;
		this.playListName = playListName;
		this.songId = songId;
		this.songName = songName;
		this.songLink = songLink;
		this.songLyric = songLyric;
	}
	public PlayListEntity() {
		super();
	}
	
}
