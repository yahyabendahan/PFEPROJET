package com.eai.BatchJobCDL.processor;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.DTO.EscDTO;
import com.eai.BatchJobCDL.model.ImpayesCDLModel;
import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;
import com.eai.BatchJobCDL.utils.ValidVal;
@Component
public class ProcessorEsc implements ItemProcessor<EscDTO, ImpayesCDLModel>{
	   
		// private static final Logger log = LoggerFactory.getLogger(ProcessorEsc.class);
		 
		@Override
	    public ImpayesCDLModel process(EscDTO item) {
			
	    	ImpayesCDLModel impayesCDLModel = new ImpayesCDLModel();
	    	ImpayesCdlRejetModel escFail = new ImpayesCdlRejetModel();
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
	            	escFail.setDateRejet(null);//date rejet
	                escFail.setMotifRejet(null); //motif rejet : la valeur du colonne "TYPE" n'exist pas  dans la table « TYPE_DOSSIER.LIBELLE_COURT »
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
            	escFail.setDateRejet(null);//date rejet
            	escFail.setMotifRejet(null); // motif rejet : la valeur du colonne "NATENG" est different à « ECH »
			}
	        return impayesCDLModel;
	    }
	}
