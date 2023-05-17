package com.eai.BatchJobCDL.writer;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.eai.BatchJobCDL.model.Statut_Creance_HistModel;

public class WriterStatutCreance extends JdbcBatchItemWriter<Statut_Creance_HistModel> {
	
	   public WriterStatutCreance(DataSource dataSource) {
	    	
		    /*	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		    	//jdbcTemplate.setDataSource(dataSource);
		    	
		    	 String deleteSql = "DELETE FROM CLE_DOSS_CR_CPT";//TEMPORAIRE
		         new JdbcTemplate(dataSource).update(deleteSql);
		         */
		         System.out.println("WriterStatut_Creance_HistModel: ");
		    	
		    
		    	
		        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());

		        this.setSql("INSERT INTO STATUT_CREANCE_HIST (CODE ,CODE_NAT_DECL, CODE_CREANCE, CODE_DEC, DATE_CREATION, USER_CREATION, DATE_COMITE) " +
		        		"VALUES (:code, :codeNatDecl, :codeCreance, :codeDec, :dateCreation, :userCreaction, :dateComite)");
		    	
		        this.setDataSource(dataSource);
		    }

}
