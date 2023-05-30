package com.eai.BatchJobCDL.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;
import com.eai.BatchJobCDL.model.TypeDossierModel;

@Repository
public interface ImpayesCDLRejetRepository extends JpaRepository<ImpayesCdlRejetModel, String> {

    public static final Logger log = LoggerFactory.getLogger(ImpayesCDLRejetRepository.class);
    
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "INSERT INTO CDL.IMPAYES_CDL_REJET (NATENG, TYPE, CPT, MONTANT_CREANCE, DATE_CREANCE, NO_DOSSIER, DATE_ECHEANCE, DATE_MISE_IMPAYE, DATE_REGLEMENT, MONTANT_AMORTISSEMENT, MONTANT_INTERET_NORMAL, TVA_INTERET, MONTANT_INTERET_RETARD, TVA_INTERET_RETARD, MONATANT_PENALITE_RETARD, TVA_PENALITE_RETARD, NUM_COMPTE_PAYEUR, REFFERENCE_VALEUR, REFERNCE_LIAISON, COMISSION, CODE_REJET, CODE_ETABLISST_BANCAIRE, CODE_GUICHET_BANCAIRE, DATE_REMISE, ENCOURS_EES_CONSO, ENCOURS_EES_COMM, ENCOURS_ESB, ENCOURS_ESI, SOLDE, ENCOURS_DECLASSE, ENCOURS_RISQUE, TYPE_CLIENT, NUM_TIERS, CODE_CATEGORIE, NUM_DOSSIER_COMPLET, NUMERO_LIGNE, NUMERO_TIRAGE, DATE_REJET, MOTIF_REJET) "
            + "VALUES (:#{#imp.nateng},\r\n"
            + ":#{#imp.type},\r\n"
            + ":#{#imp.cpt},\r\n"
            + ":#{#imp.montantCreance},\r\n"
            + ":#{#imp.dateCreance},\r\n"
            + ":#{#imp.noDossier},\r\n"
            + ":#{#imp.dateEcheance},\r\n"
            + ":#{#imp.dateMiseImpaye},\r\n"
            + ":#{#imp.dateReglement},\r\n"
            + ":#{#imp.montantAmortissement},\r\n"
            + ":#{#imp.montantInteretNormal},\r\n"
            + ":#{#imp.tvaInteret},\r\n"
            + ":#{#imp.montantInteretRetard},\r\n"
            + ":#{#imp.tvaInteretRetard},\r\n"
            + ":#{#imp.montantPenaliteRetard},\r\n"
            + ":#{#imp.tvaPenaliteRetard},\r\n"
            + ":#{#imp.numComptePayeur},\r\n"
            + ":#{#imp.refferenceValeur},\r\n"
            + ":#{#imp.referenceLiaison},\r\n"
            + ":#{#imp.commission},\r\n"
            + ":#{#imp.codeRejet},\r\n"
            + ":#{#imp.codeEtablissementBancaire},\r\n"
            + ":#{#imp.codeGuichetBancaire},\r\n"
            + ":#{#imp.dateRemise},\r\n"
            + ":#{#imp.encoursEESConso},\r\n"
            + ":#{#imp.encoursEESComm},\r\n"
            + ":#{#imp.encoursESB},\r\n"
            + ":#{#imp.encoursESI},\r\n"
            + ":#{#imp.solde},\r\n"
            + ":#{#imp.encoursDeclasse},\r\n"
            + ":#{#imp.encoursRisque},\r\n"
            + ":#{#imp.typeClient},\r\n"
            + ":#{#imp.numTiers},\r\n"
            + ":#{#imp.codeCategorie},\r\n"
            + ":#{#imp.numDossierComplet},\r\n"
            + ":#{#imp.numeroLigne},\r\n"
            + ":#{#imp.numeroTirage},\r\n"
            + ":#{#imp.dateRejet},\r\n"
            + ":#{#imp.motifRejet})", nativeQuery = true)
    public void insert(@Param("imp") ImpayesCdlRejetModel imp);

//    
//    default void insertWithLogging(@Param("imp") ImpayesCdlRejetModel imp) {
//        insert(imp); // Call the insert method to perform the actual database operation
//
//        //if()
//        
//        log.info("!!!Data inserted into IMPAYES_CDL_REJET {}");
//        // You can log additional details or perform any other necessary actions after the insertion
//    }


}
