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
		
       // if((item.getNateng()==NATURE_ENGAGEMENT.LIBELLE_COURT)&&(item.getType()==TYPE_DOSSIER.LIBELLE_COURT))
        {        
            creancemodel.setCodeTypeDossier(typedossier.getCODE());
            creancemodel.setCodeMotif(null);
            creancemodel.setCodeNatEng(null);
        	
        }        
		
        
        
        
        	
        System.out.println("ProcessorTcreance: ");
		return creancemodel;
	}

}
