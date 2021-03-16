package com.noip.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noip.example.entities.Machine;

public interface MachineRepository extends JpaRepository<Machine, Long> {

}
