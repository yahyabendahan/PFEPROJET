package com.eai.BatchJobCDL.processor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.DTO.EscDTO;
import com.eai.BatchJobCDL.DTO.EscFail;
import com.eai.BatchJobCDL.model.ImpayesCDLModel;
import com.eai.BatchJobCDL.utils.ValidVal;
@Component
public class ProcessorEsc implements ItemProcessor<EscDTO, ImpayesCDLModel>{
	   
		 private static final Logger log = LoggerFactory.getLogger(ProcessorEsc.class);
		 
		@Override
	    public ImpayesCDLModel process(EscDTO item) {
	    	ImpayesCDLModel impayesCDLModel = new ImpayesCDLModel();
	    	EscFail escFail = new EscFail();
			List<String> VALID_VALUES = ValidVal.getValidValues();
	        if (item.getNateng().equals("ESC")) {
	            if (VALID_VALUES.contains(item.getType())) {
	            	impayesCDLModel.setNateng(item.getNateng());
	            	impayesCDLModel.setType(item.getType());
	            	impayesCDLModel.setCpt(item.getCpt());
	            	impayesCDLModel.setMontantCreance(item.getMontantCreance());
	            	impayesCDLModel.setDateCreance(item.getDateCreance());
	            	impayesCDLModel.setNoDossier(item.getNoDossier());
	            	impayesCDLModel.setRefferenceValeur(item.getRefferenceValeur());
	            	impayesCDLModel.setDateEcheance(item.getDateEcheance());
	            	impayesCDLModel.setCodeEtablissementBancaire(item.getCodeEtablissementBancaire());
	            	impayesCDLModel.setCodeGuichetBancaire(item.getCodeGuichetBancaire());
	            	impayesCDLModel.setDateRemise(item.getDateRemise());
	            	impayesCDLModel.setReferenceLiaison(item.getReferenceLiaison());
	            	impayesCDLModel.setCodeRejet(item.getCodeRejet());
	            	impayesCDLModel.setCommission(item.getCommission());
	                log.info("Created ImpayesCDLModelEsc: {}", impayesCDLModel);
	            }
	            else {
	            	escFail.setNateng(item.getNateng());
	            	escFail.setType(item.getType());
	            	escFail.setCpt(item.getCpt());
	            	escFail.setMontantCreance(item.getMontantCreance());
	            	escFail.setDateCreance(item.getDateCreance());
	            	escFail.setNoDossier(item.getNoDossier());
	            	escFail.setRefferenceValeur(item.getRefferenceValeur());
	            	escFail.setDateEcheance(item.getDateEcheance());
	            	escFail.setCodeEtablissementBancaire(item.getCodeEtablissementBancaire());
	            	escFail.setCodeGuichetBancaire(item.getCodeGuichetBancaire());
	            	escFail.setDateRemise(item.getDateRemise());
	            	escFail.setReferenceLiaison(item.getReferenceLiaison());
	            	escFail.setCodeRejet(item.getCodeRejet());
	            	escFail.setCommission(item.getCommission());
	                try (FileWriter writer = new FileWriter("C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\FichierRejet\\CDL_ESC_FAILS.creances", true)) {
	                    
                        writer.write(escFail.toString() + "\n");
                    
	                } catch (IOException e) {
	                    System.err.println("Erreur lors de l'écriture dans le fichier echfails.txt : " + e.getMessage());
	                }
	    		}
	        }
	        else {
	        	escFail.setNateng(item.getNateng());
            	escFail.setType(item.getType());
            	escFail.setCpt(item.getCpt());
            	escFail.setMontantCreance(item.getMontantCreance());
            	escFail.setDateCreance(item.getDateCreance());
            	escFail.setNoDossier(item.getNoDossier());
            	escFail.setRefferenceValeur(item.getRefferenceValeur());
            	escFail.setDateEcheance(item.getDateEcheance());
            	escFail.setCodeEtablissementBancaire(item.getCodeEtablissementBancaire());
            	escFail.setCodeGuichetBancaire(item.getCodeGuichetBancaire());
            	escFail.setDateRemise(item.getDateRemise());
            	escFail.setReferenceLiaison(item.getReferenceLiaison());
            	escFail.setCodeRejet(item.getCodeRejet());
            	escFail.setCommission(item.getCommission());
            	try (FileWriter writer = new FileWriter("C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\FichierRejet\\CDL_ESC_FAILS.creances", true)) {
                    
                    writer.write(escFail.toString() + "\n");
                
	            } catch (IOException e) {
	                System.err.println("Erreur lors de l'écriture dans le fichier echfails.txt : " + e.getMessage());
	            }
			}
	        return impayesCDLModel;
	    }
	}
