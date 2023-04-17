package com.example.springbatchexample.TraitementCompte;



import java.util.List;
import javax.sql.DataSource;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.springbatchexample.MCN.McnDTO;
import com.example.springbatchexample.model.CompteModel;
import com.example.springbatchexample.model.ImpayesCDLModel;

@Component
public class ProcessorTC implements ItemProcessor<ImpayesCDLModel, CompteModel> {


    private JdbcTemplate jdbcTemplate;

   /* @Autowired
    public ProcessorTC(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }*/

    @Override
    public CompteModel process(ImpayesCDLModel impayesCDLModel) throws Exception {
        String ncp = impayesCDLModel.getNumComptePayeur();
        CompteModel comptemodel = new CompteModel();

        String sql = "SELECT * FROM COMPTE WHERE NumeroCompteEmprunteur = ?";
        List<CompteModel> comptes = jdbcTemplate.query(sql, new Object[]{ncp}, new BeanPropertyRowMapper<>(CompteModel.class));
        
        if (!comptes.isEmpty()) {
        	
        	//row with code different to cpt insert into COMPTE
        	String sql1 = "SELECT * FROM COMPTE WHERE NumeroCompteEmprunteur != ?";
        	List<ImpayesCDLModel> comptes1 = jdbcTemplate.query(sql1, new Object[]{ncp}, new BeanPropertyRowMapper<>(ImpayesCDLModel.class));
        	double i = 1 ;
        	comptemodel.setCode(i++);
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
           // return comptes1.get(0);
        } else {
        	double i = 1 ;
        	comptemodel.setCode(i++);
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
