package com.example.springbatchexample.TraitementCompte;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.example.springbatchexample.model.CompteModel;
import com.example.springbatchexample.model.DossierModel;
import com.example.springbatchexample.model.ImpayesCDLModel;

@Component
public class WriterTC extends JdbcBatchItemWriter<CompteModel>{
	
	
	@Autowired
	private DataSource dataSource;
	ImpayesCDLModel impayesCDLModel = new ImpayesCDLModel();

	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	//jdbcTemplate.setDataSource(dataSource);
	
	String sql = "SELECT NumeroCompteEmprunteur FROM COMPTE";
	List<CompteModel> listCompte = jdbcTemplate.query(
            sql,
            new BeanPropertyRowMapper<CompteModel>(CompteModel.class));
	
	    
	    
	    //@Autowired
	    @SuppressWarnings("unlikely-arg-type")
		public WriterTC(DataSource dataSource) {
	        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
	    	
	        if (!listCompte.contains(impayesCDLModel.getNumComptePayeur())) {
	        this.setSql("INSERT INTO COMPTE (CODE,NUMERO_COMPTE_EMPRUNTEUR, ENCOURS_EES_CONSO, ENCOURS_EES_COMM, ENCOURS_ESB, ENCOURS_ESI, SOLDE, ENCOURS_DECLASSE, ENCOURS_RISQUE, TYPE_CLIENT, NUM_TIERS ) " +
	        		"VALUES (:code, :numeroCompteEmprunteur, :encoursEESConso, :encoursEESComm, :encoursESB, :encoursESI, :solde, :encoursDeclasse, :encoursRisque, :typeClient, :numTiers)");
	        }
	        this.setDataSource(dataSource);
	    }
	}