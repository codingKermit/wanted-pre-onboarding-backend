package com.care.wanted.dtos;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PostDto {
	private int postNum;		// 채용 공고 고유 ID
	private String title;		// 채용 공고 제목
	private String companyName;	// 채용 기업 이름
	private String content;		// 채용 공고 내용
	private int companyNum;		// 채용 기업 고유 ID
	private Date createdAt;		// 작성일
	private String position;	// 채용 포지션
	private int reward;			// 채용 보상금
	private	String skill;		// 사용 기술
	private	String country;		// 국가
	private String legion;		// 지역
}
