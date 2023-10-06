package com.care.wanted.entities;


import java.util.Date;

import com.care.wanted.dtos.PostDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor @NoArgsConstructor
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postNum;
	
	@Column(length = 200, nullable = false)
	private String title;
	
	@Column(length = 500, nullable = false)
	private String content;
	
	private Date createdAt;
	
	private String position;	
	private int reward;			
	private	String skill;		
	private	String country;		
	private String legion;		
	
	@ManyToOne
	@JoinColumn(name = "companyNum")
	private Company company;
	
	@Builder
	public Post(PostDto dto, Company company) {
		this.postNum = dto.getPostNum();
		this.title = dto.getTitle();
		this.content = dto.getContent();
		this.createdAt = dto.getCreatedAt();
		this.company = company;
		this.position = dto.getPosition();
		this.reward = dto.getReward();
		this.skill = dto.getSkill();
		this.country = dto.getCountry();
		this.legion = dto.getLegion();
	}
	
	public PostDto toDto() {
		return PostDto.builder()
					.postNum(postNum)
					.title(title)
					.content(content)
					.createdAt(createdAt)
					.companyName(company.toDto().getName())
					.companyNum(company.toDto().getCompanyNum())
					.position(position)
					.reward(reward)
					.skill(skill)
					.country(country)
					.legion(legion)
					.build();
	}
	
}
