package com.eai.BatchJobCDL.writer;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;


@Component
public class WriterEscRejet extends JdbcBatchItemWriter<ImpayesCdlRejetModel>{

	//test
	
	
	    public WriterEscRejet(DataSource dataSource) {
	    	this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        
	    	this.setSql("INSERT INTO IMPAYES_CDL_REJET (NATENG, TYPE, CPT, MONTANT_CREANCE, DATE_CREANCE, NO_DOSSIER, REFFERENCE_VALEUR, DATE_ECHEANCE, CODE_ETABLISST_BANCAIRE, CODE_GUICHET_BANCAIRE, DATE_REMISE, REFERNCE_LIAISON, CODE_REJET, COMISSION, DATE_REJET, MOTIF_REJET) " +
                "VALUES (:nateng, :type, :cpt, :montantCreance, :dateCreance, :noDossier, :refferenceValeur, :dateEcheance, :codeEtablissementBancaire, :codeGuichetBancaire, :dateRemise, :referenceLiaison, :codeRejet, :commission, :dateRejet, :motifRejet)");
     //  repository.save(null)
            System.out.println("\nValider.ImpayesCdlRejetModelToBD\n");

	    	this.setDataSource(dataSource);

    }
}