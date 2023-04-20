package com.eai.BatchJobCDL.processor;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.batch.item.ItemProcessor;

import com.eai.BatchJobCDL.DTO.EfaDTO;
import com.eai.BatchJobCDL.DTO.EfaFail;
import com.eai.BatchJobCDL.model.ImpayesCDLModel;
import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;

public class ProcessorEfa  implements ItemProcessor<EfaDTO, ImpayesCDLModel>  {

	@Override
	public ImpayesCDLModel process(EfaDTO item) throws Exception {
		ImpayesCDLModel impayesCDLModel = new ImpayesCDLModel();
		ImpayesCdlRejetModel efaFail = new ImpayesCdlRejetModel();
		if (item.getNateng().equals("EFA")) {
			impayesCDLModel.setNateng(item.getNateng());
        	impayesCDLModel.setType(item.getType());
        	impayesCDLModel.setCpt(item.getCpt());
        	impayesCDLModel.setMontantCreance(item.getMontantCreance());
        	impayesCDLModel.setDateCreance(item.getDateCreance());
        	impayesCDLModel.setNoDossier(item.getNoDossier());
        	impayesCDLModel.setDateEcheance(item.getDateEcheance());
        	impayesCDLModel.setDateMiseImpaye(item.getDateMiseImpaye());
        	impayesCDLModel.setRefferenceValeur(item.getRefferenceValeur());
		}
		else {
			efaFail.setNateng(item.getNateng());
        	efaFail.setType(item.getType());
        	efaFail.setCpt(item.getCpt());
        	efaFail.setMontantCreance(item.getMontantCreance());
        	efaFail.setDateCreance(item.getDateCreance());
        	efaFail.setNoDossier(item.getNoDossier());
        	efaFail.setDateEcheance(item.getDateEcheance());
        	efaFail.setDateMiseImpaye(item.getDateMiseImpaye());
        	efaFail.setRefferenceValeur(item.getRefferenceValeur());
        	try (FileWriter writer = new FileWriter("C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\FichierRejet\\CDL_EFA_FAILS.creances", true)) {
                
                writer.write(efaFail.toString() + "\n");
            
	        } catch (IOException e) {
	            System.err.println("Erreur lors de l'écriture dans le fichier echfails.txt : " + e.getMessage());
	        }
		}
		return impayesCDLModel;
	}
}


