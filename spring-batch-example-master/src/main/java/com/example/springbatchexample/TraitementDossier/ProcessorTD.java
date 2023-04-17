package com.example.springbatchexample.TraitementDossier;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.springbatchexample.model.*;


public class ProcessorTD implements ItemProcessor<ImpayesCDLModel, DossierModel> {
	
    private JdbcTemplate jdbcTemplate;


	@Override
	public DossierModel process(ImpayesCDLModel impayescdl) throws Exception {
		
		DossierModel d = new DossierModel();
        CompteModel c = new CompteModel();
        TypeDossierModel td = new TypeDossierModel();
		
		//String sql0 = "SELECT CLE_DOSSIER FROM DOSSIER";
		//List<DossierModel> listDossier = jdbcTemplate.query(sql0, new BeanPropertyRowMapper<>(DossierModel.class));
		
		double i=1;
		
		 if (impayescdl.getNateng()!="ESC") {
			 d.setCLE_DOSSIER(impayescdl.getNateng()+impayescdl.getNoDossier()+impayescdl.getDateRemise());
			 d.setCODE(i++);
			 d.setNUMERO_DOSSIER(impayescdl.getNoDossier());
			 d.setNUM_DOSSIER_COMPLET(impayescdl.getNumDossierComplet());
			 d.setNUMERO_LIGNE(impayescdl.getNumeroLigne());
			 d.setNUMERO_TIRAGE(impayescdl.getNumeroTirage());
			 d.setCODE_COMPTE(c.getCode());
			 d.setTYPE_DOSSIER(td.getLIBELLE_COURT());
			 //ANCIEN_NUMERO_DOSSIER=NULL and ENCOURS=NULL
			 		 }
		 else {
			 //sql substr
			  String sql = "SELECT NATENG FROM IMPAYES_CDL"+
					  "SELECT NO_DOSSIER FROM IMPAYES_CDL"+
					  "SELECT DATE_REMISE FROM IMPAYES_CDL"+
					  "SELECT substr(CPT, 1, 3) FROM IMPAYES_CDL"+
					  "SELECT substr(CPT, 8, 2) FROM IMPAYES_CDL"+
					  "SELECT substr(CPT, 15, 5) FROM IMPAYES_CDL"+
					  "SELECT substr(MONTANT_CREANCE, 0, longueur(MONTANT_CREANCE) - 7) FROM IMPAYES_CDL";
			  
			  
		        //List<ImpayesCDLModel> listImpayes = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ImpayesCDLModel.class));
		        
		     d.setCLE_DOSSIER(sql);
		   	 d.setCODE(i++);
			 d.setNUMERO_DOSSIER(impayescdl.getNoDossier());
			 d.setNUM_DOSSIER_COMPLET(impayescdl.getNumDossierComplet());
			 d.setNUMERO_LIGNE(impayescdl.getNumeroLigne());
			 d.setNUMERO_TIRAGE(impayescdl.getNumeroTirage());
			 d.setCODE_COMPTE(c.getCode());
			 d.setTYPE_DOSSIER(td.getLIBELLE_COURT());
			 //ANCIEN_NUMERO_DOSSIER=NULL and ENCOURS=NULL
		        
		 }
		
		return d;
	}
}
