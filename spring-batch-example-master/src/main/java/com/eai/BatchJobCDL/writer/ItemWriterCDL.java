package com.eai.BatchJobCDL.writer;

import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.eai.BatchJobCDL.model.ImpayesCDLModel;





public class ItemWriterCDL implements ItemWriter {
	
	
	  public JdbcBatchItemWriter<ImpayesCDLModel> ImpayesCDLModelToBD(DataSource dataSource) {
		  
	   JdbcBatchItemWriter<ImpayesCDLModel> itemWriter = new JdbcBatchItemWriter<>();

	         
	             
	             
	   itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
	 	        
	 	        String deleteSql = "DELETE FROM IMPAYES_CDL";
	 	        new JdbcTemplate(dataSource).update(deleteSql);
	 	        
	 	        
	 	       itemWriter.setSql("INSERT INTO IMPAYES_CDL (NATENG, TYPE, CPT, MONTANT_CREANCE, DATE_CREANCE, NO_DOSSIER, DATE_ECHEANCE, DATE_MISE_IMPAYE,DATE_REGLEMENT, MONTANT_AMORTISSEMENT, MONTANT_INTERET_NORMAL, TVA_INTERET, MONTANT_INTERET_RETARD, TVA_INTERET_RETARD, MONATANT_PENALITE_RETARD, TVA_PENALITE_RETARD, NUM_COMPTE_PAYEUR, REFFERENCE_VALEUR, REFERNCE_LIAISON, COMISSION, CODE_REJET, CODE_ETABLISST_BANCAIRE, CODE_GUICHET_BANCAIRE, DATE_REMISE, ENCOURS_EES_CONSO, ENCOURS_EES_COMM, ENCOURS_ESB, ENCOURS_ESI ,SOLDE, ENCOURS_DECLASSE, ENCOURS_RISQUE, TYPE_CLIENT, NUM_TIERS, CODE_CATEGORIE, NUM_DOSSIER_COMPLET, NUMERO_LIGNE, NUMERO_TIRAGE) " +
	 	                "VALUES (:nateng, :type, :cpt, :montantCreance, :dateCreance, :noDossier, :dateEcheance, :dateMiseImpaye, :dateReglement, :montantAmortissement, :montantInteretNormal, :tvaInteret, :montantInteretRetard, :tvaInteretRetard, :montantPenaliteRetard, :tvaPenaliteRetard, :numComptePayeur, :referenceValeur, :referenceLiaison, :commission, :codeRejet, :codeEtablissementBancaire, :codeGuichetBancaire, :dateRemise, :encoursEesConso, :encoursEesComm, :encoursEsb, :encoursEsi, :solde, :encoursDeclasse, :encoursRisque, :typeClient, :numTiers, :codeCategorie, :numDossierComplet, :numeroLigne, :numeroTirage)");
   	 	       itemWriter.setDataSource(dataSource);
	             System.out.println("\nValider.ImpayesCDLModelToBD\n");
	             
				return itemWriter;
	  }/*
	  
	  public JdbcBatchItemWriter<ImpayesCdlRejetModel> ImpayesCdlRejetModelToBD(DataSource dataSource) {
		  
		   JdbcBatchItemWriter<ImpayesCdlRejetModel> itemWriter = new JdbcBatchItemWriter<>();

		         
		             
		             
		   itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		 	       
		 	        
		 	       itemWriter.setSql("INSERT INTO IMPAYES_CDL_REJET (NATENG, TYPE, CPT, MONTANT_CREANCE, DATE_CREANCE, NO_DOSSIER, DATE_ECHEANCE, DATE_MISE_IMPAYE,DATE_REGLEMENT, MONTANT_AMORTISSEMENT, MONTANT_INTERET_NORMAL, TVA_INTERET, MONTANT_INTERET_RETARD, TVA_INTERET_RETARD, MONATANT_PENALITE_RETARD, TVA_PENALITE_RETARD, NUM_COMPTE_PAYEUR, REFFERENCE_VALEUR, REFERNCE_LIAISON, COMISSION, CODE_REJET, CODE_ETABLISST_BANCAIRE, CODE_GUICHET_BANCAIRE, DATE_REMISE, ENCOURS_EES_CONSO, ENCOURS_EES_COMM, ENCOURS_ESB, ENCOURS_ESI ,SOLDE, ENCOURS_DECLASSE, ENCOURS_RISQUE, TYPE_CLIENT, NUM_TIERS, CODE_CATEGORIE, NUM_DOSSIER_COMPLET, NUMERO_LIGNE, NUMERO_TIRAGE,DATE_REJET,MOTIF_REJET) " +
		 	                "VALUES (:nateng, :type, :cpt, :montantCreance, :dateCreance, :noDossier, :dateEcheance, :dateMiseImpaye, :dateReglement, :montantAmortissement, :montantInteretNormal, :tvaInteret, :montantInteretRetard, :tvaInteretRetard, :montantPenaliteRetard, :tvaPenaliteRetard, :numComptePayeur, :referenceValeur, :referenceLiaison, :commission, :codeRejet, :codeEtablissementBancaire, :codeGuichetBancaire, :dateRemise, :encoursEesConso, :encoursEesComm, :encoursEsb, :encoursEsi, :solde, :encoursDeclasse, :encoursRisque, :typeClient, :numTiers, :codeCategorie, :numDossierComplet, :numeroLigne, :numeroTirage, :dateRejet, :motifRejet)");

		 	       itemWriter.setDataSource(dataSource);
		 	       
		             System.out.println("\nValider.ImpayesCdlRejetModelToBD\n");
		             
					return itemWriter;
		  }*/
	
	
	

	@Override
	public void write(List items) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
