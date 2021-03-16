package com.noip.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.noip.example.entities.Company;
import com.noip.example.service.CompanyService;

@Controller
public class ComppanyController {
	
	@Autowired
	CompanyService companyService;
	
	@GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("companies", companyService.findAll());
        return "index";
    }
	
	@PostMapping("/searchcompany")
	public String searchByDate(@RequestParam(value = "publishDate", required = true) String publishDate, Model model) {
		model.addAttribute("publishDate", publishDate);
		model.addAttribute("companies", companyService.getCompaniesByDate(publishDate));
		return "index";
	}
	
	@RequestMapping("/company/add")
	public String showAddCompany(Model model) {
		model.addAttribute("company",new Company());
		return "company/saveform";
	}
	
	@RequestMapping("/company/edit/{comId}")
	public String showupdateCompany(@PathVariable Long comId,Model model) {
		model.addAttribute("company",companyService.findbyId(comId));
		return "company/saveform";
	}
	
	@RequestMapping("/company/save")
	public String saveCompany(Company company) {
		if(company.getCompanyId() == 0) {
			companyService.save(company);
		}else {
			Company companyOld = companyService.findbyId(company.getCompanyId());
			companyOld.setCompanyAddress(company.getCompanyAddress());
			companyOld.setCompanyName(company.getCompanyName());
			companyOld.setPublishDate(company.getPublishDate());
			
			companyService.save(companyOld);
		}
		
		return "redirect:/index";
	}
	
	@RequestMapping("/company/delete/{comId}")
	public String deleteCompany(@PathVariable Long comId) {
		Company companyExist = companyService.findbyId(comId);
		
		if(companyExist != null) {
			companyService.delete(comId);
		}
		
		return "redirect:/index";
	}
	
	

}
