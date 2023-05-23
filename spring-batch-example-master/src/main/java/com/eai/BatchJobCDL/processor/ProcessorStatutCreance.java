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
	        
	    histCreance.setCodeNatDecl(item.getCodeNatEng());
	    histCreance.setCodeCreance(item.getcode());
	    
	    //RG_1
	    if(item.getCodeNatEng()=="NAT_ENG_ESC") {histCreance.setCodeDec("STATUS_RJ");}//Etat Rejete
	    else if (item.getCodeNatEng()=="NAT_ENG_SBF") {histCreance.setCodeDec("STATUS_RJ");}	    else {histCreance.setCodeDec("STATUS_IM");}	//Etat Impaye Non classÃ©
	    //RG_2 : inexplicable
	    histCreance.setDateCreation(null);
	    
	    histCreance.setUserCreaction(null);//Valeur par défaut « BATCH_INTEG_CDL
	    histCreance.setDateComite(item.getDateComite());	        
	        
	        return histCreance;
	}

}
/*
RG_2 Valeur date de création
« DATE_CREATION » :
- Si DATE_LOAD_OVO non nul
alors CREANCE.
DATE_LOAD_OVO
*/