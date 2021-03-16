package com.noip.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noip.example.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	public List<Company> findByPublishDate(String publishDate);
	
	public List<Company> findByPublishDateGreaterThan(String publishDate);

}
