package com.noip.example.service;

import java.util.List;

import com.noip.example.entities.Company;

public interface CompanyService {
	
	public List<Company> findAll();
	
	public Company findbyId(Long comID);
	
	public void save(Company company);
	
	public void delete(Long comID);
	
	public List<Company> getCompaniesByDate(String pubDate);

}
