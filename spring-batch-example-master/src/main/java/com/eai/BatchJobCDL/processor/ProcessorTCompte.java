package com.eai.BatchJobCDL.processor;



import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.model.CompteModel;
import com.eai.BatchJobCDL.model.DossierModel;
import com.eai.BatchJobCDL.model.ImpayesCDLModel;



@Component
public class ProcessorTCompte implements ItemProcessor<ImpayesCDLModel, CompteModel> {

	

 
    
    public CompteModel process(ImpayesCDLModel impayesCDLModel) throws Exception {
        CompteModel comptemodel = new CompteModel();
        System.out.println("ProcessorTcompte: ");

        	comptemodel.setNumeroCompteEmprunteur(impayesCDLModel.getNumComptePayeur());
        	comptemodel.setEncoursEESConso(impayesCDLModel.getEncoursEESConso());
        	comptemodel.setEncoursEESComm(impayesCDLModel.getEncoursEESComm());
        	comptemodel.setEncoursESB(impayesCDLModel.getEncoursESB());
        	comptemodel.setEncoursESI(impayesCDLModel.getEncoursESI());
        	comptemodel.setSolde(impayesCDLModel.getSolde());
        	comptemodel.setEncoursDeclasse(impayesCDLModel.getEncoursDeclasse());
        	comptemodel.setEncoursRisque(impayesCDLModel.getEncoursRisque());
        	comptemodel.setTypeClient(impayesCDLModel.getTypeClient());
        	comptemodel.setNumTiers(impayesCDLModel.getNumTiers());

        	
	        SharedDataCompte.sharedCompteModel = comptemodel;

        return comptemodel;
    }
}
