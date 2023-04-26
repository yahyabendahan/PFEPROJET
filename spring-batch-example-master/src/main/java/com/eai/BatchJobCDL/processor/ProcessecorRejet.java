package com.eai.BatchJobCDL.processor;

import org.springframework.batch.item.ItemProcessor;

import com.eai.BatchJobCDL.DTO.EfaDTO;
import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;

public class ProcessecorRejet  implements ItemProcessor<EfaDTO, ImpayesCdlRejetModel> {
	
	
	public ImpayesCdlRejetModel process(EfaDTO item) throws Exception {
		return null;
		
	}

}



