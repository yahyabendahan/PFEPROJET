package com.eai.BatchJobCDL.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;

import com.eai.BatchJobCDL.DTO.DocDTO;
import com.eai.BatchJobCDL.utils.Constantes;

public class ReaderDoc extends FlatFileItemReader<DocDTO> {
	//DOC
	
	private FlatFileItemReader<DocDTO> flatFileItemReader;

	public ReaderDoc() {
	    String filePath = Constantes.DOC_FILE_PATH;
	    String[] columnNames = Constantes.DOC_ColumnNames;

	    flatFileItemReader = new FlatFileItemReader<>();
	    flatFileItemReader.setResource(new FileSystemResource(filePath));
	    flatFileItemReader.setName("DOC-Reader");

	    BeanWrapperFieldSetMapper<DocDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
	    DefaultLineMapper<DocDTO> defaultLineMapper = new DefaultLineMapper<>();
	    DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

	    lineTokenizer.setDelimiter("|");
	    lineTokenizer.setStrict(false);
	    lineTokenizer.setNames(columnNames);

	    fieldSetMapper.setTargetType(DocDTO.class);

	    defaultLineMapper.setLineTokenizer(lineTokenizer);
	    defaultLineMapper.setFieldSetMapper(fieldSetMapper);

	    flatFileItemReader.setLineMapper(defaultLineMapper);
	    System.out.println("\nValider.itemReaderDoc\n");
	}

	@Override
	public DocDTO read() throws Exception {
	    return flatFileItemReader.read();
	}

	
}
