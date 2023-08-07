package com.eai.BatchJobCDL.writer;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.model.Statut_Creance_HistModel;


@Component
public class WriterStatutCreance extends JdbcBatchItemWriter<Statut_Creance_HistModel> {
    
	@Autowired
	   public WriterStatutCreance(DataSource dataSource) {
	    	
		    	//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);//TEMPORAIRE
		    	
		    	 String deleteSql = "DELETE FROM STATUT_CREANCE_HIST";//TEMPORAIRE
		         new JdbcTemplate(dataSource).update(deleteSql);//TEMPORAIRE
		         
		         System.out.println("WriterStatut_Creance_HistModel: ");
		    	
		    
		    	
		        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());

		        this.setSql("INSERT INTO STATUT_CREANCE_HIST (CODE ,CODE_NAT_DECL, CODE_CREANCE, CODE_DEC, DATE_CREATION, USER_CREATION, DATE_COMITE) " +
		        		"VALUES (:code, :codeNatDecl, :codeCreance, :codeDec, :dateCreation, :userCreaction, :dateComite)");
		    	
		        this.setDataSource(dataSource);
		    }

}