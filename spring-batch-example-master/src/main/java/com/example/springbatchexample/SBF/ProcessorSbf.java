package com.example.springbatchexample.SBF;


import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.example.springbatchexample.ECH.ProcessorEch;
import com.example.springbatchexample.model.ImpayesCDLModel;

public class ProcessorSbf implements ItemProcessor<SbfDTO, ImpayesCDLModel> {

			private static final Logger log = LoggerFactory.getLogger(ProcessorEch.class);
			
			@Override
		    public ImpayesCDLModel process(SbfDTO item) {
				SbfFail sbfFail = new SbfFail();
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
		                log.info("Created ImpayesCDLModelSbf: {}", impayesCDLModel);
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
	                
	                try (FileWriter writer = new FileWriter("C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\FichierRejet\\CDL_SBF_FAILS.creances", true)) {
		        	        
		        	        writer.write(sbfFail.toString() + "\n");
		        	    
		        	} catch (IOException e) {
		        	    System.err.println("Erreur lors de l'écriture dans le fichier echfails.txt : " + e.getMessage());
		        	}
					
				}
		        return impayesCDLModel;		 
	}

}
