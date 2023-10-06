package com.care.wanted.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CompanyDto {
	private int companyNum;		// 고유 ID
	private String companyId;	// 기업 회원 ID
	private String password;	// 비밀번호
	private String name;		// 회사명
}
