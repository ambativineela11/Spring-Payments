package com.dbs.payments.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.payments.model.Bic;
import com.dbs.payments.service.BicService;

@CrossOrigin
@RestController
public class BicController {
	
	@Autowired
	BicService bicService;

	@GetMapping("/getinstitute/{bic_code}")
	public ResponseEntity<Bic> getInstitute(@PathVariable(name = "bic_code") String bicCode) throws Exception
	{
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "BIC is available.");
		return new ResponseEntity<Bic>(bicService.getInstitute(bicCode), headers, HttpStatus.OK);
	}
}
