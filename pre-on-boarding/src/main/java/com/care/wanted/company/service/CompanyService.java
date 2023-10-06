package com.care.wanted.company.service;

import com.care.wanted.dtos.CompanyDto;
import com.care.wanted.dtos.PostDto;

public interface CompanyService {

	// 로그인 메서드, 성공 여부 반환
	public boolean login(CompanyDto dto);
	
	// 공고 저장 메서드, 성공 여부 반환
	public boolean insert(PostDto dto);
	
	// 공고 수정 메서드, 성공 여부 반환
	public boolean update(PostDto dto);
	
	// 공고 삭제 메서드, 성공 여부 반환
	public boolean delete(String[] ids);
}
