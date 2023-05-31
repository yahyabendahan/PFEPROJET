package com.eai.BatchJobCDL.repository;

import java.math.BigDecimal;
import com.eai.BatchJobCDL.model.CompteModel;
import com.eai.BatchJobCDL.model.DossierModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompteRepository extends JpaRepository<CompteModel,BigDecimal> {
	
	@Query("SELECT n FROM CompteModel n WHERE n.code = :code")
	DossierModel findByCODE(@Param("code") BigDecimal code);
	

}
