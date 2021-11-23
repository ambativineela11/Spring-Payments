package com.dbs.payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.payments.model.Bic;

@Repository
public interface BicRepository extends JpaRepository<Bic, String>{

}
