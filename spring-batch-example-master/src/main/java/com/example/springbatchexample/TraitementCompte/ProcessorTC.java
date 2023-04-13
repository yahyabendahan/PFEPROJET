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
        String compteId = impayesCDLModel.getCpt();
        CompteModel compte = new CompteModel();

        String sql = "SELECT * FROM COMPTE WHERE CODE = ?";
        List<CompteModel> comptes = jdbcTemplate.query(sql, new Object[]{compteId}, new BeanPropertyRowMapper<>(CompteModel.class));
        
        if (!comptes.isEmpty()) {
        	
        	//row with code different to cpt insert into COMPTE
        	String sql1 = "SELECT * FROM COMPTE WHERE CODE != ?";
        	List<ImpayesCDLModel> comptes1 = jdbcTemplate.query(sql1, new Object[]{compteId}, new BeanPropertyRowMapper<>(ImpayesCDLModel.class));
        	
        	// compte.setCode(comptes1.get(1));
               compte.setCode(impayesCDLModel.getCpt());
        	   compte.setNumeroCompteEmprunteur(impayesCDLModel.getNumComptePayeur());
               compte.setEncoursEESConso(impayesCDLModel.getEncoursEESConso());
               compte.setEncoursEESComm(impayesCDLModel.getEncoursEESComm());
               compte.setEncoursESB(impayesCDLModel.getEncoursESB());
               compte.setEncoursESI(impayesCDLModel.getEncoursESI());
               compte.setSolde(impayesCDLModel.getSolde());
               compte.setEncoursDeclasse(impayesCDLModel.getEncoursDeclasse());
               compte.setEncoursRisque(impayesCDLModel.getEncoursRisque());
               compte.setTypeClient(impayesCDLModel.getTypeClient());
               compte.setNumTiers(impayesCDLModel.getNumTiers());
           // return comptes1.get(0);
        } else {
            compte.setCode(compteId);
            compte.setNumeroCompteEmprunteur(impayesCDLModel.getNumComptePayeur());
            compte.setEncoursEESConso(impayesCDLModel.getEncoursEESConso());
            compte.setEncoursEESComm(impayesCDLModel.getEncoursEESComm());
            compte.setEncoursESB(impayesCDLModel.getEncoursESB());
            compte.setEncoursESI(impayesCDLModel.getEncoursESI());
            compte.setSolde(impayesCDLModel.getSolde());
            compte.setEncoursDeclasse(impayesCDLModel.getEncoursDeclasse());
            compte.setEncoursRisque(impayesCDLModel.getEncoursRisque());
            compte.setTypeClient(impayesCDLModel.getTypeClient());
            compte.setNumTiers(impayesCDLModel.getNumTiers());
        }
        return compte;
    }
}
