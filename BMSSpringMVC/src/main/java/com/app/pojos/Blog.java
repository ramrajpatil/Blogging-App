package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString(exclude = { "malak", "category" })
@Table(name = "blogs")
public class Blog extends BaseEntity {
	@Column(length = 35, unique = true, nullable = false)
	private String title;

	@Column(length = 150, nullable = false)
	private String contents;

	@Column(name = "created_on")
	private LocalDate createdOn;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User malak;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Blog(Long blogId, String title, String contents, LocalDate createdOn, User malak, Category category) {
		super(blogId);
		this.title = title;
		this.contents = contents;
		this.createdOn = createdOn;
		this.malak = malak;
		this.category = category;
	}
}