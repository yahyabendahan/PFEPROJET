package com.eai.BatchJobCDL.repository;

import java.util.ArrayList;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eai.BatchJobCDL.model.TypeDossierModel;

@Repository
public interface TypeDossierRepository extends JpaRepository<TypeDossierModel, String>{

	//TypeDossierModel typedossier = new TypeDossierModel();
	
	@Query("SELECT t.LIBELLE_COURT FROM TypeDossierModel t")
	//ArrayList<String> findAllLibelleCourt();
	List<String> findAllLibelleCourt();
	
	@Query("SELECT t.CODE FROM TypeDossierModel t")
	List<String> findallCODE();
	
	/*@Query("SELECT CODE FROM TYPE_DOSSIER");
	ArrayList<String> findAllCODE();*/

}
