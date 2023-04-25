package com.eai.BatchJobCDL.writer;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.model.CompteModel;
import com.eai.BatchJobCDL.model.ImpayesCDLModel;


//@ComponentScan(basePackages = "com.example.springbatchexample.config")
@Component
public class WriterTC extends JdbcBatchItemWriter<CompteModel>{
	
	//@Autowired
	//private DataSource dataSource;
	
	
	    //@Autowired
	    @SuppressWarnings("unlikely-arg-type")
		public WriterTC(DataSource dataSource) {

	    	ImpayesCDLModel impayesCDLModel = new ImpayesCDLModel();

	    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	    	
	    	 String deleteSql = "DELETE FROM COMPTE";//TEMPORAIRE
	         new JdbcTemplate(dataSource).update(deleteSql);
	         System.out.println("WriterCOMPTE: ");
	    	
	    	String sql = "SELECT NUMERO_COMPTE_EMPRUNTEUR FROM COMPTE";
	    	List<CompteModel> listCompte = jdbcTemplate.query(
	                sql,
	                new BeanPropertyRowMapper<CompteModel>(CompteModel.class));
	    	
	    	    
	        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
	    	
	        if (!listCompte.contains(impayesCDLModel.getNumComptePayeur())) {
	        this.setSql("INSERT INTO COMPTE ( NUMERO_COMPTE_EMPRUNTEUR, ENCOURS_EES_CONSO, ENCOURS_EES_COMM, ENCOURS_ESB, ENCOURS_ESI, SOLDE, ENCOURS_DECLASSE, ENCOURS_RISQUE, TYPE_CLIENT, NUM_TIERS, CODE ) " +
	        		"VALUES ( :numeroCompteEmprunteur, :encoursEESConso, :encoursEESComm, :encoursESB, :encoursESI, :solde, :encoursDeclasse, :encoursRisque, :typeClient, :numTiers, :code)");
	        }
	        
	        this.setDataSource(dataSource);
	    }
	}