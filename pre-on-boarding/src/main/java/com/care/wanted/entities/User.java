package com.care.wanted.entities;

import com.care.wanted.dtos.UserDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity
public class User {
	
	private int userNum;
	
	@Id
	@Column(length = 100, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String userId;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	@Builder
	public User(UserDto dto) {
		this.userNum = dto.getUserNum();
		this.userId = dto.getUserId();
		this.password = dto.getPassword();
	}
}
