package com.bodh.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bodh.rest.entity.User;


public interface UserRepository extends JpaRepository<User,Integer> {

}
