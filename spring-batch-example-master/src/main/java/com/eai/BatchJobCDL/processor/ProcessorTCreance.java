package com.eai.BatchJobCDL.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.eai.BatchJobCDL.model.*;
import com.eai.BatchJobCDL.repository.*;

public class ProcessorTCreance implements ItemProcessor<ImpayesCDLModel, CreanceModel>{

    private final NatEngRepository natEngRepository;
	private final TypeDossierRepository typeDossierRepository;

    @Autowired
    public ProcessorTCreance(TypeDossierRepository typeDossierRepository,NatEngRepository NatEngRepository) {
        this.typeDossierRepository = typeDossierRepository;
        this.natEngRepository = NatEngRepository;
    }
    
	@Override
	public CreanceModel process(ImpayesCDLModel item) throws Exception {
		DossierModel dossiermodel = new DossierModel();
       // CompteModel comptemodel = new CompteModel();
        CreanceModel creancemodel = new CreanceModel();
        TypeDossierModel typedossier = new TypeDossierModel();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Example: fichier esc (20230222)

		
       if((natEngRepository.findAllLibelleCourt().contains(item.getNateng()))&&(typeDossierRepository.findAllLibelleCourt().contains(item.getType())))       
        {        
            creancemodel.setCodeTypeDossier(typedossier.getCODE());
            creancemodel.setCodeMotif(null);
            creancemodel.setCodeNatEng(natEngRepository.findallCODE());
            creancemodel.setcodeDossier(dossiermodel.getCODE());
            creancemodel.setMontant(item.getMontantCreance()/100);
           /* creancemodel.setDateMiseImpaye(item.getDateMiseImpaye());
            creancemodel.setDateEcheance(item.getDateEcheance());
            creancemodel.setDateCreance(item.getDateCreance());    
            creancemodel.setDateRemise(item.getDateRemise());
		   */
            String StringMiseImpaye = item.getDateMiseImpaye();
            String StringEcheance = item.getDateEcheance();
            String StringCreance = item.getDateCreance();
            String StringRemise = item.getDateRemise();
            try {
                Date dateMiseImpaye = dateFormat.parse(StringMiseImpaye);
                Date DateEcheance = dateFormat.parse(StringEcheance); 
                Date DateCreance = dateFormat.parse(StringCreance);
                Date DateRemise = dateFormat.parse(StringRemise);
                
                creancemodel.setDateMiseImpaye(dateMiseImpaye);
                creancemodel.setDateEcheance(DateEcheance);
                creancemodel.setDateCreance(DateCreance);
                creancemodel.setDateRemise(DateRemise);
                
            } catch (ParseException e) {
                // Handle the parse exception if the date string is in an invalid format
                e.printStackTrace();
            }
            creancemodel.setMontantInteretNormal(item.getMontantInteretNormal()/100);
            creancemodel.setTVAInteretNormal(item.getTvaInteret()/100);
            creancemodel.setMontantInteretRetard(item.getMontantInteretRetard()/100);
            creancemodel.setTVAInteretRetard(item.getTvaInteretRetard()/100);
            creancemodel.setPenaliteRetard(item.getMontantPenaliteRetard()/100);
            creancemodel.setTVApenaliteRetard(item.getTvaPenaliteRetard()/100);
            creancemodel.setCodeGuichetBancaire(item.getCodeGuichetBancaire());
            creancemodel.setCodeEtablissementBancaire(item.getCodeEtablissementBancaire());
            creancemodel.setReferenceValeur(item.getRefferenceValeur());
            creancemodel.setReferenceLiaison(item.getReferenceLiaison());
            creancemodel.setCodeCategorie(item.getCodeCategorie());
            creancemodel.setNumeroComptePayeur(item.getNumComptePayeur());
            creancemodel.setStatut(null);//Selon CODE_NAT_ENG
            creancemodel.setTypeCreance(null);//La valeur « R »
            creancemodel.setTypeProposition(null);//null
            creancemodel.setDateProposition(null);
            creancemodel.setNatureProposition(null);
            creancemodel.setNumero(item.getNumTiers());// item.getNumDossierComplet() ?
            creancemodel.setDateLoadOVO(null);
            creancemodel.setStatutG19(null);
            creancemodel.setDateComite(null);//item.getCommission()
            creancemodel.setNumeroLigne(item.getNumeroLigne());
            creancemodel.setNumeroTirage(item.getNumeroTirage());
            creancemodel.setUserCreation(null); //Valeur par défaut « BATCH_INTEG_CDL 

        }        
 	
        System.out.println("ProcessorTcreance: ");
		return creancemodel;
	}

}

/*  //Using java.time.LocalDate (for Java 8 and later):

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// ...

String dateString = item.getDateMiseImpaye();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Replace with your desired date format
LocalDate date = LocalDate.parse(dateString, formatter);
creancemodel.setDateMiseImpaye(java.sql.Date.valueOf(date));

// ...
 * 
*/
