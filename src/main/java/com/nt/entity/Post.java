package com.nt.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "create_post")
@Data
public class Post {

	@Id
	@GeneratedValue
	private Integer postId;
	
	private String title;
	
	private String description;
	
	private String content;
	
	@OneToMany(mappedBy = "post",cascade = CascadeType.REMOVE)
	private List<Comment> comments;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserRegistration user;
}
