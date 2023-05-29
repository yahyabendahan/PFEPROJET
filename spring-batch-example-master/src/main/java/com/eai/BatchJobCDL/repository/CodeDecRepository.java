package com.eai.BatchJobCDL.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eai.BatchJobCDL.model.CodeDeclassementModel;
import com.eai.BatchJobCDL.model.NatEngModel;

@Repository 
public interface CodeDecRepository extends JpaRepository<CodeDeclassementModel,String>{
	@Primary
	@Query("SELECT n FROM CodeDeclassementModel n where n.LIBELLE_COURT = :libelleCourt ")
	String findOneByLibelleCourt(@Param("libelleCourt") String libelleCourt);

	@Query("SELECT n FROM CodeDeclassementModel n where n.CODE = : CODE")
	String findOneByCODE(@Param("code") String code);
	//LIBELLE_LONG //NUMERO_ORDRE
}


