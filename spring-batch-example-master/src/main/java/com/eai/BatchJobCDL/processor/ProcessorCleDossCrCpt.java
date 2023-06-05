
package com.eai.BatchJobCDL.processor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
	
	int i = 0 ;

	public Cle_Doss_Cr_CptModel process(CreanceModel item)/*ajouter dossiermodule içi !?*/ throws Exception {
		
		//DossierModel dossiermodel = new DossierModel();
		Cle_Doss_Cr_CptModel cle_doss_cr_cpt = new Cle_Doss_Cr_CptModel();
        //DossierModel shareddossiermodel = SharedDataDossier.sharedDossierModel;
		
        List<BigDecimal> dossierCodes = dossierRepo.findAllCODEs();

		DossierModel CodeDossierRepo = dossierRepo.findByCODE(item.getcodeDossier());

		if (dossierCodes.contains(item.getcodeDossier())&&(dossierCodes.size()>i)){ //(item.getcodeDossier() == CodeDossierRepo.getCODE())
			
			//cle_doss_cr_cpt.setCode(CodeDossierRepo.getCODE());
			if (dossierCodes.get(i) == null) {
		        System.out.println("if (dossierCodes.get(i) == null): "+dossierCodes.get(i));

			    return cle_doss_cr_cpt;
			}
			else {
			
			cle_doss_cr_cpt.setCode(item.getcodeDossier());
			
			cle_doss_cr_cpt.setCode(dossierCodes.get(i));
		    System.out.println("cle_doss_cr_cpt:dossierCodes[" + i + "]: " + dossierCodes.get(i));
			i++;
			
			cle_doss_cr_cpt.setNumeroDossier(CodeDossierRepo.getNUMERO_DOSSIER());
			cle_doss_cr_cpt.setCpt(CodeDossierRepo.getCODE_COMPTE()); 	
			cle_doss_cr_cpt.setCleDossier(CodeDossierRepo.getCLE_DOSSIER());

			cle_doss_cr_cpt.setDateEcheance(item.getDateEcheance());//item.getDateEcheance()
			cle_doss_cr_cpt.setCodeTypeDossier(item.getCodeTypeDossier());
			cle_doss_cr_cpt.setCodeNatEng(item.getCodeNatEng());

			}
		}
        System.out.println("ProcessorCle_Doss_Cr_Cpt: ");

	    return cle_doss_cr_cpt;
	}
}

