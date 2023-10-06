package com.care.wanted.common.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.care.wanted.common.service.CommonService;
import com.care.wanted.company.repo.CompanyRepository;
import com.care.wanted.company.repo.PostRepository;
import com.care.wanted.dtos.PostDto;
import com.care.wanted.entities.Company;
import com.care.wanted.entities.Post;
import com.care.wanted.specification.PostSpecification;

import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpSession;

@Service
public class CommonServiceImpl implements CommonService{

	@Autowired
	PostRepository postRepo;
	
	@Autowired
	CompanyRepository comRepo;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	EntityManager em;
	
	@Override
	public List<PostDto> getList() {
		List<Post> posts = postRepo.findAll();
		
		List<PostDto> dtos = posts.stream().map(m->m.toDto()).collect(Collectors.toList());
		
		return dtos;
	}

	@Override
	public List<PostDto> search(String keyword) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<PostDto> recommand() {
		Integer companyId = (Integer) session.getAttribute("id");
		String jpql = "select p from Post p join p.company c where c.id = :num";
		List<Post> posts = em.createQuery(jpql,Post.class)
				.setParameter("num", companyId)
				.getResultList();
		List<PostDto> dtos = posts.stream().map(m->m.toDto()).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public PostDto getDetail(Integer id) {
		PostDto dto = new PostDto();
		try {
			dto = postRepo.findById(id).get().toDto();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return dto;
	}

}
