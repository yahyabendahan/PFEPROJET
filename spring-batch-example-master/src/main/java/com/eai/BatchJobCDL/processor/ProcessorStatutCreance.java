package com.eai.BatchJobCDL.processor;

import org.springframework.batch.item.ItemProcessor;

import com.eai.BatchJobCDL.model.*;

public class ProcessorStatutCreance implements ItemProcessor<CreanceModel, Statut_Creance_HistModel> {

	@Override
	public Statut_Creance_HistModel process(CreanceModel item) throws Exception {
		DossierModel dossiermodel = new DossierModel();
	    CompteModel comptemodel = new CompteModel();
	    Statut_Creance_HistModel histCreance = new Statut_Creance_HistModel();
	    TypeDossierModel typedossier = new TypeDossierModel();
	        
	    //if() {
	    histCreance.setCodeNatDecl(item.getCodeNatEng());
	    histCreance.setCodeCreance(item.getcode());
	    histCreance.setCodeDec(null);//RG_1
	    histCreance.setDateCreation(null);//RG_2
	    histCreance.setUserCreaction(null);//Valeur par défaut « BATCH_INTEG_CDL
	    histCreance.setDateComite(item.getDateComite());
	        
	   // }
	        
	        
	        return null;
	}

}
