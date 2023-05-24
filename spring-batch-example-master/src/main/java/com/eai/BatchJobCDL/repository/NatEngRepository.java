package com.eai.BatchJobCDL.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.beans.JavaBean;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eai.BatchJobCDL.model.NatEngModel;

@Repository
@Component
@JavaBean
public interface NatEngRepository extends JpaRepository<NatEngModel, String>{
	
	//@Query("SELECT n.LIBELLE_COURT FROM NatEngModel n")
	NatEngModel findOneByLibelleCourt(String LIBELLE_COURT);

	//@Query("SELECT n.CODE FROM NatEngModel n")
	NatEngModel findOneByCODE(String CODE);
}
