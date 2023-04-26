package com.eai.BatchJobCDL.processor;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.model.*;




@Component

public class ProcessorTCreance  implements ItemProcessor<CreanceModel , Cle_Doss_Cr_CptModel> {


	@Override
	public Cle_Doss_Cr_CptModel process(CreanceModel item) throws Exception {
		
		DossierModel dossiermodel = new DossierModel();
        Cle_Doss_Cr_CptModel cle_doss_cr_cpt = new Cle_Doss_Cr_CptModel();
        
		if (item.getDossier().getCODE() == dossiermodel.getCODE() ) {
			
			cle_doss_cr_cpt.setDateEcheance(item.getDateEcheance());
			cle_doss_cr_cpt.setCodeNatEng(item.getCodeNatEng()); 
			cle_doss_cr_cpt.setCode(dossiermodel.getCODE());
			cle_doss_cr_cpt.setNumeroDossier(dossiermodel.getNUMERO_DOSSIER());
			cle_doss_cr_cpt.setCpt(dossiermodel.getCODE_COMPTE().getCode()); 
		}
        System.out.println("ProcessorTcreance: ");

	    return cle_doss_cr_cpt;
	}
}
