package com.luog.onlinemusic.entity.commons;
// Generated Jan 31, 2018 11:31:17 AM by Hibernate Tools 5.2.6.Final

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

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category", catalog = "online_music")
public class Category implements java.io.Serializable {

	private Integer id;
	private Category category;
	private String name;
	private Set<CategoryDetail> categoryDetails = new HashSet<CategoryDetail>(0);
	private Set<Category> categories = new HashSet<Category>(0);

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public Category(Category category, String name, Set<CategoryDetail> categoryDetails, Set<Category> categories) {
		this.category = category;
		this.name = name;
		this.categoryDetails = categoryDetails;
		this.categories = categories;
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
	@JoinColumn(name = "parent_id")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@NotEmpty
	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<CategoryDetail> getCategoryDetails() {
		return this.categoryDetails;
	}

	public void setCategoryDetails(Set<CategoryDetail> categoryDetails) {
		this.categoryDetails = categoryDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

}
