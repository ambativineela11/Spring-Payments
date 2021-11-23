package com.dbs.payments.repository;

import java.util.Optional;

//import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dbs.payments.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> 
{

	@Query(name = "SELECT c FROM Customer WHERE c.customerId = ?1")
	public abstract Optional<Customer> findByCustomerId(long customerId);
	
	
}
