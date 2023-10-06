package com.care.wanted.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ApplyDto {
	private int applyNum;				// 공고 지원 고유 ID
	private int userId;			// 공고 지원자 ID
	private int postId;			// 공고 고유 ID -- 포링키 관계
	private Date createdAt;		// 공고 지원 일시
}
