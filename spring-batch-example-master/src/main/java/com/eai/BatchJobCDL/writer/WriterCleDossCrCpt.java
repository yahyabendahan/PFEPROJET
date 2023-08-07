package com.eai.BatchJobCDL.writer;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import com.eai.BatchJobCDL.model.Cle_Doss_Cr_CptModel;
import com.eai.BatchJobCDL.repository.Cle_Doss_Cr_CptRepository;

@Component
public class WriterCleDossCrCpt  extends JdbcBatchItemWriter<Cle_Doss_Cr_CptModel>{
	
	
	private final Cle_Doss_Cr_CptRepository cleDossCrCptRepository;
	
	//@Autowired
		//private DataSource dataSource;

		@Autowired
		    public WriterCleDossCrCpt(DataSource dataSource, Cle_Doss_Cr_CptRepository cleDossCrCptRepository) {
		    	
	        //this.cleDossCrCptRepository = cleDossCrCptRepository;

	        
		    	//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		    	//jdbcTemplate.setDataSource(dataSource);
		    	
		    	 this.cleDossCrCptRepository = cleDossCrCptRepository;
				String deleteSql = "DELETE FROM CLE_DOSS_CR_CPT";//TEMPORAIRE
		         new JdbcTemplate(dataSource).update(deleteSql);//TEMPORAIRE
		         
		         System.out.println("WriterCle_Doss_Cr_CptModel: ");
		    	
		    
		    	
		        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());

		       /* 
		         this.setSql("INSERT INTO CLE_DOSS_CR_CPT (NUMERO_DOSSIER, CODE ,CPT, DATE_ECHEANCE, CODE_NAT_ENG, CODE_TYPE_DOSSIER, CLE_DOSSIER) " +
		        		"VALUES (:numeroDossier, :code, :cpt, :dateEcheance, :codeNatEng, :codeTypeDossier, :cleDossier)");
		    	*/
		        this.setDataSource(dataSource);
		    }
		
		  @Override
    public void write(List<? extends Cle_Doss_Cr_CptModel> items) throws Exception {
        cleDossCrCptRepository.saveAll(items);
    } 
		  

}