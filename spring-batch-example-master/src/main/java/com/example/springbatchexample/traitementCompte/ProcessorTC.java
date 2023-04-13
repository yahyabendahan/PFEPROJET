package com.example.springbatchexample.traitementCompte;



import java.util.List;
import javax.sql.DataSource;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.springbatchexample.model.CompteModel;
import com.example.springbatchexample.model.ImpayesCDLModel;

@Component
public class ProcessorTC implements ItemProcessor<ImpayesCDLModel, CompteModel> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessorTC(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public CompteModel process(ImpayesCDLModel impayesCDLModel) throws Exception {
        String compteId = impayesCDLModel.getCpt();

        String sql = "SELECT * FROM COMPTE WHERE COMPTE_ID = ?";
        List<CompteModel> comptes = jdbcTemplate.query(sql, new Object[]{compteId}, new BeanPropertyRowMapper<>(CompteModel.class));
        if (!comptes.isEmpty()) {
            return comptes.get(0);
        } else {
            CompteModel compte = new CompteModel();
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
            return compte;
        }
    }
}
