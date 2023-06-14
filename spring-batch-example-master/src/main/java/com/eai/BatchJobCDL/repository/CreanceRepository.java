//package com.eai.BatchJobCDL.repository;
//
//import java.util.Date;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.eai.BatchJobCDL.model.ImpayesCDLModel;
//
//@Repository
//public interface CreanceRepository extends JpaRepository<ImpayesCDLModel, Long> {
//    ImpayesCDLModel findByCodeNatEngAndCodeDossierAndDateEcheanceAndNumeroLigneAndNumeroTirage(
//            String nateng /*codeNatEng*/, String codeDossier /* noDossier !!*/, Date dateEcheance, int numeroLigne, int numeroTirage);
//}
