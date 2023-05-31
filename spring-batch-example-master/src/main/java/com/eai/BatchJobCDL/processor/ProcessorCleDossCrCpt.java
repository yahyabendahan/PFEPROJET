
package com.eai.BatchJobCDL.processor;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.model.*;
import com.eai.BatchJobCDL.repository.DossierRepository;




@Component
public class ProcessorCleDossCrCpt  implements ItemProcessor<CreanceModel , Cle_Doss_Cr_CptModel> {


	@Autowired
	DossierRepository dossierRepo;

	public Cle_Doss_Cr_CptModel process(CreanceModel item)/*ajouter dossiermodule içi !?*/ throws Exception {
		
		DossierModel dossiermodel = new DossierModel();
		Cle_Doss_Cr_CptModel cle_doss_cr_cpt = new Cle_Doss_Cr_CptModel();
        
		if ( item.getcodeDossier() == dossiermodel.getCODE() ){// CreanceModel est vide 
			
			//cle_doss_cr_cpt.setCode(dossiermodel.getCODE());//	dossiermodel.getCODE() /  item.getcode()
			cle_doss_cr_cpt.setCode( item.getcode());

			//dossierRepo.findAllByCODE(dossiermodel.getCODE()).getCODE()
			cle_doss_cr_cpt.setNumeroDossier(dossiermodel.getNUMERO_DOSSIER());
			cle_doss_cr_cpt.setCpt(dossiermodel.getCODE_COMPTE()); 	
			cle_doss_cr_cpt.setDateEcheance(item.getDateEcheance());//item.getDateEcheance()
			cle_doss_cr_cpt.setCodeTypeDossier(item.getCodeTypeDossier());
			cle_doss_cr_cpt.setCleDossier(dossiermodel.getCLE_DOSSIER());
			cle_doss_cr_cpt.setCodeNatEng(item.getCodeNatEng());

		
		}
        System.out.println("ProcessorCle_Doss_Cr_Cpt: ");

	    return cle_doss_cr_cpt;
	}
}

