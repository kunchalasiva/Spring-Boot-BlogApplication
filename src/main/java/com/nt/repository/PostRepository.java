package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Post;
import com.nt.entity.UserRegistration;

public interface PostRepository extends JpaRepository<Post, Integer> {

	public List<Post> findByUser(UserRegistration user);
}
