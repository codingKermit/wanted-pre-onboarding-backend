package com.care.wanted.entities;

import java.util.List;

import com.care.wanted.dtos.CompanyDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "companyNum")
	private int id;
	
	@Column(length = 100, nullable = false)
	private String companyId;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	private String name;
	
	@OneToMany(mappedBy = "company")
	private List<Post> posts;
	
	@Builder
	public Company(CompanyDto dto) {
		this.id = dto.getCompanyNum();	
		this.companyId = dto.getCompanyId();
		this.password = dto.getPassword();
		this.name = dto.getName();
	}
	
	public CompanyDto toDto() {
		return CompanyDto.builder().companyNum(id).companyId(companyId).password(password).name(name).build();
	}
	
}
