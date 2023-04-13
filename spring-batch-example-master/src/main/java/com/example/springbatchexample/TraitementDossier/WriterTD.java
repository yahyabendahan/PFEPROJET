package com.example.springbatchexample.TraitementDossier;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.springbatchexample.model.DossierModel;

@Component
public class WriterTD extends JdbcBatchItemWriter<DossierModel>{
	    
	    @Autowired
	    public WriterTD(DataSource dataSource) {
	        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());

	        this.setSql("INSERT INTO Dossier (NUMERO_DOSSIER,ENCOURS, CODE, CODE_COMPTE, TYPE_DOSSIER, CLE_DOSSIER, NUM_DOSSIER_COMPLET, NUMERO_LIGNE, NUMERO_TIRAGE, ANCIEN_NUMERO_DOSSIER) " +
	        		"VALUES (:NUMERO_DOSSIER,:ENCOURS,: CODE, :CODE_COMPTE,: TYPE_DOSSIER, :CLE_DOSSIER, :NUM_DOSSIER_COMPLET, :NUMERO_LIGNE, :NUMERO_TIRAGE, :ANCIEN_NUMERO_DOSSIER)");
	        this.setDataSource(dataSource);
	    }
	}