package com.eai.BatchJobCDL.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.beans.JavaBean;

import com.eai.BatchJobCDL.model.NatEngModel;


@Component
@JavaBean
public interface NatEngRepository extends JpaRepository<NatEngModel, String>{
	
	//@Query("SELECT n.LIBELLE_COURT FROM NatEngModel n")
	NatEngModel findOneByLibelleCourt(String LIBELLE_COURT);

	//@Query("SELECT n.CODE FROM NatEngModel n")
	NatEngModel findOneByCODE(String CODE);
}
