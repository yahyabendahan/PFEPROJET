package com.eai.BatchJobCDL.processor;


import java.io.FileWriter;
import java.io.IOException;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.eai.BatchJobCDL.DTO.DocDTO;
import com.eai.BatchJobCDL.model.ImpayesCDLModel;
import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;
import com.eai.BatchJobCDL.repository.ImpayesCDLRejetRepository;


public class ProcessorDoc  implements ItemProcessor<DocDTO, ImpayesCDLModel>  {
	
	@Autowired
	private ImpayesCDLRejetRepository impayesCDLRejetRepository;


	public ImpayesCDLModel process(DocDTO item) throws Exception {
		
		ImpayesCDLModel impayesCDLModel = new ImpayesCDLModel();
		
		ImpayesCdlRejetModel impayesCdlRejetModel = new ImpayesCdlRejetModel();
		
		if (item.getNateng().equals("DOC")) {
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
        	impayesCdlRejetModel.setMotifRejet(null); // motif rejet : la valeur du colonne "NATENG" est different à « ECH »
		}
		
		impayesCDLRejetRepository.save(impayesCdlRejetModel);

		return impayesCDLModel;
	}
}

