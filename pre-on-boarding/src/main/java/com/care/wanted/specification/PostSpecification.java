package com.care.wanted.specification;

import org.springframework.data.jpa.domain.Specification;

import com.care.wanted.entities.Company;
import com.care.wanted.entities.Post;

public class PostSpecification {
	
	public static Specification<Post> findByCompany(Company company){
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("company"), company);
	}

}
