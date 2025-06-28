package com.nt.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "comment_tab")
@Data
public class Comment {

	@Id
	@GeneratedValue
	private Integer commId;
	
	private String name;
	
	private String email;
	
	private String comment;
	
	@CreationTimestamp
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "postid")
	private Post post;
	
}
