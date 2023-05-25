package com.eai.BatchJobCDL.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.model.TypeDossierModel;


@Component
//@JavaBean 
public interface TypeDossierRepository extends JpaRepository<TypeDossierModel, String>{

	@Bean
	//@Query("SELECT t.LIBELLE_COURT FROM TypeDossierModel t")
	TypeDossierModel findOneByLibelleCourt(String LIBELLE_COURT);
	
	//@Query("SELECT t.CODE FROM TypeDossierModel t")
	TypeDossierModel findOneByCODE(String CODE);
	

}
