package com.sync.rest.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sync.rest.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
