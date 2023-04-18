package com.example.springbatchexample.TraitementDossier;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.example.springbatchexample.model.DossierModel;


//@ComponentScan(basePackages = "com.example.springbatchexample.config")
@Component
public class WriterTD extends JdbcBatchItemWriter<DossierModel>{
	
	
	
	//@Autowired
	//private DataSource dataSource;

	    
	    @SuppressWarnings("unlikely-arg-type")
	
	    public WriterTD(DataSource dataSource) {
	    	
	    	DossierModel d = new DossierModel();
	    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    	//jdbcTemplate.setDataSource(dataSource);
	    	
	    	String sql = "SELECT CLE_DOSSIER FROM DOSSIER";
	    	List<DossierModel> listDossier = jdbcTemplate.query(
	                sql,
	                new BeanPropertyRowMapper<DossierModel>(DossierModel.class));
	    	
	    	
	        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
	    	if (!listDossier.contains(d.getCLE_DOSSIER())) {
	        this.setSql("INSERT INTO Dossier (NUMERO_DOSSIER,ENCOURS, CODE_COMPTE, TYPE_DOSSIER, CLE_DOSSIER, NUM_DOSSIER_COMPLET, NUMERO_LIGNE, NUMERO_TIRAGE, ANCIEN_NUMERO_DOSSIER) " +
	        		"VALUES (:NUMERO_DOSSIER, :ENCOURS, :CODE_COMPTE,: TYPE_DOSSIER, :CLE_DOSSIER, :NUM_DOSSIER_COMPLET, :NUMERO_LIGNE, :NUMERO_TIRAGE, :ANCIEN_NUMERO_DOSSIER)");
	    	}    	
	        this.setDataSource(dataSource);
	    }
	}