package com.sync.rest.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel ("User Model")

/**
 * Another way to ignore JSON properties. Means they can't be shown in the JSON response.
 * But this approach is not recommended as its through hard coding values.
 * Tomorrow, if the variable name change, you need to change this name as well.
 * 
 * @JsonIgnoreProperties({"name","birthDate"})
 * 
 * To ignore any unknown properties in JSON input without exception use,
 * 
 * @JsonIgnoreProperties(ignoreUnknown=true)
 */
@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;

	@Size(min=4, max=22, message="Name size should be between 4 and 22")
	@ApiModelProperty("Name should be between 4 and 22")
	private String name;

	@Past(message="Birthdate can NOT be in future.")
	@ApiModelProperty("Birthdate can NOT be in future.")
	//@JsonIgnore
	private Date birthDate;
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	
	public User() {

	}

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
}
