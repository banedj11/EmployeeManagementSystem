package com.baka.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baka.models.Contract;
import com.baka.repositories.ContractRepository;
import com.baka.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService{

	@Autowired
	private ContractRepository contractRepo;
	
	//Get all contracts
	@Override
	public List<Contract> getAll() {
		
		return contractRepo.findAll();
	}

	//Get contract by id
	@Override
	public Optional<Contract> getOne(Integer id) {
		
		return contractRepo.findById(id);
	}

	//Create contract
	@Override
	public void saveContract(Contract contract) {
		
		contractRepo.save(contract);
	}

	//Delete contract by id
	@Override
	public void deleteContract(Integer id) {
		
		contractRepo.deleteById(id);
	}
}
