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
	        
	        
	        return histCreance;
	}

}
/*Nom Règle Remarque
RG_1 Valeur code déclassement
« CODE_DEC » :
- Si « CREANCE
.CODE_NAT_ENG » =
NAT_ENG_ESC alors STATUS_RJ
- Si « CODE_NAT_ENG » =
NAT_ENG_SBF alors STATUS_RJ
- Sinon STATUS_IM
RG_2 Valeur date de création
« DATE_CREATION » :
- Si DATE_LOAD_OVO non nul
alors CREANCE.
DATE_LOAD_OVO
*/