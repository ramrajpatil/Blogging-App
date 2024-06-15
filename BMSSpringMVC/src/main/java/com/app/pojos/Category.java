package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

	@Column(length = 30, unique = true, nullable = false)
	private String title;
	//DO NOT keep colm Name as desc as it is a keyword in Database 
	@Column(length = 150, nullable = false)
	private String description;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Blog> blogs = new ArrayList<Blog>();

	public Category(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

}