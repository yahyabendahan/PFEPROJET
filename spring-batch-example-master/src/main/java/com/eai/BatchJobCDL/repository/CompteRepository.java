package com.eai.BatchJobCDL.repository;

import java.math.BigDecimal;
import java.util.List;

import com.eai.BatchJobCDL.model.CompteModel;
import com.eai.BatchJobCDL.model.DossierModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CompteRepository extends JpaRepository<CompteModel,BigDecimal> {
	
//	@Query("SELECT n.code FROM CompteModel n ")
//	CompteModel findByCODE();
	
	
	@Query("SELECT n.code FROM CompteModel n")
	List<BigDecimal> findAllCode();

}
