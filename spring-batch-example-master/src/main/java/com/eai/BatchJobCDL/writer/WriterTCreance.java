package com.eai.BatchJobCDL.writer;


import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import com.eai.BatchJobCDL.model.Cle_Doss_Cr_CptModel;

public class WriterTCreance  extends JdbcBatchItemWriter<Cle_Doss_Cr_CptModel>{
	
	//@Autowired
		//private DataSource dataSource;

		   		
		    public WriterTCreance(DataSource dataSource) {
		    	
		    /*	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		    	//jdbcTemplate.setDataSource(dataSource);
		    	
		    	 String deleteSql = "DELETE FROM CLE_DOSS_CR_CPT";//TEMPORAIRE
		         new JdbcTemplate(dataSource).update(deleteSql);
		         */
		         System.out.println("Writercreance: ");
		    	
		    
		    	
		        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());

		        this.setSql("INSERT INTO CLE_DOSS_CR_CPT (NUMERO_DOSSIER, CODE ,CPT, DATE_ECHEANCE, CODE_NAT_ENG, CODE_TYPE_DOSSIER, CLE_DOSSIER) " +
		        		"VALUES (:numeroDossier, :code, :cpt, :dateEcheance, :codeNatEng, :codeTypeDossier, :cleDossier)");
		    	
		        this.setDataSource(dataSource);
		    }

}
