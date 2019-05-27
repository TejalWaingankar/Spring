package com.sync.rest.controller.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sync.rest.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
