package com.noip.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noip.example.entities.Company;
import com.noip.example.repository.CompanyRepository;
import com.noip.example.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;

	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	@Override
	public Company findbyId(Long comID) {
		return companyRepository.findById(comID).get();
	}

	@Override
	public void save(Company company) {
		companyRepository.save(company);

	}

	@Override
	public void delete(Long comID) {
		companyRepository.deleteById(comID);
	}

	@Override
	public List<Company> getCompaniesByDate(String pubDate) {
		return companyRepository.findByPublishDate(pubDate);
		//return companyRepository.findByPublishDateGreaterThan(pubDate);
	}

}
