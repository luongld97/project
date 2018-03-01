package com.luog.onlinemusic.entity.rest;

/**
 * 
 * @author luog
 *
 */
public class CommentEntity implements java.io.Serializable{

	private Integer id;
	private String content;
	private String username;
	private Integer songId;

	public CommentEntity() {

	}

	public CommentEntity(Integer id, String content, String username, Integer songId) {
		this.id = id;
		this.content = content;
		this.username = username;
		this.songId = songId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}

}
