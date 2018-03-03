package com.luog.onlinemusic.entity.commons;
// Generated Jan 31, 2018 11:31:17 AM by Hibernate Tools 5.2.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Singer generated by hbm2java
 */
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonSerialize(include = Inclusion.NON_NULL)
@Entity
@Table(name = "singer", catalog = "online_music")
public class Singer implements java.io.Serializable {

	private Integer id;
	private String name;
	private String nickName;
	private Date dateOfBirth;
	private String gender;
	private String description;
	private String photo;

	@JsonIgnore
	private Set<AlbumSinger> albumSingers = new HashSet<AlbumSinger>(0);
	@JsonIgnore
	private Set<SongDetail> songDetails = new HashSet<SongDetail>(0);

	public Singer() {
	}

	public Singer(String name, String nickName, Date dateOfBirth, String gender, String description) {
		this.name = name;
		this.nickName = nickName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.description = description;
	}

	public Singer(String name, String nickName, Date dateOfBirth, String gender, String description, String photo,
			Set<AlbumSinger> albumSingers, Set<SongDetail> songDetails) {
		this.name = name;
		this.nickName = nickName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.description = description;
		this.photo = photo;
		this.albumSingers = albumSingers;
		this.songDetails = songDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotEmpty
	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "nick_name", nullable = false, length = 50)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth", nullable = false, length = 10)
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "gender", nullable = false, length = 10)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "description", nullable = false, length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "photo", length = 250, nullable = true)
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "singer")
	public Set<AlbumSinger> getAlbumSingers() {
		return this.albumSingers;
	}

	public void setAlbumSingers(Set<AlbumSinger> albumSingers) {
		this.albumSingers = albumSingers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "singer")
	public Set<SongDetail> getSongDetails() {
		return this.songDetails;
	}

	public void setSongDetails(Set<SongDetail> songDetails) {
		this.songDetails = songDetails;
	}

}
