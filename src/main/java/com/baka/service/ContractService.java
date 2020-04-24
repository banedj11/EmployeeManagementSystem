package com.baka.service;

import java.util.List;
import java.util.Optional;

import com.baka.models.Contract;
;

public interface ContractService {

	List<Contract> getAll();
	Optional<Contract> getOne(Integer id);
	void saveContract(Contract contract);
	void deleteContract(Integer id);
}
