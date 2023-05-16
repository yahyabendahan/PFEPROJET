package com.eai.BatchJobCDL.processor;

import org.springframework.batch.item.ItemProcessor;

import com.eai.BatchJobCDL.model.*;

public class ProcessorMCreance implements ItemProcessor<ImpayesCDLModel, CreanceModel>{


	@Override
	public CreanceModel process(ImpayesCDLModel item) throws Exception {
		DossierModel dossiermodel = new DossierModel();
        CompteModel comptemodel = new CompteModel();
        CreanceModel creancemodel = new CreanceModel();
        TypeDossierModel typedossier = new TypeDossierModel();
		
        creancemodel.setCodeTypeDossier(typedossier.getCODE());
        
		
        
        
        
        	
        System.out.println("ProcessorTcreance: ");
		return creancemodel;
	}

}
