package com.eai.BatchJobCDL.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eai.BatchJobCDL.model.NatEngModel;

@Repository
public interface NatEngRepository extends JpaRepository<NatEngModel, String>{
	
	@Query("SELECT n.LIBELLE_COURT FROM NatEngModel n")
	List<String> findAllLibelleCourt();

}
