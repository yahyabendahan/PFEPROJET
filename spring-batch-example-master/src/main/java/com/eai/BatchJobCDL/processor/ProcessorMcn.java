package com.eai.BatchJobCDL.processor;

import org.springframework.batch.item.ItemProcessor;

import com.eai.BatchJobCDL.DTO.McnDTO;
import com.eai.BatchJobCDL.model.ImpayesCDLModel;
import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;

public class ProcessorMcn  implements ItemProcessor<McnDTO, ImpayesCDLModel>  {

	@Override
	public ImpayesCDLModel process(McnDTO item) throws Exception {
		
		ImpayesCDLModel impayesCDLModel = new ImpayesCDLModel();
    	ImpayesCdlRejetModel mcnFail = new ImpayesCdlRejetModel();
		
		
		if (item.getNateng().equals("MCN")) {
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
			mcnFail.setNateng(item.getNateng());
        	mcnFail.setType(item.getType());
        	mcnFail.setCpt(item.getCpt());
        	mcnFail.setMontantCreance(item.getMontantCreance());
        	mcnFail.setDateCreance(item.getDateCreance());
        	mcnFail.setNoDossier(item.getNoDossier());
        	mcnFail.setDateEcheance(item.getDateEcheance());
        	mcnFail.setDateMiseImpaye(item.getDateMiseImpaye());
        	mcnFail.setRefferenceValeur(item.getRefferenceValeur());
        	mcnFail.setDateRejet(null);//date rejet
        	mcnFail.setMotifRejet(null); // motif rejet : la valeur du colonne "NATENG" est different à « ECH »
		}
		return impayesCDLModel;
	}
}


