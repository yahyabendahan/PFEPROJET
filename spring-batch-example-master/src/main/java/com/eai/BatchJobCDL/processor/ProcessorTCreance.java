package com.eai.BatchJobCDL.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.eai.BatchJobCDL.model.*;
import com.eai.BatchJobCDL.repository.*;
import java.math.BigDecimal;


@Component
public class ProcessorTCreance implements ItemProcessor<ImpayesCDLModel, CreanceModel>{

	@Autowired
	TypeDossierRepository typeDOsRepo;
	
	@Autowired
	NatEngRepository natgRepo;
	
	@Autowired
	DossierRepository dossierRepo;

	
	public CreanceModel process(ImpayesCDLModel item) throws Exception {
		//DossierModel dossiermodel = new DossierModel();
        CreanceModel creancemodel = new CreanceModel();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd"); // Example: fichier esc (20230222) // Unparseable date: "20220921"
        BigDecimal divisor = new BigDecimal(100);
        TypeDossierModel typeDossier = typeDOsRepo.findAllByLibelleCourt(item.getType());
        NatEngModel natengcdl = natgRepo.findAllByLibelleCourt(item.getNateng());
        DossierModel dossiermodel = dossierRepo.findAllByCODE(); // Adjust the criteria to retrieve the appropriate DossierModel

        
       if((natengcdl!=null)&&(typeDossier!=null))       
        {        
            creancemodel.setCodeTypeDossier(typeDossier.getCODE());
            creancemodel.setCodeMotif(null);//CODE_REJE
            creancemodel.setCodeNatEng(natengcdl.getCODE());
            
            //BigDecimal codedoss = dossiermodel.getCODE();
            creancemodel.setcodeDossier(dossiermodel.getCODE());
            
            
            
//            BigDecimal codedoss = dossierRepo.findAllByCODE(dossiermodel.getCODE()).getCODE();
//            creancemodel.setcodeDossier(codedoss);
            
            //    creancemodel.setcodeDossier(dossierRepo.findAllByCODE(dossiermodel.getCODE()).getCODE());
            
          /*  DossierModel DossierCode = dossierRepo.findOneByCODE(dossiermodel.getCODE()); // autre façon d'ecrire
            creancemodel.setcodeDossier(DossierCode.getCODE());*/ 
            
            String StringMiseImpaye = item.getDateMiseImpaye();
            String StringEcheance = item.getDateEcheance();
            String StringCreance = item.getDateCreance();
            String StringRemise = item.getDateRemise();

            Date dateMiseImpaye = null;
            Date DateEcheance = null;
            Date DateCreance = null;
            Date DateRemise = null;

            try {

            		if (StringMiseImpaye != null) {
            				dateMiseImpaye = dateFormat.parse(StringMiseImpaye);
            			}

            		if (StringEcheance != null) {
            				DateEcheance = dateFormat.parse(StringEcheance);
            			}

            		if (StringCreance != null) {
            			DateCreance = dateFormat.parse(StringCreance);
            			}

            		if (StringRemise != null) {
            			DateRemise = dateFormat.parse(StringRemise);
            			}

            		creancemodel.setDateMiseImpaye(dateMiseImpaye);
            		creancemodel.setDateEcheance(DateEcheance);
            		creancemodel.setDateCreance(DateCreance);
            		creancemodel.setDateRemise(DateRemise);

                
            } catch (ParseException e) {
                // Handle the parse exception if the date string is in an invalid format
                e.printStackTrace();
            }

            creancemodel.setMontantInteretNormal(item.getMontantInteretNormal() != null ? item.getMontantInteretNormal().divide(divisor) : null);
            creancemodel.setTVAInteretNormal(item.getTvaInteret() != null ? item.getTvaInteret().divide(divisor) : null);
            creancemodel.setMontantInteretRetard(item.getMontantInteretRetard() != null ? item.getMontantInteretRetard().divide(divisor) : null);
            creancemodel.setTVAInteretRetard(item.getTvaInteretRetard() != null ? item.getTvaInteretRetard().divide(divisor) : null);
            creancemodel.setPenaliteRetard(item.getMontantPenaliteRetard() != null ? item.getMontantPenaliteRetard().divide(divisor) : null);
            creancemodel.setTVApenaliteRetard(item.getTvaPenaliteRetard() != null ? item.getTvaPenaliteRetard().divide(divisor) : null);
            creancemodel.setMontant(item.getMontantCreance() != null ? item.getMontantCreance().divide(divisor) : null);
            creancemodel.setCodeGuichetBancaire(item.getCodeGuichetBancaire());
            creancemodel.setCodeEtablissementBancaire(item.getCodeEtablissementBancaire());
            creancemodel.setReferenceValeur(item.getRefferenceValeur());
            creancemodel.setReferenceLiaison(item.getReferenceLiaison());
            creancemodel.setCodeCategorie(item.getCodeCategorie());
            creancemodel.setNumeroComptePayeur(item.getNumComptePayeur());
            
           
    	    if(natengcdl.getCODE().equals("NAT_ENG_ESC") || natengcdl.getCODE().equals("NAT_ENG_SBF"))
    	    	{creancemodel.setStatut("STATUS_RJ");}//Etat Rejete
    	    else 
    	    	{creancemodel.setStatut("STATUS_IM");}	//Etat Impaye Non classÃ©
            
            creancemodel.setTypeCreance("R");//La valeur « R »
            creancemodel.setTypeProposition(null);//null
            creancemodel.setDateProposition(null);
            creancemodel.setNatureProposition(null);
            creancemodel.setNumero(item.getNumTiers());// item.getNumDossierComplet() ?
            creancemodel.setDateLoadOVO(null);
            creancemodel.setStatutG19(null);
            creancemodel.setDateComite(null);//item.getCommission()
            creancemodel.setNumeroLigne(item.getNumeroLigne());
            creancemodel.setNumeroTirage(item.getNumeroTirage());
            creancemodel.setUserCreation("BATCH_INTEG_CDL"); //Valeur par défaut « BATCH_INTEG_CDL 

        }        
 	
        System.out.println("ProcessorTcreance: ");
		return creancemodel;
	}

}

