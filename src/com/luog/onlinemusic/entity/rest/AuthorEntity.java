package com.luog.onlinemusic.entity.rest;

public class AuthorEntity {
	private int authorId;
	private String authorName;
	private int songId;
	private String songName;
	private String songLyric;
	private String songLink;
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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
	public String getSongLyric() {
		return songLyric;
	}
	public void setSongLyric(String songLyric) {
		this.songLyric = songLyric;
	}
	public String getSongLink() {
		return songLink;
	}
	public void setSongLink(String songLink) {
		this.songLink = songLink;
	}
	public AuthorEntity(int authorId, String authorName, int songId, String songName, String songLyric, String songLink) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.songId = songId;
		this.songName = songName;
		this.songLyric = songLyric;
		this.songLink = songLink;
	}
	public AuthorEntity() {
		super();
	}
	
}
