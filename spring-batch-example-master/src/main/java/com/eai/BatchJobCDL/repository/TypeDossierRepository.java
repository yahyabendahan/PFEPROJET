package com.eai.BatchJobCDL.repository;

import java.beans.JavaBean;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.eai.BatchJobCDL.model.TypeDossierModel;

@Repository
@Component
@JavaBean 
public interface TypeDossierRepository extends JpaRepository<TypeDossierModel, String>{

	
	//@Query("SELECT t.LIBELLE_COURT FROM TypeDossierModel t")
	TypeDossierModel findOneByLibelleCourt(String LIBELLE_COURT);
	
	//@Query("SELECT t.CODE FROM TypeDossierModel t")
	TypeDossierModel findOneByCODE(String CODE);
	

}
