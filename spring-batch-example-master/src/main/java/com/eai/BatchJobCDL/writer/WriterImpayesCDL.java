package com.eai.BatchJobCDL.writer;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.model.ImpayesCDLModel;
import com.eai.BatchJobCDL.repository.ImpayesCDLRepository;

@Component
public class WriterImpayesCDL extends JdbcBatchItemWriter<ImpayesCDLModel>{

	//test
	
	    //@Autowired
	    public WriterImpayesCDL(DataSource dataSource) {
	        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
	        
	        String deleteSql = "DELETE FROM IMPAYES_CDL";
	        new JdbcTemplate(dataSource).update(deleteSql);
	        
	        
	        this.setSql("INSERT INTO IMPAYES_CDL (NATENG, TYPE, CPT, MONTANT_CREANCE, DATE_CREANCE, NO_DOSSIER, DATE_ECHEANCE, DATE_MISE_IMPAYE,DATE_REGLEMENT, MONTANT_AMORTISSEMENT, MONTANT_INTERET_NORMAL, TVA_INTERET, MONTANT_INTERET_RETARD, TVA_INTERET_RETARD, MONATANT_PENALITE_RETARD, TVA_PENALITE_RETARD, NUM_COMPTE_PAYEUR, REFFERENCE_VALEUR, REFERNCE_LIAISON, COMISSION, CODE_REJET, CODE_ETABLISST_BANCAIRE, CODE_GUICHET_BANCAIRE, DATE_REMISE, ENCOURS_EES_CONSO, ENCOURS_EES_COMM, ENCOURS_ESB, ENCOURS_ESI ,SOLDE, ENCOURS_DECLASSE, ENCOURS_RISQUE, TYPE_CLIENT, NUM_TIERS, CODE_CATEGORIE, NUM_DOSSIER_COMPLET, NUMERO_LIGNE, NUMERO_TIRAGE) " +
	                "VALUES (:nateng, :type, :cpt, :montantCreance, :dateCreance, :noDossier, :dateEcheance, :dateMiseImpaye, :dateReglement, :montantAmortissement, :montantInteretNormal, :tvaInteret, :montantInteretRetard, :tvaInteretRetard, :montantPenaliteRetard, :tvaPenaliteRetard, :numComptePayeur, :referenceValeur, :referenceLiaison, :commission, :codeRejet, :codeEtablissementBancaire, :codeGuichetBancaire, :dateRemise, :encoursEesConso, :encoursEesComm, :encoursEsb, :encoursEsi, :solde, :encoursDeclasse, :encoursRisque, :typeClient, :numTiers, :codeCategorie, :numDossierComplet, :numeroLigne, :numeroTirage)");
	     //  repository.save(null)
	        this.setDataSource(dataSource);

	    }
	}