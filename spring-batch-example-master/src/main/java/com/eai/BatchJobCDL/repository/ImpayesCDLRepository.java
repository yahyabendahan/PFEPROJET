package com.eai.BatchJobCDL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eai.BatchJobCDL.model.ImpayesCDLModel;



@Repository
public interface ImpayesCDLRepository extends JpaRepository<ImpayesCDLModel, String> {

}
