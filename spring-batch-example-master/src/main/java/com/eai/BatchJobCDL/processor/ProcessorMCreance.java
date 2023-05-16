package com.eai.BatchJobCDL.processor;

import org.springframework.batch.item.ItemProcessor;

import com.eai.BatchJobCDL.model.*;
import com.eai.BatchJobCDL.repository.*;

public class ProcessorMCreance implements ItemProcessor<ImpayesCDLModel, CreanceModel>{


    private final TypeDossierRepository typeDossierRepository= null;
    private final NatEngRepository NatEngRepository = null ;
    
	@Override
	public CreanceModel process(ImpayesCDLModel item) throws Exception {
		DossierModel dossiermodel = new DossierModel();
        CompteModel comptemodel = new CompteModel();
        CreanceModel creancemodel = new CreanceModel();
        TypeDossierModel typedossier = new TypeDossierModel();
		
       if((NatEngRepository.findAllLibelleCourt().contains(item.getNateng()))&&(typeDossierRepository.findAllLibelleCourt().contains(item.getType())))       
        {        
            creancemodel.setCodeTypeDossier(typedossier.getCODE());
            creancemodel.setCodeMotif(null);
            creancemodel.setCodeNatEng(null);
            creancemodel.setcodeDossier(null);
            creancemodel.setMontant(null);
            creancemodel.setDateEcheance(null);
            creancemodel.setDateCreance(null);
            creancemodel.setDateMiseImpaye(null);
            creancemodel.setMontantInteretNormal(null);
            creancemodel.setTVAInteretNormal(null);
            creancemodel.setMontantInteretRetard(null);
            creancemodel.setTVAInteretRetard(null);
            creancemodel.setPenaliteRetard(null);
            creancemodel.setTVApenaliteRetard(null);
            creancemodel.setCodeGuichetBancaire(null);
            creancemodel.setCodeEtablissementBancaire(null);
            creancemodel.setReferenceValeur(null);
            creancemodel.setDateRemise(null);
            creancemodel.setReferenceLiaison(null);
            creancemodel.setCodeCategorie(null);
            creancemodel.setNumeroComptePayeur(null);
            creancemodel.setStatut(null);
            creancemodel.setTypeCreance(null);
            creancemodel.setTypeProposition(null);//null
            creancemodel.setDateProposition(null);
            creancemodel.setNatureProposition(null);
            creancemodel.setNumero(null);
            creancemodel.setDateLoadOVO(null);
            creancemodel.setStatutG19(null);
            creancemodel.setDateComite(null);
            creancemodel.setNumeroLigne(null);
            creancemodel.setNumeroTirage(null);
            creancemodel.setUserCreation(null);

        }        
		
        
        
        
        	
        System.out.println("ProcessorTcreance: ");
		return creancemodel;
	}

}
