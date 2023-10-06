package com.care.wanted.company.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.care.wanted.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{
	Optional<Company> findByCompanyId(String companyId);
}
