package com.eai.BatchJobCDL.writer;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.model.DossierModel;


//@ComponentScan(basePackages = "com.example.springbatchexample.config")
@Component
public class WriterTDossier extends JdbcBatchItemWriter<DossierModel>{
	
	
	
	//@Autowired
	//private DataSource dataSource;

	    
	    @SuppressWarnings("unlikely-arg-type")
	    @Autowired
	    public WriterTDossier(DataSource dataSource) {
	    	
	    	DossierModel d = new DossierModel();
	    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    	//jdbcTemplate.setDataSource(dataSource);
	    	
	    	 String deleteSql = "DELETE FROM DOSSIER";//TEMPORAIRE
	         new JdbcTemplate(dataSource).update(deleteSql);
	         System.out.println("Writerdossier: ");
	    	
	    	String sql = "SELECT CLE_DOSSIER FROM DOSSIER";
	    	List<DossierModel> listDossier = jdbcTemplate.query(
	                sql,
	                new BeanPropertyRowMapper<DossierModel>(DossierModel.class));
	    	
	    	
	        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
	    	if (!listDossier.contains(d.getCLE_DOSSIER())) {
	        this.setSql("INSERT INTO DOSSIER (NUMERO_DOSSIER, ENCOURS, CODE ,CODE_COMPTE, TYPE_DOSSIER, CLE_DOSSIER, NUM_DOSSIER_COMPLET, NUMERO_LIGNE, NUMERO_TIRAGE, ANCIEN_NUMERO_DOSSIER ) " +
	        		"VALUES (:NUMERO_DOSSIER, :ENCOURS, :CODE, :CODE_COMPTE, :TYPE_DOSSIER, :CLE_DOSSIER, :NUM_DOSSIER_COMPLET, :NUMERO_LIGNE, :NUMERO_TIRAGE, :ANCIEN_NUMERO_DOSSIER)");
	    	}    	
	        this.setDataSource(dataSource);
	    }
	}