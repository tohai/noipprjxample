package com.noip.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noip.example.dto.Employee;
import com.noip.example.dto.ResultEmployeeApi;
import com.noip.example.entities.Company;
import com.noip.example.entities.Department;
import com.noip.example.entities.Machine;
import com.noip.example.repository.CompanyRepository;
import com.noip.example.repository.DepartmentRepositry;

@RestController
public class HelloController {
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired 
	DepartmentRepositry departmentRepositry;
	
	@RequestMapping("/hello")
	public List<Company> hello() {
		Machine machine1 = new Machine();
		machine1.setMachineId(1L);
		machine1.setDepartmentId(1L);
		machine1.setMachineType("4");
		machine1.setSupplyDate("20210102");
		
		Machine machine2 = new Machine();
		machine2.setMachineId(2L);
		machine1.setDepartmentId(1L);
		machine2.setMachineType("2");
		machine2.setSupplyDate("20210103");
		
		List<Machine> machines = new ArrayList<Machine>();
		
		machines.add(machine1);
		machines.add(machine2);
		
		Department dept = new Department();
		//dept.setDepartmentId(1L);
		dept.setCompanyId(11L);
		dept.setDepartmentAddress("tang 4");
		dept.setDepartmentName("p cntt");
		dept.setPublishDate("20210101");
		//dept.setMachines(machines);
		
		//departmentRepositry.save(dept);
		
		List<Department> departments = new ArrayList<Department>();
		departments.add(dept);
		Company com = new Company();
		com.setCompanyName("haitv Com");
		com.setCompanyAddress("Bac Ninh");
		com.setPublishDate("20200211");
		//com.setDepartments(departments);
		//companyRepository.save(com);
		
		//Company comp = companyRepository.findById(1L).get().getDepartments().get(0).getDepartmentAddress();
		
		//Company compp = companyRepository.findAll().get(0);
		
		//companyRepository.save(compp);
		
		return companyRepository.findAll();
	}
	
	@RequestMapping("/testAPI")
	public ResultEmployeeApi getApi() {
		
		String uri = "http://localhost:8080/API/employees";
	    RestTemplate restTemplate = new RestTemplate();
	    ResultEmployeeApi result =restTemplate.getForObject(uri, ResultEmployeeApi.class);
	    return result; 
	}
	
	@RequestMapping("/testSaveAPI")
	public ResultEmployeeApi saveApi() {
		
		String uri = "http://localhost:8080/API/employees/save";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		
		Employee employee = new Employee();
		employee.setEmailId("Haitvhugo@gmail.com");
		employee.setFirstName("hugo");
		employee.setLastName("aio");
		
		ObjectMapper jsonMapper = new ObjectMapper();
		
	    RestTemplate restTemplate = new RestTemplate();
	    ResultEmployeeApi result =null;
		try {
			HttpEntity<String> entity = new HttpEntity<String>(jsonMapper.writeValueAsString(employee),headers);
			result = restTemplate.postForEntity(uri, entity,ResultEmployeeApi.class).getBody();
		} catch (RestClientException|JsonProcessingException e) {
			e.printStackTrace();
		}
	    return result; 
	}

}
