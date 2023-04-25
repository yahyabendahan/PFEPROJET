package com.eai.BatchJobCDL.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;

import com.eai.BatchJobCDL.DTO.McnDTO;
import com.eai.BatchJobCDL.utils.Constantes;

public class ReaderMcn extends FlatFileItemReader<McnDTO> {
	private FlatFileItemReader<McnDTO> flatFileItemReader;

	public ReaderMcn() {
	    String filePath = Constantes.MCN_FILE_PATH;
	    String[] columnNames = Constantes.MCN_ColumnNames;

	    flatFileItemReader = new FlatFileItemReader<>();
	    flatFileItemReader.setResource(new FileSystemResource(filePath));
	    flatFileItemReader.setName("MCN-Reader");

	    BeanWrapperFieldSetMapper<McnDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
	    DefaultLineMapper<McnDTO> defaultLineMapper = new DefaultLineMapper<>();
	    DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

	    lineTokenizer.setDelimiter("|");
	    lineTokenizer.setStrict(false);
	    lineTokenizer.setNames(columnNames);

	    fieldSetMapper.setTargetType(McnDTO.class);

	    defaultLineMapper.setLineTokenizer(lineTokenizer);
	    defaultLineMapper.setFieldSetMapper(fieldSetMapper);

	    flatFileItemReader.setLineMapper(defaultLineMapper);
	    System.out.println("\nValider.itemReaderMcn\n");
	}

	@Override
	public McnDTO read() throws Exception {
	    return flatFileItemReader.read();
	}



}
