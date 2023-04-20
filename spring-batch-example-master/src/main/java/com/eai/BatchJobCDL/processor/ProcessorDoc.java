package com.eai.BatchJobCDL.processor;


import java.io.FileWriter;
import java.io.IOException;

import org.springframework.batch.item.ItemProcessor;

import com.eai.BatchJobCDL.DTO.DocDTO;
import com.eai.BatchJobCDL.model.ImpayesCDLModel;
import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;


public class ProcessorDoc  implements ItemProcessor<DocDTO, ImpayesCDLModel>  {

	@Override
	public ImpayesCDLModel process(DocDTO item) throws Exception {
		
		ImpayesCDLModel impayesCDLModel = new ImpayesCDLModel();
		
		ImpayesCdlRejetModel docFail = new ImpayesCdlRejetModel();
		
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
			docFail.setNateng(item.getNateng());
        	docFail.setType(item.getType());
        	docFail.setCpt(item.getCpt());
        	docFail.setMontantCreance(item.getMontantCreance());
        	docFail.setDateCreance(item.getDateCreance());
        	docFail.setNoDossier(item.getNoDossier());
        	docFail.setDateEcheance(item.getDateEcheance());
        	docFail.setDateMiseImpaye(item.getDateMiseImpaye());
        	docFail.setRefferenceValeur(item.getRefferenceValeur());
        	docFail.setDateRejet(null);//date rejet
        	docFail.setMotifRejet(null); // motif rejet : la valeur du colonne "NATENG" est different à « ECH »
		}
		return impayesCDLModel;
	}
}

