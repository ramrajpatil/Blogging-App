package com.app.pojos;

import java.time.LocalDate;
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
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "myBlogs")
@Entity
@Table(name = "users")
public class User extends BaseEntity {

	@Column(name = "first_name", length = 25, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 25, nullable = false)
	private String lastName;

	@Column(unique = true, nullable = false, length = 35)
	private String email;

	@Column(nullable = false, length = 20)
	private String password;

	@Column(unique = true, nullable = false, name = "phone_no", length = 10)
	private String phoneNo;

	@Column(name = "created_on")
	private LocalDate createdOn;

	// @JsonIgnoreProperties(value = "cartOwner") //Don't know it is to be added or
	// not
	@OneToMany(mappedBy = "malak", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Blog> myBlogs = new ArrayList<Blog>();

	public User(String firstName, String lastName, String email, String password, String phoneNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.createdOn = LocalDate.now();
	}
}