package com.eai.BatchJobCDL.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.DTO.EchDTO;
import com.eai.BatchJobCDL.model.ImpayesCDLModel;
import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;
import com.eai.BatchJobCDL.model.TypeDossierModel;
import com.eai.BatchJobCDL.repository.ImpayesCDLRejetRepository;
import com.eai.BatchJobCDL.repository.TypeDossierRepository;

@Component
public class ProcessorEch implements ItemProcessor<EchDTO, ImpayesCDLModel> {

	//private final TypeDossierRepositoryImpl TypeDossierRepository = new TypeDossierRepository();

	@Autowired
	private TypeDossierRepository typeDOsRepo;
	
    
	@Autowired
	private ImpayesCDLRejetRepository impayesCDLRejetRepository;


    
	
    public ImpayesCDLModel process(EchDTO item) {
		
    	
    	ImpayesCDLModel impayesCDLModel = new ImpayesCDLModel();
		ImpayesCdlRejetModel impayesCDLRejetModel = new ImpayesCdlRejetModel();
    	TypeDossierModel typeDossier = typeDOsRepo.findAllByLibelleCourt(item.getType());
    	impayesCDLRejetRepository.delete(impayesCDLRejetModel);//TRUNCATE TABLE IMPAYES_CDL_REJET;//tester


		if (item.getNateng().equals("ECH")) {
			
            if (typeDossier!=null) { // if (typeDOsRepo.findAllLibelleCourt().contains(item.getType())) {
        		System.out.println("ProcessorEch: typeDOsRepo.findAllLibelleCourt().contains(item.getType())");

                impayesCDLModel.setNateng(item.getNateng());
                impayesCDLModel.setType(item.getType());
                impayesCDLModel.setCpt(item.getCpt());
                impayesCDLModel.setMontantCreance(item.getMontantCreance());
                impayesCDLModel.setDateCreance(item.getDateCreance());
                impayesCDLModel.setNoDossier(item.getNoDossier());
                impayesCDLModel.setDateEcheance(item.getDateEcheance());
                impayesCDLModel.setDateMiseImpaye(item.getDateMiseImpaye());
                impayesCDLModel.setDateReglement(item.getDateReglement());
                impayesCDLModel.setMontantAmortissement(item.getMontantAmortissement());
                impayesCDLModel.setMontantInteretNormal(item.getMontantInteretNormal());
                impayesCDLModel.setTvaInteret(item.getTvaInteret());
                impayesCDLModel.setMontantInteretNormal(item.getMontantInteretRetard());
                impayesCDLModel.setTvaInteretRetard(item.getTvaInteretRetard());
                impayesCDLModel.setMontantPenaliteRetard(item.getMontantInteretRetard());
                impayesCDLModel.setTvaPenaliteRetard(item.getTvaPenaliteRetard());
                impayesCDLModel.setNumComptePayeur(item.getNumComptePayeur());
                impayesCDLModel.setCodeCategorie(item.getCodeCategorie());
                impayesCDLModel.setNumDossierComplet(item.getNumDossierComplet());
                impayesCDLModel.setNumeroLigne(item.getNumeroLigne());
                impayesCDLModel.setNumeroTirage(item.getNumeroTirage());
               
            }
            else {
            	impayesCDLRejetModel.setNateng(item.getNateng());
            	impayesCDLRejetModel.setType(item.getType());
            	impayesCDLRejetModel.setCpt(item.getCpt());
            	impayesCDLRejetModel.setMontantCreance(item.getMontantCreance());
            	impayesCDLRejetModel.setDateCreance(item.getDateCreance());
            	impayesCDLRejetModel.setNoDossier(item.getNoDossier());
            	impayesCDLRejetModel.setDateEcheance(item.getDateEcheance());
            	impayesCDLRejetModel.setDateMiseImpaye(item.getDateMiseImpaye());
            	impayesCDLRejetModel.setDateReglement(item.getDateReglement());
                impayesCDLRejetModel.setMontantAmortissement(item.getMontantAmortissement());
                impayesCDLRejetModel.setMontantInteretNormal(item.getMontantInteretNormal());
                impayesCDLRejetModel.setTvaInteret(item.getTvaInteret());
                impayesCDLRejetModel.setMontantInteretNormal(item.getMontantInteretRetard());
                impayesCDLRejetModel.setTvaInteretRetard(item.getTvaInteretRetard());
                impayesCDLRejetModel.setMontantPenaliteRetard(item.getMontantInteretRetard());
                impayesCDLRejetModel.setTvaPenaliteRetard(item.getTvaPenaliteRetard());
                impayesCDLRejetModel.setNumComptePayeur(item.getNumComptePayeur());
                impayesCDLRejetModel.setCodeCategorie(item.getCodeCategorie());
                impayesCDLRejetModel.setNumDossierComplet(item.getNumDossierComplet());
                impayesCDLRejetModel.setNumeroLigne(item.getNumeroLigne());
                impayesCDLRejetModel.setNumeroTirage(item.getNumeroTirage());
                impayesCDLRejetModel.setDateRejet(null);//date rejet
                impayesCDLRejetModel.setMotifRejet("la valeur du colonne TYPE n exist pas  dans la table TYPE_DOSSIER.LIBELLE_COURT"); 
        		impayesCDLRejetRepository.save(impayesCDLRejetModel);
        		//impayesCDLRejetRepository.insert(impayesCDLRejetModel);

                }
		}

        
		else {
			impayesCDLRejetModel.setNateng(item.getNateng());
		    impayesCDLRejetModel.setType(item.getType());
		    impayesCDLRejetModel.setCpt(item.getCpt());
		    impayesCDLRejetModel.setMontantCreance(item.getMontantCreance());
		    impayesCDLRejetModel.setDateCreance(item.getDateCreance());
		    impayesCDLRejetModel.setNoDossier(item.getNoDossier());
		    impayesCDLRejetModel.setDateEcheance(item.getDateEcheance());
		    impayesCDLRejetModel.setDateMiseImpaye(item.getDateMiseImpaye());
		    impayesCDLRejetModel.setDateReglement(item.getDateReglement());
		    impayesCDLRejetModel.setMontantAmortissement(item.getMontantAmortissement());
		    impayesCDLRejetModel.setMontantInteretNormal(item.getMontantInteretNormal());
		    impayesCDLRejetModel.setTvaInteret(item.getTvaInteret());
		    impayesCDLRejetModel.setMontantInteretNormal(item.getMontantInteretRetard());
		    impayesCDLRejetModel.setTvaInteretRetard(item.getTvaInteretRetard());
		    impayesCDLRejetModel.setMontantPenaliteRetard(item.getMontantInteretRetard());
		    impayesCDLRejetModel.setTvaPenaliteRetard(item.getTvaPenaliteRetard());
		    impayesCDLRejetModel.setNumComptePayeur(item.getNumComptePayeur());
		    impayesCDLRejetModel.setCodeCategorie(item.getCodeCategorie());
		    impayesCDLRejetModel.setNumDossierComplet(item.getNumDossierComplet());
		    impayesCDLRejetModel.setNumeroLigne(item.getNumeroLigne());
		    impayesCDLRejetModel.setNumeroTirage(item.getNumeroTirage());
		    impayesCDLRejetModel.setDateRejet(null);//date rejet
		    impayesCDLRejetModel.setMotifRejet("la valeur du colonne NATENG est different a ECH "); 
			impayesCDLRejetRepository.save(impayesCDLRejetModel);
			//impayesCDLRejetRepository.insert(impayesCDLRejetModel);


	}
		//impayesCDLRejetRepository.insert(impayesCDLRejetModel);
		System.out.println("ProcessorEch: ");
    return impayesCDLModel;
  }
	
}
