package com.eai.BatchJobCDL.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.model.*;


@Component
public class ProcessorStatutCreance implements ItemProcessor<CreanceModel, Statut_Creance_HistModel> {

	@Override
	public Statut_Creance_HistModel process(CreanceModel item) throws Exception {
		
	    Statut_Creance_HistModel histCreance = new Statut_Creance_HistModel();
	        if (item.getCodeNatEng() != null) {
	    histCreance.setCodeNatDecl(item.getCodeNatEng());
	    histCreance.setCodeCreance(item.getcode());
	    
	    //RG_1
	    if ((item.getCodeNatEng().equals("NAT_ENG_ESC") || item.getCodeNatEng().equals("NAT_ENG_SBF"))) {
	        histCreance.setCodeDec("STATUS_RJ"); // Etat Rejete
	    } else {
	        histCreance.setCodeDec("STATUS_IM"); // Etat Impaye Non classé
	    }

	    //RG_2 : inexplicable
	    histCreance.setDateCreation(null);
	    /*
	    RG_2 Valeur date de création
	    « DATE_CREATION » :
	    - Si DATE_LOAD_OVO non nul
	    alors CREANCE.
	    DATE_LOAD_OVO
	    */
	    histCreance.setUserCreaction("BATCH_INTEG_CDL");//Valeur par défaut « BATCH_INTEG_CDL
	    histCreance.setDateComite(item.getDateComite());	        

	        }
        System.out.println("ProcessorStatut_Creance_HistModel: ");

	        return histCreance;
	}

}
