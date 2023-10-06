package com.care.wanted.common.service;

import java.util.List;

import com.care.wanted.dtos.PostDto;

public interface CommonService {

	// 공고 조회
	public List<PostDto> getList();
	
	// 공고 검색
	public List<PostDto> search(String keyword);
	
	// 해당 회사가 올린 다른 채용공고 조회
	public List<PostDto> recommand();
	
	// 공고 상세보기
	public PostDto getDetail(Integer id);
}
