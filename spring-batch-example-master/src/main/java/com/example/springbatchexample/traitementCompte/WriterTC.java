package com.example.springbatchexample.traitementCompte;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.springbatchexample.model.CompteModel;

@Component
public class WriterTC extends JdbcBatchItemWriter<CompteModel>{
	    
	    @Autowired
	    public WriterTC(DataSource dataSource) {
	        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());

	        this.setSql("INSERT INTO COMPTE (CODE,NUMERO_COMPTE_EMPRUNTEUR, ENCOURS_EES_CONSO, ENCOURS_EES_COMM, ENCOURS_ESB, ENCOURS_ESI, SOLDE, ENCOURS_DECLASSE, ENCOURS_RISQUE, TYPE_CLIENT, NUM_TIERS ) " +
	        		"VALUES (:code, :numeroCompteEmprunteur, :encoursEESConso, :encoursEESComm, :encoursESB, :encoursESI, :solde, :encoursDeclasse, :encoursRisque, typeClient, numTiers;)");
	        this.setDataSource(dataSource);
	    }
	}