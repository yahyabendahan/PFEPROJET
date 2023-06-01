package com.eai.BatchJobCDL.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eai.BatchJobCDL.model.DossierModel;


@Repository
public interface DossierRepository extends JpaRepository<DossierModel,BigDecimal> {
	
//	@Query("SELECT n.CODE FROM DossierModel n")
//	DossierModel findOneByCODE();
	
//	@Query("SELECT n.CODE FROM DossierModel n")
//	List<BigDecimal> findAllCODEs();
	
	@Query("SELECT n.CODE FROM DossierModel n")
	BigDecimal findAllCODEs();

    //BigDecimal findOneByCODE();

	
//	@Query("SELECT n FROM DossierModel n WHERE n.CODE = :code")
//	DossierModel findByCODE(@Param("code") BigDecimal code);
	
//	@Query("SELECT n FROM DossierModel n WHERE n.CODE = :someValue")
//	DossierModel findBySomeCriteria(@Param("someValue") BigDecimal someValue);

	
//	@Query("SELECT n FROM DossierModel n")
//	DossierModel findBySomeCriteria();

}
