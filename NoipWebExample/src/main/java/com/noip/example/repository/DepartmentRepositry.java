package com.noip.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noip.example.entities.Department;

public interface DepartmentRepositry extends JpaRepository<Department, Long> {

}
