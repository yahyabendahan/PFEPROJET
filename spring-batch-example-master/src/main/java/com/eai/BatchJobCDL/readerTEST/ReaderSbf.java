package com.eai.BatchJobCDL.readerTEST;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;

import com.eai.BatchJobCDL.DTO.SbfDTO;
import com.eai.BatchJobCDL.utils.Constantes;

public class ReaderSbf extends FlatFileItemReader<SbfDTO> {
	
	private FlatFileItemReader<SbfDTO> flatFileItemReader ;
	private DefaultLineMapper<SbfDTO> defaultLineMapper ;
	private BeanWrapperFieldSetMapper<SbfDTO> fieldSetMapper;
	private DelimitedLineTokenizer lineTokenizer ;
	

	public ReaderSbf() {
	    String filePath = Constantes.SBF_FILE_PATH;
	    String[] columnNames = Constantes.SBF_ColumnNames;

	    flatFileItemReader = new FlatFileItemReader<>();
	    flatFileItemReader.setResource(new FileSystemResource(filePath));
	    flatFileItemReader.setName("SBF-Reader");

	    fieldSetMapper = new BeanWrapperFieldSetMapper<>();
	    lineTokenizer = new DelimitedLineTokenizer();

	    lineTokenizer.setDelimiter("|");
	    lineTokenizer.setStrict(false);
	    lineTokenizer.setNames(columnNames);

	    fieldSetMapper.setTargetType(SbfDTO.class);

	    defaultLineMapper = new DefaultLineMapper<>();
	    defaultLineMapper.setLineTokenizer(lineTokenizer);
	    defaultLineMapper.setFieldSetMapper(fieldSetMapper);

	    flatFileItemReader.setLineMapper(defaultLineMapper);
	}

 //   flatFileItemReader.setLineMapper(defaultLineMapper);


	@Override
	public SbfDTO read() throws Exception {
		
	    return flatFileItemReader.read();
	}
	
}

/*	public FlatFileItemReader<SbfDTO> ReaderSbf() {
	    String filePath = Constantes.SBF_FILE_PATH;
	    String[] columnNames = Constantes.SBF_ColumnNames;

	    flatFileItemReader = new FlatFileItemReader<>();
	    flatFileItemReader.setResource(new FileSystemResource(filePath));
	    flatFileItemReader.setName("SBF-Reader");

	    BeanWrapperFieldSetMapper<SbfDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
	    defaultLineMapper = new DefaultLineMapper<>();
	    DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

	    lineTokenizer.setDelimiter("|");
	    lineTokenizer.setStrict(false);
	    lineTokenizer.setNames(columnNames);

	    fieldSetMapper.setTargetType(SbfDTO.class);

	    defaultLineMapper.setLineTokenizer(lineTokenizer);
	    defaultLineMapper.setFieldSetMapper(fieldSetMapper);

	    flatFileItemReader.setLineMapper(defaultLineMapper);
	    return flatFileItemReader;
	    
	}*/