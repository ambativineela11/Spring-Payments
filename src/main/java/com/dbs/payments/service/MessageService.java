package com.dbs.payments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.payments.model.Message;
import com.dbs.payments.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	MessageRepository msgRepository;

	public Message getMessage(String msgCode) throws Exception {
		Optional<Message> msgOptional = msgRepository.findById(msgCode);
		if (msgOptional.isPresent())
			return msgOptional.get();
		throw new Exception("This message code does not exist.");
	}

}
