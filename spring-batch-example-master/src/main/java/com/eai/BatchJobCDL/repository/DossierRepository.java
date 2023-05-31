package com.eai.BatchJobCDL.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eai.BatchJobCDL.model.DossierModel;


@Repository
public interface DossierRepository extends JpaRepository<DossierModel,BigDecimal> {
	
	@Query("SELECT n.CODE FROM DossierModel n")
	DossierModel findAllByCODE();
	
	
//	@Query("SELECT n FROM DossierModel n WHERE n.CODE = :someValue")
//	DossierModel findBySomeCriteria(@Param("someValue") BigDecimal someValue);

	
//	@Query("SELECT n FROM DossierModel n")
//	DossierModel findBySomeCriteria();

}
