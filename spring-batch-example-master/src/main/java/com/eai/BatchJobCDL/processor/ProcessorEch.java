package com.eai.BatchJobCDL.processor;



import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.DTO.EchDTO;
import com.eai.BatchJobCDL.DTO.EchFail;
import com.eai.BatchJobCDL.model.ImpayesCDLModel;
import com.eai.BatchJobCDL.utils.ValidVal;

@Component
public class ProcessorEch implements ItemProcessor<EchDTO, ImpayesCDLModel> {

	private static final Logger log = LoggerFactory.getLogger(ProcessorEch.class);
	
	@Override
    public ImpayesCDLModel process(EchDTO item) {
    	ImpayesCDLModel impayesCDLModel = new ImpayesCDLModel();
		List<String> VALID_VALUES = ValidVal.getValidValues();
		EchFail echFail = new EchFail();
		
		if (item.getNateng().equals("ECH")) {
            if (VALID_VALUES.contains(item.getType())) {
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
               
                log.info("Created ImpayesCDLModel: {}", impayesCDLModel);
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
                try (FileWriter writer = new FileWriter("C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\FichierRejet\\CDL_ECH_FAILS.creances", true)) {
                    
                        writer.write(echFail.toString() + "\n");
                    
                } catch (IOException e) {
                    System.err.println("Erreur lors de l'écriture dans le fichier echfails.txt : " + e.getMessage());
                }
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
    try (FileWriter writer = new FileWriter("C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\FichierRejet\\CDL_ECH_FAILS.creances", true)) {
        
        writer.write(echFail.toString() + "\n");
    
	} catch (IOException e) {
	    System.err.println("Erreur lors de l'écriture dans le fichier echfails.txt : " + e.getMessage());
	}
	}
		
    return impayesCDLModel;
  }}
