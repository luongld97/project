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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PlayList generated by hbm2java
 */
@Entity
@Table(name = "play_list", catalog = "online_music")
public class PlayList implements java.io.Serializable {

	private Integer id;
	private Account account;
	private String name;
	private String photo;
	private Date createdTime;
	private Set<PlayListDetail> playListDetails = new HashSet<PlayListDetail>(0);

	public PlayList() {
	}

	public PlayList(Account account, String name, Date createdTime) {
		this.account = account;
		this.name = name;
		this.createdTime = createdTime;
	}

	public PlayList(Account account, String name, String photo, Date createdTime, Set<PlayListDetail> playListDetails) {
		this.account = account;
		this.name = name;
		this.photo = photo;
		this.createdTime = createdTime;
		this.playListDetails = playListDetails;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "photo", length = 250)
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_time", nullable = false, length = 19)
	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "playList")
	public Set<PlayListDetail> getPlayListDetails() {
		return this.playListDetails;
	}

	public void setPlayListDetails(Set<PlayListDetail> playListDetails) {
		this.playListDetails = playListDetails;
	}

}
