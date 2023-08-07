package com.eai.BatchJobCDL.repository;

import com.eai.BatchJobCDL.model.Cle_Doss_Cr_CptModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Cle_Doss_Cr_CptRepository extends JpaRepository<Cle_Doss_Cr_CptModel, Long> {

    // Custom method to save a list of Cle_Doss_Cr_CptModel instances in a batch
    List<Cle_Doss_Cr_CptModel> saveAll(List<Cle_Doss_Cr_CptModel> cleDossCrCptModels);

}
