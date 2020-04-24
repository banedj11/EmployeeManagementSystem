package com.baka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baka.models.Contract;

public interface ContractRepository extends JpaRepository<Contract, Integer> {

}
