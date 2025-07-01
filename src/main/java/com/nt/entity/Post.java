package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
	@Column(name = "post_id")
	private Integer postId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	 @Column(name = "content",columnDefinition = "LONGTEXT")
	 
	 @Lob
	private String content;
	
	@CreationTimestamp
	@Column(name = "creation")
	private LocalDate creation;
	
	@OneToMany(mappedBy = "post",cascade = CascadeType.REMOVE)
	private List<Comment> comments;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserRegistration user;

}
