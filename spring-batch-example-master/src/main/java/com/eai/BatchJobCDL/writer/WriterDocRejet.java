package com.eai.BatchJobCDL.writer;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;


@Component
public class WriterDocRejet extends JdbcBatchItemWriter<ImpayesCdlRejetModel>{

	//test
	
	
	    public WriterDocRejet(DataSource dataSource) {
	    	this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        
	    	this.setSql("INSERT INTO IMPAYES_CDL_REJET (NATENG, TYPE, CPT, MONTANT_CREANCE, DATE_CREANCE, NO_DOSSIER, DATE_ECHEANCE, DATE_MISE_IMPAYE, REFFERENCE_VALEUR, DATE_REJET, MOTIF_REJET) " +
                "VALUES (:nateng, :type, :cpt, :montantCreance, :dateCreance, :noDossier, :dateEcheance, :dateMiseImpaye, :refferenceValeur, :dateRejet, :motifRejet)");
     //  repository.save(null)
            System.out.println("\nValider.ImpayesCdlRejetModelToBD\n");

	    	this.setDataSource(dataSource);

    }
}