package com.noip.example.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {
	
	@Id
	@Column(name = "departmentId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;

	@Column(name = "companyId", nullable = false)
	private Long companyId;

	@Column(name = "departmentName", nullable = false)
	private String departmentName;

	@Column(name = "departmentAddress", nullable = false)
	private String departmentAddress;

	@Column(name = "publishDate", nullable = false)
	private String publishDate;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="departmentId",fetch = FetchType.LAZY )
	private List<Machine> machines = new ArrayList<Machine>();
	
	public List<Machine> getMachines() {
		return machines;
	}

	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentAddress() {
		return departmentAddress;
	}

	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

}
