package com.eai.BatchJobCDL.processor;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.DTO.EfaDTO;
import com.eai.BatchJobCDL.model.ImpayesCDLModel;
import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;
import com.eai.BatchJobCDL.repository.ImpayesCDLRejetRepository;


@Component

public class ProcessorEfa  implements ItemProcessor<EfaDTO, ImpayesCDLModel>  {

	@Autowired 
	private ImpayesCDLRejetRepository impayesCDLRejetRepository;


	public ImpayesCDLModel process(EfaDTO item) throws Exception {
		ImpayesCDLModel impayesCDLModel = new ImpayesCDLModel();
		ImpayesCdlRejetModel impayesCdlRejetModel = new ImpayesCdlRejetModel();
		if (item.getNateng().equals("EFA")) {
			impayesCDLModel.setNateng(item.getNateng());
        	impayesCDLModel.setType(item.getType());
        	impayesCDLModel.setCpt(item.getCpt());
        	impayesCDLModel.setMontantCreance(item.getMontantCreance());
        	impayesCDLModel.setDateCreance(item.getDateCreance());
        	impayesCDLModel.setNoDossier(item.getNoDossier());
        	impayesCDLModel.setDateEcheance(item.getDateEcheance());
        	impayesCDLModel.setDateMiseImpaye(item.getDateMiseImpaye());
        	impayesCDLModel.setRefferenceValeur(item.getRefferenceValeur());
		}
		else {
			impayesCdlRejetModel.setNateng(item.getNateng());
        	impayesCdlRejetModel.setType(item.getType());
        	impayesCdlRejetModel.setCpt(item.getCpt());
        	impayesCdlRejetModel.setMontantCreance(item.getMontantCreance());
        	impayesCdlRejetModel.setDateCreance(item.getDateCreance());
        	impayesCdlRejetModel.setNoDossier(item.getNoDossier());
        	impayesCdlRejetModel.setDateEcheance(item.getDateEcheance());
        	impayesCdlRejetModel.setDateMiseImpaye(item.getDateMiseImpaye());
        	impayesCdlRejetModel.setRefferenceValeur(item.getRefferenceValeur());
        	impayesCdlRejetModel.setDateRejet(null);//date rejet
		    impayesCdlRejetModel.setMotifRejet("la valeur du colonne NATENG est different a EFA "); 
		    impayesCDLRejetRepository.save(impayesCdlRejetModel);
			//impayesCDLRejetRepository.insert(impayesCDLRejetModel);

	        }  
	        
		//impayesCDLRejetRepository.insert(impayesCdlRejetModel);
		System.out.println("ProcessorEfa: ");
		return impayesCDLModel;
	}
}


