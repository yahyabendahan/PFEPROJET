package com.eai.BatchJobCDL.processor;

import org.springframework.batch.item.ItemProcessor;

import com.eai.BatchJobCDL.DTO.DTORejet;
import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;

public class ProcessecorRejet  implements ItemProcessor<DTORejet, ImpayesCdlRejetModel> {
	
	
	public ImpayesCdlRejetModel process(DTORejet item) throws Exception {
		return null;
		
	}

}



