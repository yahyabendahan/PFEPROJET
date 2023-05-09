package com.eai.BatchJobCDL.processor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.eai.BatchJobCDL.DTO.SbfDTO;
import com.eai.BatchJobCDL.model.ImpayesCDLModel;
import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;


public class ProcessorSbf implements ItemProcessor<SbfDTO, ImpayesCDLModel> {

			private static final Logger log = LoggerFactory.getLogger(ProcessorEch.class);
			
			@Override
		    public ImpayesCDLModel process(SbfDTO item) {
				
				ImpayesCdlRejetModel sbfFail = new ImpayesCdlRejetModel();
		    	ImpayesCDLModel impayesCDLModel = new ImpayesCDLModel();
		    	
		        if (item.getNateng().equals("SBF")) {
		            	impayesCDLModel.setNateng(item.getNateng());
		            	impayesCDLModel.setType(item.getType());
		            	impayesCDLModel.setCpt(item.getCpt());
		            	impayesCDLModel.setMontantCreance(item.getMontantCreance());
		            	impayesCDLModel.setDateCreance(item.getDateCreance());
		            	impayesCDLModel.setNoDossier(item.getNoDossier());
		            	impayesCDLModel.setRefferenceValeur(item.getRefferenceValeur());
		            	impayesCDLModel.setCodeEtablissementBancaire(item.getCodeEtablissementBancaire());
		            	impayesCDLModel.setCodeGuichetBancaire(item.getCodeGuichetBancaire());
		            	impayesCDLModel.setDateRemise(item.getDateRemise());
		            	impayesCDLModel.setRefferenceValeur(item.getRefferenceValeur());
		            	impayesCDLModel.setCodeRejet(item.getCodeRejet());
		            	impayesCDLModel.setCommission(item.getCommission());
		        }
		        else {
		        	sbfFail.setNateng(item.getNateng());
	            	sbfFail.setType(item.getType());
	            	sbfFail.setCpt(item.getCpt());
	            	sbfFail.setMontantCreance(item.getMontantCreance());
	            	sbfFail.setDateCreance(item.getDateCreance());
	            	sbfFail.setNoDossier(item.getNoDossier());
	            	sbfFail.setRefferenceValeur(item.getRefferenceValeur());
	            	sbfFail.setCodeEtablissementBancaire(item.getCodeEtablissementBancaire());
	            	sbfFail.setCodeGuichetBancaire(item.getCodeGuichetBancaire());
	            	sbfFail.setDateRemise(item.getDateRemise());
	            	sbfFail.setRefferenceValeur(item.getRefferenceValeur());
	            	sbfFail.setCodeRejet(item.getCodeRejet());
	            	sbfFail.setCommission(item.getCommission());
	            	sbfFail.setDateRejet(null);//date rejet
	            	sbfFail.setMotifRejet(null); // motif rejet : la valeur du colonne "NATENG" est different à « ECH »
				}
					
		        return impayesCDLModel;		 
	}

}
