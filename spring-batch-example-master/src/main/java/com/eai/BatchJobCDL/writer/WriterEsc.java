package com.eai.BatchJobCDL.writer;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.model.ImpayesCDLModel;

@Component
public class WriterEsc extends JdbcBatchItemWriter<ImpayesCDLModel>{
	    
	    @Autowired
	    public WriterEsc(DataSource dataSource) {
	        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
	        this.setSql("INSERT INTO IMPAYES_CDL (NATENG, TYPE, CPT, MONTANT_CREANCE, DATE_CREANCE, NO_DOSSIER, REFFERENCE_VALEUR, DATE_ECHEANCE, CODE_ETABLISST_BANCAIRE, CODE_GUICHET_BANCAIRE, DATE_REMISE, REFERNCE_LIAISON, CODE_REJET, COMISSION) " +
	                "VALUES (:nateng, :type, :cpt, :montantCreance, :dateCreance, :noDossier, :refferenceValeur, :dateEcheance, :codeEtablissementBancaire, :codeGuichetBancaire, :dateRemise, :referenceLiaison, :codeRejet, :commission)");
	        this.setDataSource(dataSource);
	    }
	    
	}
