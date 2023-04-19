package com.eai.BatchJobCDL.processor;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.batch.item.ItemProcessor;

import com.eai.BatchJobCDL.DTO.McnDTO;
import com.eai.BatchJobCDL.DTO.McnFail;
import com.eai.BatchJobCDL.model.ImpayesCDLModel;

public class ProcessorMcn  implements ItemProcessor<McnDTO, ImpayesCDLModel>  {

	@Override
	public ImpayesCDLModel process(McnDTO item) throws Exception {
		ImpayesCDLModel impayesCDLModel = new ImpayesCDLModel();
		McnFail mcnFail = new McnFail();
		if (item.getNateng().equals("MCN")) {
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
			mcnFail.setNateng(item.getNateng());
        	mcnFail.setType(item.getType());
        	mcnFail.setCpt(item.getCpt());
        	mcnFail.setMontantCreance(item.getMontantCreance());
        	mcnFail.setDateCreance(item.getDateCreance());
        	mcnFail.setNoDossier(item.getNoDossier());
        	mcnFail.setDateEcheance(item.getDateEcheance());
        	mcnFail.setDateMiseImpaye(item.getDateMiseImpaye());
        	mcnFail.setRefferenceValeur(item.getRefferenceValeur());
            try (FileWriter writer = new FileWriter("C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\FichierRejet\\CDL_MCN_FAILS.creances", true)) {
                
                writer.write(mcnFail.toString() + "\n");
            
	        } catch (IOException e) {
	            System.err.println("Erreur lors de l'écriture dans le fichier echfails.txt : " + e.getMessage());
	        }
		}
		return impayesCDLModel;
	}
}


