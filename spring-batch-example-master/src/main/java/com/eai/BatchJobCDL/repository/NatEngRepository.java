package com.eai.BatchJobCDL.repository;


import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.eai.BatchJobCDL.model.NatEngModel;
import com.eai.BatchJobCDL.model.TypeDossierModel;


@Repository 
public interface NatEngRepository extends JpaRepository<NatEngModel, String>{
	@Primary
	@Query("SELECT n FROM NatEngModel n where n.LIBELLE_COURT = :libelleCourt ")
	NatEngModel findOneByLibelleCourt(@Param("libelleCourt") String libelleCourt);

	@Query("SELECT n.CODE FROM NatEngModel n")
	NatEngModel findOneByCODE(String CODE);
} 

