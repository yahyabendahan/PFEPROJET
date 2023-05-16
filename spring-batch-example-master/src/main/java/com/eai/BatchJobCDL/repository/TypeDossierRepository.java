package com.eai.BatchJobCDL.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.eai.BatchJobCDL.model.TypeDossierModel;

@Repository
public interface TypeDossierRepository extends JpaRepository<TypeDossierModel, String>{

	
	@Query("SELECT t.LIBELLE_COURT FROM TypeDossierModel t")
	List<String> findAllLibelleCourt();
	
	@Query("SELECT t.CODE FROM TypeDossierModel t")
	List<String> findallCODE();
	

}
