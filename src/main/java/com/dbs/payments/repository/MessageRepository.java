package com.dbs.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.payments.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, String>{

}
