package com.eai.BatchJobCDL.processor;


import org.springframework.batch.item.ItemProcessor;

import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.model.*;

@Component
public class ProcessorTDossier implements ItemProcessor<ImpayesCDLModel, DossierModel> {


	@Override
	public DossierModel process(ImpayesCDLModel impayescdl) throws Exception {
		
		DossierModel d = new DossierModel();

		
	    CompteModel compteshared = SharedDataCompte.sharedCompteModel;

 	
		 if (impayescdl.getNateng()!="ESC") {
	
			 d.setCLE_DOSSIER(impayescdl.getNateng()+impayescdl.getNoDossier()+impayescdl.getDateRemise());
			 //d.setCODE(i++);
			 d.setNUMERO_DOSSIER(impayescdl.getNoDossier());
			 d.setNUM_DOSSIER_COMPLET(impayescdl.getNumDossierComplet());
			 d.setNUMERO_LIGNE(impayescdl.getNumeroLigne());
			 d.setNUMERO_TIRAGE(impayescdl.getNumeroTirage());
			 
			 d.setCODE_COMPTE(compteshared.getCode()); // return null ?
			 
			 //ANCIEN_NUMERO_DOSSIER=NULL and ENCOURS=NULL
			 		 }
		 else {
			
			  String sql = "SELECT NATENG FROM IMPAYES_CDL"+
					  "SELECT NO_DOSSIER FROM IMPAYES_CDL"+
					  "SELECT DATE_REMISE FROM IMPAYES_CDL"+
					  "SELECT substr(CPT, 1, 3) FROM IMPAYES_CDL"+
					  "SELECT substr(CPT, 8, 2) FROM IMPAYES_CDL"+
					  "SELECT substr(CPT, 15, 5) FROM IMPAYES_CDL"+
					  "SELECT substr(MONTANT_CREANCE, 0, longueur(MONTANT_CREANCE) - 7) FROM IMPAYES_CDL";
			  
			  
		        
		     d.setCLE_DOSSIER(sql);
			 d.setNUMERO_DOSSIER(impayescdl.getNoDossier());
			 d.setNUM_DOSSIER_COMPLET(impayescdl.getNumDossierComplet());
			 d.setNUMERO_LIGNE(impayescdl.getNumeroLigne());
			 d.setNUMERO_TIRAGE(impayescdl.getNumeroTirage());
			 d.setTYPE_DOSSIER(impayescdl.getType());//td.getLIBELLE_COURT()
			 //ANCIEN_NUMERO_DOSSIER=NULL and ENCOURS=NULL
		        
		 }
	        System.out.println("ProcessorTdossier: ");
	        
	        SharedDataDossier.sharedDossierModel = d;

		return d;
	}
}