package com.eai.BatchJobCDL.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;

import com.eai.BatchJobCDL.DTO.EscDTO;
import com.eai.BatchJobCDL.utils.Constantes;

public class ReaderEsc extends FlatFileItemReader<EscDTO> {

	private FlatFileItemReader<EscDTO> flatFileItemReader;

	public ReaderEsc() {
	    String filePath = Constantes.ESC_FILE_PATH;
	    String[] columnNames = Constantes.ESC_ColumnNames;

	    flatFileItemReader = new FlatFileItemReader<>();
	    flatFileItemReader.setResource(new FileSystemResource(filePath));
	    flatFileItemReader.setName("ESC-Reader");

	    BeanWrapperFieldSetMapper<EscDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
	    DefaultLineMapper<EscDTO> defaultLineMapper = new DefaultLineMapper<>();
	    DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

	    lineTokenizer.setDelimiter("|");
	    lineTokenizer.setStrict(false);
	    lineTokenizer.setNames(columnNames);

	    fieldSetMapper.setTargetType(EscDTO.class);

	    defaultLineMapper.setLineTokenizer(lineTokenizer);
	    defaultLineMapper.setFieldSetMapper(fieldSetMapper);

	    flatFileItemReader.setLineMapper(defaultLineMapper);
	    System.out.println("\nValider.itemReaderEsc\n");
	}

	@Override
	public EscDTO read() throws Exception {
	    return flatFileItemReader.read();
	}
}