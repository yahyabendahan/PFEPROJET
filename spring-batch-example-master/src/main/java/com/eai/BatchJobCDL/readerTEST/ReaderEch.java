package com.eai.BatchJobCDL.readerTEST;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;

import com.eai.BatchJobCDL.DTO.EchDTO;
import com.eai.BatchJobCDL.utils.Constantes;

public class ReaderEch extends FlatFileItemReader<EchDTO> {

    private FlatFileItemReader<EchDTO> flatFileItemReader;
    private DefaultLineMapper<EchDTO> LineMapper ;

    public ReaderEch() {
        String filePath = Constantes.ECH_FILE_PATH;
        String[] columnNames = Constantes.ECH_ColumnNames;

        flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new FileSystemResource(filePath));
        flatFileItemReader.setName("ECH-Reader");

        BeanWrapperFieldSetMapper<EchDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        LineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter("|");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(columnNames);

        fieldSetMapper.setTargetType(EchDTO.class);

        LineMapper.setLineTokenizer(lineTokenizer);
        LineMapper.setFieldSetMapper(fieldSetMapper);

        flatFileItemReader.setLineMapper(LineMapper);
        System.out.println("\nValider.itemReaderEch\n");
    }

    @Override
    public EchDTO read() throws Exception {
        return flatFileItemReader.read();
    }
}
