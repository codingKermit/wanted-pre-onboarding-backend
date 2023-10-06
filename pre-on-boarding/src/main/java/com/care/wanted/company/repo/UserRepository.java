package com.care.wanted.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.care.wanted.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

}
