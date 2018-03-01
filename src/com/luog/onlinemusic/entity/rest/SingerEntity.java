package com.luog.onlinemusic.entity.rest;

public class SingerEntity {

	private Integer id;
	private String name;
	private String nickName;
	private String dateOfBirth;
	private String gender;
	private String description;
	private String photo;

	public SingerEntity() {

	}

	public SingerEntity(Integer id, String name, String nickName, String dateOfBirth, String gender, String description,
			String photo) {
		this.id = id;
		this.name = name;
		this.nickName = nickName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.description = description;
		this.photo = photo;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
