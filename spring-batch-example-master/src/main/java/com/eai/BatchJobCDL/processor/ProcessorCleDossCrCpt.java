package com.eai.BatchJobCDL.processor;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.model.*;




@Component
public class ProcessorCleDossCrCpt  implements ItemProcessor<CreanceModel , Cle_Doss_Cr_CptModel> {


	public Cle_Doss_Cr_CptModel process(CreanceModel item) throws Exception {
		
		DossierModel dossiermodel = new DossierModel();
        Cle_Doss_Cr_CptModel cle_doss_cr_cpt = new Cle_Doss_Cr_CptModel();
        
		if (item.getcodeDossier() == dossiermodel.getCODE() ) { // CreanceModel est vide 
			
			cle_doss_cr_cpt.setDateEcheance(item.getDateEcheance());
			cle_doss_cr_cpt.setCodeNatEng(item.getCodeNatEng()); 
			cle_doss_cr_cpt.setCode(dossiermodel.getCODE());
			cle_doss_cr_cpt.setNumeroDossier(dossiermodel.getNUMERO_DOSSIER());
			cle_doss_cr_cpt.setCpt(dossiermodel.getCODE_COMPTE()); 
			//cle_doss_cr_cpt.wait(0);
		}
        System.out.println("ProcessorCle_Doss_Cr_Cpt: ");

	    return cle_doss_cr_cpt;
	}
}
