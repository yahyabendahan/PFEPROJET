package com.eai.BatchJobCDL.writer;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.model.ImpayesCDLModel;

@Component
public class WriterDoc extends JdbcBatchItemWriter<ImpayesCDLModel>{
	    

	    @Autowired
	    public WriterDoc(DataSource dataSource) {
	        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
	        this.setSql("INSERT INTO IMPAYES_CDL (NATENG, TYPE, CPT, MONTANT_CREANCE, DATE_CREANCE, NO_DOSSIER, DATE_ECHEANCE, DATE_MISE_IMPAYE, REFFERENCE_VALEUR) " +
	                "VALUES (:nateng, :type, :cpt, :montantCreance, :dateCreance, :noDossier, :dateEcheance, :dateMiseImpaye, :refferenceValeur)");
	     //  repository.save(null)
	        System.out.println("WriterDoc: ");

	        this.setDataSource(dataSource);

	    }
	}