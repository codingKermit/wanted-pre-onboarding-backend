package com.care.wanted.entities;

import java.sql.Date;

import com.care.wanted.dtos.ApplyDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity
public class Apply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int applyNum;
	
	private int userId;
	private int postId;
	private Date createdAt;
	
	@Builder
	public Apply(ApplyDto dto) {
		this.applyNum = dto.getApplyNum();
		this.userId = dto.getUserId();
		this.postId = dto.getPostId();
		this.createdAt = dto.getCreatedAt();
	}
}
