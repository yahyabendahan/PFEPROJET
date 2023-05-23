package com.eai.BatchJobCDL.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import org.springframework.beans.factory.annotation.Autowired;

import com.eai.BatchJobCDL.model.CodeDeclassementModel;

@Repository
public interface CodeDecRepository extends JpaRepository<CodeDeclassementModel,String>{

	@Query("SELECT n.LIBELLE_COURT FROM CodeDeclassementModel n")
	String findAllLibelleCourt();

	@Query("SELECT n.CODE FROM CodeDeclassementModel n")
	String findallCODE();
	//LIBELLE_LONG //NUMERO_ORDRE
}
