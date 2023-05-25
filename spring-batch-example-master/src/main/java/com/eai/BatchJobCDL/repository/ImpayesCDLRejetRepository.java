package com.eai.BatchJobCDL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;

public interface ImpayesCDLRejetRepository extends JpaRepository<ImpayesCdlRejetModel, String> {
	
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "INSERT INTO CDL.IMPAYES_CDL_REJET (NATENG, TYPE, CPT, MONTANT_CREANCE, DATE_CREANCE, NO_DOSSIER, DATE_ECHEANCE, DATE_MISE_IMPAYE,DATE_REGLEMENT, MONTANT_AMORTISSEMENT, MONTANT_INTERET_NORMAL, TVA_INTERET, MONTANT_INTERET_RETARD, TVA_INTERET_RETARD, MONATANT_PENALITE_RETARD, TVA_PENALITE_RETARD, NUM_COMPTE_PAYEUR, REFFERENCE_VALEUR, REFERNCE_LIAISON, COMISSION, CODE_REJET, CODE_ETABLISST_BANCAIRE, CODE_GUICHET_BANCAIRE, DATE_REMISE, ENCOURS_EES_CONSO, ENCOURS_EES_COMM, ENCOURS_ESB, ENCOURS_ESI ,SOLDE, ENCOURS_DECLASSE, ENCOURS_RISQUE, TYPE_CLIENT, NUM_TIERS, CODE_CATEGORIE, NUM_DOSSIER_COMPLET, NUMERO_LIGNE, NUMERO_TIRAGE,DATE_REJET,MOTIF_REJET) "
			+ "VALUES (#{#imp.nateng}, #{#imp.type}, #{#imp.cpt}, #{#imp.montantCreance}, #{#imp.dateCreance}, #{#imp.noDossier}, #{#imp.dateEcheance}, #{#imp.dateMiseImpaye}, #{#imp.dateReglement}, #{#imp.montantAmortissement}, #{#imp.montantInteretNormal}, #{#imp.tvaInteret}, #{#imp.montantInteretRetard}, #{#imp.tvaInteretRetard}, #{#imp.montantPenaliteRetard}, #{#imp.tvaPenaliteRetard}, #{#imp.numComptePayeur}, #{#imp.referenceValeur}, #{#imp.referenceLiaison}, #{#imp.commission}, #{#imp.codeRejet}, #{#imp.codeEtablissementBancaire}, #{#imp.codeGuichetBancaire}, #{#imp.dateRemise}, #{#imp.encoursEesConso}, #{#imp.encoursEesComm}, #{#imp.encoursEsb}, #{#imp.encoursEsi}, #{#imp.solde}, #{#imp.encoursDeclasse}, #{#imp.encoursRisque}, #{#imp.typeClient}, #{#imp.numTiers}, #{#imp.codeCategorie}, #{#imp.numDossierComplet},#{ #imp.numeroLigne },#{ #imp.numeroTirage },#{ #imp.dateRejet },#{ #imp.motifRejet })", nativeQuery = true)
	public void insert(@Param("imp")  ImpayesCdlRejetModel imp);
}