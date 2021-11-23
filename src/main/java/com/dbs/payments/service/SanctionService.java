package com.dbs.payments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.payments.model.SanctionList;
import com.dbs.payments.repository.SanctionRepository;

@Service
public class SanctionService {

	@Autowired
	SanctionRepository sancRepository;
	
	public Boolean getSanctionName(String name) {
		Optional<SanctionList> sanop = sancRepository.findByName(name);
		if(sanop.isPresent())
			return false;
		return true;
	}
}
