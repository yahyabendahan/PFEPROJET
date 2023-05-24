package com.eai.BatchJobCDL.processor;



import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.DTO.EchDTO;
import com.eai.BatchJobCDL.model.ImpayesCDLModel;
import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;
import com.eai.BatchJobCDL.repository.*;

import com.eai.BatchJobCDL.repository.TypeDossierRepository;

//@EnableJpaRepositories(basePackages = "com.eai.BatchJobCDL.repository"+"com.eai.BatchJobCDL.model")
@Component
//@ComponentScan("com.eai.BatchJobCDL.model"+"com.eai.BatchJobCDL.repository")

public class ProcessorEch implements ItemProcessor<EchDTO, ImpayesCDLModel> {

	//private final TypeDossierRepositoryImpl TypeDossierRepository = new TypeDossierRepository();

	@Autowired
	TypeDossierRepository typeDOsRepo;
	
    
    
	
    public ImpayesCDLModel process(EchDTO item) {
		
    	ImpayesCDLModel impayesCDLModel = new ImpayesCDLModel();
	//	List<String> VALID_VALUES = typeDOsRepo.findOneByLibelleCourt();
		ImpayesCdlRejetModel echFail = new ImpayesCdlRejetModel();
		
		if (item.getNateng().equals("ECH")) {
			
            if (typeDOsRepo.findOneByLibelleCourt(item.getType())!=null) { // if (typeDOsRepo.findAllLibelleCourt().contains(item.getType())) {
            	
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
            	echFail.setNateng(item.getNateng());
                echFail.setType(item.getType());
                echFail.setCpt(item.getCpt());
                echFail.setMontantCreance(item.getMontantCreance());
                echFail.setDateCreance(item.getDateCreance());
                echFail.setNoDossier(item.getNoDossier());
                echFail.setDateEcheance(item.getDateEcheance());
                echFail.setDateMiseImpaye(item.getDateMiseImpaye());
                echFail.setDateReglement(item.getDateReglement());
                echFail.setMontantAmortissement(item.getMontantAmortissement());
                echFail.setMontantInteretNormal(item.getMontantInteretNormal());
                echFail.setTvaInteret(item.getTvaInteret());
                echFail.setMontantInteretNormal(item.getMontantInteretRetard());
                echFail.setTvaInteretRetard(item.getTvaInteretRetard());
                echFail.setMontantPenaliteRetard(item.getMontantInteretRetard());
                echFail.setTvaPenaliteRetard(item.getTvaPenaliteRetard());
                echFail.setNumComptePayeur(item.getNumComptePayeur());
                echFail.setCodeCategorie(item.getCodeCategorie());
                echFail.setNumDossierComplet(item.getNumDossierComplet());
                echFail.setNumeroLigne(item.getNumeroLigne());
                echFail.setNumeroTirage(item.getNumeroTirage());
                echFail.setDateRejet(null);//date rejet
                echFail.setMotifRejet(null); //motif rejet : la valeur du colonne "TYPE" n'exist pas  dans la table « TYPE_DOSSIER.LIBELLE_COURT »

                }
		}


        
		else {
			echFail.setNateng(item.getNateng());
		    echFail.setType(item.getType());
		    echFail.setCpt(item.getCpt());
		    echFail.setMontantCreance(item.getMontantCreance());
		    echFail.setDateCreance(item.getDateCreance());
		    echFail.setNoDossier(item.getNoDossier());
		    echFail.setDateEcheance(item.getDateEcheance());
		    echFail.setDateMiseImpaye(item.getDateMiseImpaye());
		    echFail.setDateReglement(item.getDateReglement());
		    echFail.setMontantAmortissement(item.getMontantAmortissement());
		    echFail.setMontantInteretNormal(item.getMontantInteretNormal());
		    echFail.setTvaInteret(item.getTvaInteret());
		    echFail.setMontantInteretNormal(item.getMontantInteretRetard());
		    echFail.setTvaInteretRetard(item.getTvaInteretRetard());
		    echFail.setMontantPenaliteRetard(item.getMontantInteretRetard());
		    echFail.setTvaPenaliteRetard(item.getTvaPenaliteRetard());
		    echFail.setNumComptePayeur(item.getNumComptePayeur());
		    echFail.setCodeCategorie(item.getCodeCategorie());
		    echFail.setNumDossierComplet(item.getNumDossierComplet());
		    echFail.setNumeroLigne(item.getNumeroLigne());
		    echFail.setNumeroTirage(item.getNumeroTirage());
		    echFail.setDateRejet(null);//date rejet
		    echFail.setMotifRejet(null); // motif rejet : la valeur du colonne "NATENG" est different à « ECH »
	}
		
    return impayesCDLModel;
  }
	
}
