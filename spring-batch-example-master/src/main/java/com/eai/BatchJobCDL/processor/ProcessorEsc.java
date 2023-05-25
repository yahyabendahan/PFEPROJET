package com.eai.BatchJobCDL.processor;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.DTO.EscDTO;
import com.eai.BatchJobCDL.model.ImpayesCDLModel;
import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;
import com.eai.BatchJobCDL.repository.ImpayesCDLRejetRepository;
import com.eai.BatchJobCDL.repository.TypeDossierRepository;
@Component
public class ProcessorEsc implements ItemProcessor<EscDTO, ImpayesCDLModel>{
	   
		// private static final Logger log = LoggerFactory.getLogger(ProcessorEsc.class);

	@Autowired
	private TypeDossierRepository typeDOsRepo;
	@Autowired 
	private ImpayesCDLRejetRepository impayesCDLRejetRepository;

	

   // @Autowired
   
		@Override
	    public ImpayesCDLModel process(EscDTO item) {
			
	    	ImpayesCDLModel impayesCDLModel = new ImpayesCDLModel();
	    	ImpayesCdlRejetModel impayesCdlRejetModel = new ImpayesCdlRejetModel();
			//List<String> VALID_VALUES = ValidVal.getLibelleCourt();
			
	        if (item.getNateng().equals("ESC")) {
	            if (typeDOsRepo.findOneByLibelleCourt()==item.getType()) {
	    	        System.out.println("ProcessorEsc+++++++++++++++++++++");

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
	            /* else {
	            	impayesCdlRejetModel.setNateng(item.getNateng());
	            	impayesCdlRejetModel.setType(item.getType());
	            	impayesCdlRejetModel.setCpt(item.getCpt());
	            	impayesCdlRejetModel.setMontantCreance(item.getMontantCreance());
	            	impayesCdlRejetModel.setDateCreance(item.getDateCreance());
	            	impayesCdlRejetModel.setNoDossier(item.getNoDossier());
	            	impayesCdlRejetModel.setRefferenceValeur(item.getRefferenceValeur());
	            	impayesCdlRejetModel.setDateEcheance(item.getDateEcheance());
	            	impayesCdlRejetModel.setCodeEtablissementBancaire(item.getCodeEtablissementBancaire());
	            	impayesCdlRejetModel.setCodeGuichetBancaire(item.getCodeGuichetBancaire());
	            	impayesCdlRejetModel.setDateRemise(item.getDateRemise());
	            	impayesCdlRejetModel.setReferenceLiaison(item.getReferenceLiaison());
	            	impayesCdlRejetModel.setCodeRejet(item.getCodeRejet());
	            	impayesCdlRejetModel.setCommission(item.getCommission());
	            	impayesCdlRejetModel.setDateRejet(null);//date rejet
	                impayesCdlRejetModel.setMotifRejet(" la valeur du colonne \"TYPE\" n'exist pas  dans la table « TYPE_DOSSIER.LIBELLE_COURT »");
	    		}*/
	        }
	  /*      else {
	        	impayesCdlRejetModel.setNateng(item.getNateng());
            	impayesCdlRejetModel.setType(item.getType());
            	impayesCdlRejetModel.setCpt(item.getCpt());
            	impayesCdlRejetModel.setMontantCreance(item.getMontantCreance());
            	impayesCdlRejetModel.setDateCreance(item.getDateCreance());
            	impayesCdlRejetModel.setNoDossier(item.getNoDossier());
            	impayesCdlRejetModel.setRefferenceValeur(item.getRefferenceValeur());
            	impayesCdlRejetModel.setDateEcheance(item.getDateEcheance());
            	impayesCdlRejetModel.setCodeEtablissementBancaire(item.getCodeEtablissementBancaire());
            	impayesCdlRejetModel.setCodeGuichetBancaire(item.getCodeGuichetBancaire());
            	impayesCdlRejetModel.setDateRemise(item.getDateRemise());
            	impayesCdlRejetModel.setReferenceLiaison(item.getReferenceLiaison());
            	impayesCdlRejetModel.setCodeRejet(item.getCodeRejet());
            	impayesCdlRejetModel.setCommission(item.getCommission());
            	impayesCdlRejetModel.setDateRejet(null);//date rejet
    		    impayesCdlRejetModel.setMotifRejet("la valeur du colonne \"NATENG\" est different à « ESC »"); 
			}
*/
	        impayesCDLRejetRepository.insert(impayesCdlRejetModel);
	        System.out.println("ProcessorEsc: ");
	        return impayesCDLModel;
	    }
	}
