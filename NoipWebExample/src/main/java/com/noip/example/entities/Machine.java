package com.noip.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "machines")
public class Machine {
	@Id
	@Column(name = "machineId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long machineId;

	@Column(name = "departmentId", nullable = false)
	private Long departmentId;

	@Column(name = "machineType", nullable = false)
	private String machineType;

	@Column(name = "supplyDate", nullable = false)
	private String supplyDate;

	public Long getMachineId() {
		return machineId;
	}

	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getMachineType() {
		return machineType;
	}

	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}

	public String getSupplyDate() {
		return supplyDate;
	}

	public void setSupplyDate(String supplyDate) {
		this.supplyDate = supplyDate;
	}

}
