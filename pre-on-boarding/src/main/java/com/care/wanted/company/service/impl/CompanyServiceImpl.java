package com.care.wanted.company.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.wanted.company.repo.CompanyRepository;
import com.care.wanted.company.repo.PostRepository;
import com.care.wanted.company.service.CompanyService;
import com.care.wanted.dtos.CompanyDto;
import com.care.wanted.dtos.PostDto;
import com.care.wanted.entities.Company;
import com.care.wanted.entities.Post;

import jakarta.servlet.http.HttpSession;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	PostRepository postRepo;
	
	@Autowired
	CompanyRepository comRepo;
	
	@Autowired
	HttpSession session;
	
	@Override
	public boolean login(CompanyDto dto) {
		
		Optional<Company> comp = comRepo.findByCompanyId(dto.getCompanyId());
		
		boolean result;
		
		if(comp.isPresent()) {
			CompanyDto companyDto = comp.get().toDto();
			if(companyDto.getPassword().equals(dto.getPassword())) {
				session.setAttribute("id", companyDto.getCompanyNum());
				session.setAttribute("type", "corp");
				result = true;
			} else {
					result = false;
			}
		} else {
			result = false;
		}
		
		return result;
	}

	@Override
	public boolean insert(PostDto dto) {
		Date date = new Date();
		Integer companyNum = Integer.parseInt(session.getAttribute("id").toString());

		dto.setCreatedAt(date);
		dto.setCompanyNum(companyNum);
		
		Optional<Company> compOp = comRepo.findById(companyNum);
		
		Company comp = compOp.get();
		
		Post post = new Post(dto,comp);
		
		Post save = postRepo.save(post);
		
		Optional<Post> returnValue = postRepo.findById(save.getPostNum());
		
		boolean result;
		
		if(returnValue.isPresent()) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	@Override
	public boolean update(PostDto dto) {
		boolean result;
		
		Post oldPost = postRepo.findById(dto.getPostNum()).get();
		
		PostDto oldDto = oldPost.toDto();
		
		PostDto newDto = new PostDto(oldDto.getPostNum(), dto.getTitle(), oldDto.getCompanyName(), dto.getContent(), oldDto.getCompanyNum(), oldDto.getCreatedAt(), dto.getPosition(), dto.getReward(), dto.getSkill(), dto.getCountry(), dto.getLegion());
		
		Optional<Company> comOp = comRepo.findById(oldDto.getCompanyNum());
		Company company = new Company();
		if(comOp.isPresent()) {
			company = comOp.get();
			Post newPost = new Post(newDto, company);
			postRepo.save(newPost);
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	@Override
	public boolean delete(String[] ids) {
		try {
			for(String id : ids) {
				Integer postNum = Integer.parseInt(id);
				Post post = postRepo.findById(postNum).get();
				postRepo.delete(post);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	
	
}
