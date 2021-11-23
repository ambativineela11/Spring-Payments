package com.dbs.payments.repository;

//import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dbs.payments.model.SanctionList;

@Repository
public interface SanctionRepository extends JpaRepository<SanctionList, Integer> {

	@Query(name = "SELECT s FROM SanctionList WHERE s.name = ?1")
	public abstract Optional<SanctionList> findByName(String name);

}
