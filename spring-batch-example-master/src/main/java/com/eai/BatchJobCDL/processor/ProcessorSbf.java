package com.eai.BatchJobCDL.processor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.eai.BatchJobCDL.DTO.SbfDTO;
import com.eai.BatchJobCDL.model.ImpayesCDLModel;
import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;
import com.eai.BatchJobCDL.repository.ImpayesCDLRejetRepository;


public class ProcessorSbf implements ItemProcessor<SbfDTO, ImpayesCDLModel> {

		//	private static final Logger log = LoggerFactory.getLogger(ProcessorEch.class);
			
			@Autowired 
			private ImpayesCDLRejetRepository impayesCDLRejetRepository;

		    public ImpayesCDLModel process(SbfDTO item) {
				
				ImpayesCdlRejetModel impayesCdlRejetModel = new ImpayesCdlRejetModel();
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
		        	impayesCdlRejetModel.setNateng(item.getNateng());
	            	impayesCdlRejetModel.setType(item.getType());
	            	impayesCdlRejetModel.setCpt(item.getCpt());
	            	impayesCdlRejetModel.setMontantCreance(item.getMontantCreance());
	            	impayesCdlRejetModel.setDateCreance(item.getDateCreance());
	            	impayesCdlRejetModel.setNoDossier(item.getNoDossier());
	            	impayesCdlRejetModel.setRefferenceValeur(item.getRefferenceValeur());
	            	impayesCdlRejetModel.setCodeEtablissementBancaire(item.getCodeEtablissementBancaire());
	            	impayesCdlRejetModel.setCodeGuichetBancaire(item.getCodeGuichetBancaire());
	            	impayesCdlRejetModel.setDateRemise(item.getDateRemise());
	            	impayesCdlRejetModel.setRefferenceValeur(item.getRefferenceValeur());
	            	impayesCdlRejetModel.setCodeRejet(item.getCodeRejet());
	            	impayesCdlRejetModel.setCommission(item.getCommission());
	            	impayesCdlRejetModel.setDateRejet(null);//date rejet
	            	impayesCdlRejetModel.setMotifRejet(null); // motif rejet : la valeur du colonne "NATENG" est different à « ECH »
				}
		        impayesCDLRejetRepository.save(impayesCdlRejetModel);

		        return impayesCDLModel;		 
	}

}
