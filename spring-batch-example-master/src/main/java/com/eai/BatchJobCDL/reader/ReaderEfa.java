package com.eai.BatchJobCDL.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;

import com.eai.BatchJobCDL.DTO.EfaDTO;
import com.eai.BatchJobCDL.utils.Constantes;

public class ReaderEfa extends FlatFileItemReader<EfaDTO> {

    private FlatFileItemReader<EfaDTO> flatFileItemReader;

    public ReaderEfa() {
        String filePath = Constantes.EFA_FILE_PATH;
        String[] columnNames = Constantes.EFA_ColumnNames;

        flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new FileSystemResource(filePath));
        flatFileItemReader.setName("EFA-Reader");

        BeanWrapperFieldSetMapper<EfaDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        DefaultLineMapper<EfaDTO> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter("|");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(columnNames);

        fieldSetMapper.setTargetType(EfaDTO.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        flatFileItemReader.setLineMapper(defaultLineMapper);
        System.out.println("\nValider.itemReaderEfa\n");
    }

    @Override
    public EfaDTO read() throws Exception {
        return flatFileItemReader.read();
    }
}
