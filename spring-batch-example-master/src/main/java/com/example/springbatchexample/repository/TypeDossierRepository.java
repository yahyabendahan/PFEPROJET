package com.example.springbatchexample.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springbatchexample.model.TypeDossierModel;

@Repository
public interface TypeDossierRepository extends JpaRepository<TypeDossierModel, String>{

	@Query("SELECT t.LIBELLE_COURT FROM TypeDossierModel t")
	ArrayList<String> findAllLibelleCourt();
	
}
