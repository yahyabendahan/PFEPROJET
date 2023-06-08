package com.eai.BatchJobCDL.processor;

import java.util.Set;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.model.*;
import com.eai.BatchJobCDL.repository.CompteRepository;

@Component
public class ProcessorTDossier implements ItemProcessor<ImpayesCDLModel, DossierModel> {

	@Autowired
	CompteRepository compterepos ;
	
	private Set<String> numdossierset = new HashSet<> ();

	
	int i = 0 ;
	@Override
	public DossierModel process(ImpayesCDLModel impayescdl) throws Exception {
		
		DossierModel d = new DossierModel();

		List<BigDecimal> comptemodel = compterepos.findAllCode();
		   // System.out.println("compteGGGGCodes[" + 5 + "]: " + comptemodel.get(5));

	    

 	if((!numdossierset.contains(impayescdl.getNoDossier()))) {//&&(impayescdl.getNoDossier()!=null)
 		numdossierset.add(impayescdl.getNoDossier());
		 if (impayescdl.getNateng()!="ESC") {
	
			 d.setCLE_DOSSIER(impayescdl.getNateng()+impayescdl.getNoDossier()+impayescdl.getDateRemise());
			 d.setNUMERO_DOSSIER(impayescdl.getNoDossier());
			 d.setNUM_DOSSIER_COMPLET(impayescdl.getNumDossierComplet());
			 d.setNUMERO_LIGNE(impayescdl.getNumeroLigne());
			 d.setNUMERO_TIRAGE(impayescdl.getNumeroTirage());
			 d.setTYPE_DOSSIER(impayescdl.getType());//td.getLIBELLE_COURT()*

			 if(comptemodel.size()>i) {
				 d.setCODE_COMPTE(comptemodel.get(i) != null ? comptemodel.get(i) : null);
 		    System.out.println("compte1Codes[" + i + "]: " + comptemodel.get(i));
			 i++;
			 }
			 else {
				 return null;
			 }

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
			 d.setTYPE_DOSSIER(impayescdl.getType());//td.getLIBELLE_COURT()*
			 
			 if(comptemodel.size()>i) {
				 d.setCODE_COMPTE(comptemodel.get(i) != null ? comptemodel.get(i) : null);
		 		    System.out.println("compte2Codes[" + i + "]: " + comptemodel.get(i));
				 i++;
				 }
			 else {
					 return null;
				 }		        
		 }
 	}
 	else {
 		return null ;
 	}
	        System.out.println("ProcessorTdossier: ");
	        
		return d  !=null ? d : new DossierModel() ;
	}
}