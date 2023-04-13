package com.example.springbatchexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbatchexample.model.ImpayesCDLModel;



@Repository
public interface ImpayesCDLRepository extends JpaRepository<ImpayesCDLModel, Long> {

}
