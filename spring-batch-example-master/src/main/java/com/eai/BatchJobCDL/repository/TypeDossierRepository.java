package com.eai.BatchJobCDL.repository;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.model.TypeDossierModel;


@Component
//@JavaBean 
public interface TypeDossierRepository extends JpaRepository<TypeDossierModel, String>{

	@Bean
	//@Query("SELECT t.LIBELLE_COURT FROM TypeDossierModel t")
	String findOneByLibelleCourt(String libelleCourt);
	
	//@Query("SELECT t.CODE FROM TypeDossierModel t")
	String findOneByCODE(String CODE);
	

}
