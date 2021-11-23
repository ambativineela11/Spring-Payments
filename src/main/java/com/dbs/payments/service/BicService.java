package com.dbs.payments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.payments.model.Bic;
import com.dbs.payments.repository.BicRepository;

@Service
public class BicService {
	
	@Autowired
	BicRepository bicRepository;

	public Bic getInstitute(String bicCode) throws Exception {
		Optional<Bic> bicOptional = bicRepository.findById(bicCode);
		if (bicOptional.isPresent())
			return bicOptional.get();
		throw new Exception("This bic code does not exist.");
	}

	
}
