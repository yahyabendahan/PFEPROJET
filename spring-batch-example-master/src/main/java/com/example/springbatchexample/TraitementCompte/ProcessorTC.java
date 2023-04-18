package com.example.springbatchexample.TraitementCompte;



import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.springbatchexample.model.CompteModel;
import com.example.springbatchexample.model.ImpayesCDLModel;


@ComponentScan(basePackages = "com.example.springbatchexample.config")

@Component
public class ProcessorTC implements ItemProcessor<ImpayesCDLModel, CompteModel> {


	@Autowired
	private DataSource dataSource;


 
    @Override
    public CompteModel process(ImpayesCDLModel impayesCDLModel) throws Exception {
        String ncp = impayesCDLModel.getNumComptePayeur();
        CompteModel comptemodel = new CompteModel();
    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


        String sql = "SELECT * FROM COMPTE WHERE NUMERO_COMPTE_EMPRUNTEUR = ?";
        List<CompteModel> comptes = jdbcTemplate.query(sql, new Object[]{ncp}, new BeanPropertyRowMapper<>(CompteModel.class));
        
        if (!comptes.isEmpty()) {
        	//condition in WriterTC
        	//double i = 1 ;
        	//comptemodel.setCode(i++);
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

        } else {
        	//double j = 1 ;
        	//comptemodel.setCode(j++);
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
        }
        return comptemodel;
    }
}
