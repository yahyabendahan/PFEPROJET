package com.eai.BatchJobCDL.writer;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;

import com.eai.BatchJobCDL.model.CreanceModel;

@Component
public class WriterTCreance  extends JdbcBatchItemWriter<CreanceModel>{
	
	@Autowired
	public WriterTCreance(DataSource dataSource) {
			    	
		System.out.println("WriterCreanceModel: ");
		
//    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//    	jdbcTemplate.setDataSource(dataSource);

    	//String deleteSql = "DELETE FROM CREANCE";//TEMPORAIRE
       // new JdbcTemplate(dataSource).update(deleteSql);//TEMPORAIRE

			  
		this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		this.setSql("INSERT INTO CREANCE (CODE_TYPE_DOSSIER,\r\n"
				+ "CODE_MOTIF,\r\n"
				+ "CODE_NAT_ENG,\r\n"
				+ "CODE_DOSSIER,\r\n"
				+ "MONTANT,\r\n"
				+ "DATE_ECHEANCE,\r\n"
				+ "DATE_CREANCE,\r\n"
				+ "DATE_MISE_IMPAYE,\r\n"
				+ "MONTANT_AMORTISS,\r\n"
				+ "MONTANT_INTERET_NORMAL,\r\n"
				+ "TVA_INTERET_NORMAL,\r\n"
				+ "MONTANT_INTERET_RETARD,\r\n"
				+ "TVA_INTERET_RETARD,\r\n"
				+ "PENALITE_RETARD,\r\n"
				+ "TVA_PENALITE_RETARD,\r\n"
				+ "CODE_GUICHET_BANCAIRE,\r\n"
				+ "CODE_ETABLISST_BANCAIRE,\r\n"
				+ "REFERENCE_VALEUR,\r\n"
				+ "DATE_REMISE,\r\n"
				+ "REFERENCE_LIAISON,\r\n"
				+ "CODE_CATEGORIE,\r\n"
				+ "NUMERO_COMPTE_PAYEUR,\r\n"
				+ "STATUT,\r\n"
				+ "TYPE_CREANCE,\r\n"
				+ "TYPE_PROPOSITION,\r\n"
				+ "DATE_PROPOSITION,\r\n"
				+ "NATURE_PROPOSITION,\r\n"
				+ "CODE,\r\n"
				+ "NUMERO,\r\n"
				+ "DATE_LOAD_OVO,\r\n"
				+ "STATUT_G19,\r\n"
				+ "DATE_COMITE,\r\n"
				+ "NUMERO_LIGNE,\r\n"
				+ "NUMERO_TIRAGE,\r\n"
				+ "USER_CREATION,\r\n"
				+ "ANCIEN_CODE_DOSSIER\r\n"
				+ ") " +
			        		"VALUES (\r\n"
			        		+ ":codeTypeDossier,\r\n"
			        		+ ":codeMotif,\r\n"
			        		+ ":codeNatEng,\r\n"
			        		+ ":codeDossier,\r\n"
			        		+ ":montant,\r\n"
			        		+ ":dateEcheance,\r\n"
			        		+ ":dateCreance,\r\n"
			        		+ ":dateMiseImpaye,\r\n"
			        		+ ":montantAmortiss,\r\n"
			        		+ ":montantInteretNormal,\r\n"
			        		+ ":TVAInteretNormal,\r\n"
			        		+ ":montantInteretRetard,\r\n"
			        		+ ":TVAInteretRetard,\r\n"
			        		+ ":penaliteRetard,\r\n"
			        		+ ":TVApenaliteRetard,\r\n"
			        		+ ":codeGuichetBancaire,\r\n"
			        		+ ":codeEtablissementBancaire,\r\n"
			        		+ ":referenceValeur,\r\n"
			        		+ ":dateRemise,\r\n"
			        		+ ":referenceLiaison,\r\n"
			        		+ ":codeCategorie,\r\n"
			        		+ ":numeroComptePayeur,\r\n"
			        		+ ":statut,\r\n"
			        		+ ":typeCreance,\r\n"
			        		+ ":typeProposition,\r\n"
			        		+ ":dateProposition,\r\n"
			        		+ ":natureProposition,\r\n"
			        		+ ":code,\r\n"
			        		+ ":numero,\r\n"
			        		+ ":dateLoadOVO,\r\n"
			        		+ ":statutG19,\r\n"
			        		+ ":dateComite,\r\n"
			        		+ ":numeroLigne,\r\n"
			        		+ ":numeroTirage,\r\n"
			        		+ ":userCreation,\r\n"
			        		+ ":ancienCodeDossier)");
		
		System.out.println("DELETE FROM CREANCE: ");

		this.setDataSource(dataSource);
			    
			 }


}
