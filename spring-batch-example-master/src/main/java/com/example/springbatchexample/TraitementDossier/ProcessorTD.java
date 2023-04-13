package com.example.springbatchexample.TraitementDossier;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.springbatchexample.model.DossierModel;
import com.example.springbatchexample.model.ImpayesCDLModel;

public class ProcessorTD implements ItemProcessor<ImpayesCDLModel, DossierModel> {
	
    private JdbcTemplate jdbcTemplate;


	@Override
	public DossierModel process(ImpayesCDLModel impayescdl) throws Exception {
		DossierModel d = new DossierModel();
		
		
		 if (d.getCLE_DOSSIER().isEmpty()) {
			 d.setCLE_DOSSIER(impayescdl.getNateng()+impayescdl.getNoDossier()+impayescdl.getDateRemise());
			 //...
		 }
		 else {
			 //sql substr
		 }
		
		return null;
	}
}
