package com.luog.onlinemusic.entity.rest;

/**
 * 
 * @author luog
 *
 */
public class CommentEntity implements java.io.Serializable {

	private Integer id;
	private String content;
	private String created;
	private String username;
	private Integer songId;
	private String userPhoto;

	public CommentEntity() {

	}

	public CommentEntity(Integer id, String content, String created, String username, Integer songId,
			String userPhoto) {
		this.id = id;
		this.content = content;
		this.created = created;
		this.username = username;
		this.songId = songId;
		this.userPhoto = userPhoto;
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

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

}
