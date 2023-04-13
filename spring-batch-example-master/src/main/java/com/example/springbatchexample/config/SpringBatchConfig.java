package com.example.springbatchexample.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.springbatchexample.DOC.DocDTO;
import com.example.springbatchexample.DOC.ProcessorDoc;
import com.example.springbatchexample.DOC.WriterDoc;
import com.example.springbatchexample.ECH.EchDTO;
import com.example.springbatchexample.ECH.ProcessorEch;
import com.example.springbatchexample.ECH.WriterEch;
import com.example.springbatchexample.EFA.EfaDTO;
import com.example.springbatchexample.EFA.ProcessorEfa;
import com.example.springbatchexample.EFA.WriterEfa;
import com.example.springbatchexample.ESC.EscDTO;
import com.example.springbatchexample.ESC.ProcessorEsc;
import com.example.springbatchexample.ESC.WriterEsc;
import com.example.springbatchexample.MCN.McnDTO;
import com.example.springbatchexample.MCN.ProcessorMcn;
import com.example.springbatchexample.MCN.WriterMcn;
import com.example.springbatchexample.SBF.ProcessorSbf;
import com.example.springbatchexample.SBF.SbfDTO;
import com.example.springbatchexample.SBF.WriterSbf;
import com.example.springbatchexample.constantes.Constantes;
import com.example.springbatchexample.model.ImpayesCDLModel;

@Configuration
@EnableBatchProcessing
@EntityScan
@EnableJpaRepositories(basePackages = "com.example.springbatchexample.repository"+"com.example.springbatchexample.model")

public class SpringBatchConfig {
	//Datasource
	@Bean
	public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	    dataSource.setUsername("CDL");
	    dataSource.setPassword("0000");
	    return dataSource;
	}

	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory,
			StepBuilderFactory stepBuilderFactory) {

		
		Step step = stepBuilderFactory
				.get("Ech-STEP")
				.<EchDTO, ImpayesCDLModel>chunk(10)
				.reader(itemReaderEch())
				.processor(itemProcessorEch())
				.writer(writerEch())
				.build();

		Step step2 = stepBuilderFactory
				.get("Sbf-STEP")
				.<SbfDTO, ImpayesCDLModel>chunk(10)
				.reader(itemReaderSbf())
				.processor(itemProcessorSbf())
				.writer(writerSbf())
				.build();
		
		Step step3 = stepBuilderFactory
				.get("Esc-STEP")
				.<EscDTO, ImpayesCDLModel>chunk(10)
				.reader(itemReaderEsc())
				.processor(itemProcessorEsc())
				.writer(writerEsc())
				.build();

		Step step4 = stepBuilderFactory
				.get("Mcn-STEP")
				.<McnDTO, ImpayesCDLModel>chunk(10)
				.reader(itemReaderMcn())
				.processor(itemProcessorMcn())
				.writer(writerMcn())
				.build();
			
		Step step5 = stepBuilderFactory
				.get("Doc-STEP")
				.<DocDTO, ImpayesCDLModel>chunk(10)
				.reader(itemReaderDoc())
				.processor(itemProcessorDoc())
				.writer(writerDoc())
				.build();
		
		Step step6 = stepBuilderFactory
				.get("Efa-STEP")
				.<EfaDTO, ImpayesCDLModel>chunk(10)
				.reader(itemReaderEfa())
				.processor(itemProcessorEfa())
				.writer(writerEfa())
				.build();
		


		Job job = jobBuilderFactory
				.get("CDL-JOB")
				.incrementer(new RunIdIncrementer())
				.start(step)
				.next(step2)
				.next(step3)
				.next(step4)
				.next(step5)
				.next(step6)
				.build();

		return job;
	}


	
	//ECH
	@Bean("EchWriter")
	public WriterEch writerEch() {
		return new WriterEch(dataSource());
	}
	@Bean("EchProcess")
	public ProcessorEch itemProcessorEch() {
		return new ProcessorEch();
	}
	
	//SBF
	@Bean("SbfWriter")
	public WriterSbf writerSbf() {
		return new WriterSbf(dataSource());
	}
	@Bean("SbfProcess")
	public ProcessorSbf itemProcessorSbf() {
		return new ProcessorSbf();
	}
	
	//ESC
	@Bean("EscWriter")
	public WriterEsc writerEsc() {
		return new WriterEsc(dataSource());
	}
	@Bean("EscProcessor")
	public ProcessorEsc itemProcessorEsc() {
		return new ProcessorEsc();
	}
	
	//MCN
	@Bean("McnWriter")
	public WriterMcn writerMcn() {
		return new WriterMcn(dataSource());
	}
	@Bean("McnProcessor")
	public ProcessorMcn itemProcessorMcn() {
		return new ProcessorMcn();
	}
	
	//DOC
	@Bean("DocWriter")
	public WriterDoc writerDoc() {
		return new WriterDoc(dataSource());
	}
	@Bean("DocProcessor")
	public ProcessorDoc itemProcessorDoc() {
		return new ProcessorDoc();
	}
	
	//EFA
	@Bean("EfaWriter")
	public WriterEfa writerEfa() {
		return new WriterEfa(dataSource());
	}
	@Bean("EfaProcessor")
	public ProcessorEfa itemProcessorEfa() {
		return new ProcessorEfa();
	}
	
	
	//ItemReader
	@Bean
	public ItemReader<ImpayesCDLModel> itemReaderTC(DataSource dataSource) {
	    JdbcCursorItemReader<ImpayesCDLModel> reader = new JdbcCursorItemReader<>();
	    reader.setDataSource(dataSource);
	    reader.setSql("SELECT CPT FROM IMPAYES_CDL");
	    reader.setRowMapper(new BeanPropertyRowMapper<>(ImpayesCDLModel.class));
	    return reader;
	}
	//ECH
	@Bean
    public FlatFileItemReader<EchDTO> itemReaderEch() {
    	String filePath = Constantes.ECH_FILE_PATH;
        FlatFileItemReader<EchDTO> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new FileSystemResource(filePath));
        flatFileItemReader.setName("ECH-Reader");
        flatFileItemReader.setLineMapper(lineMapperEch());
        System.out.println("\nValider.itemReaderEch\n");
        return flatFileItemReader;
    }
	  @Bean
	    public LineMapper<EchDTO> lineMapperEch() {

	    	String[] columnNames = Constantes.ECH_ColumnNames;
	        DefaultLineMapper<EchDTO> defaultLineMapper = new DefaultLineMapper<>();
	        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

	        lineTokenizer.setDelimiter("|");
	        lineTokenizer.setStrict(false);
	        lineTokenizer.setNames(columnNames);

	        BeanWrapperFieldSetMapper<EchDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
	        fieldSetMapper.setTargetType(EchDTO.class);

	        defaultLineMapper.setLineTokenizer(lineTokenizer);
	        defaultLineMapper.setFieldSetMapper(fieldSetMapper);
	        return defaultLineMapper;
	    }
	
	//SBF
	@Bean
    public FlatFileItemReader<SbfDTO> itemReaderSbf() {
    	String filePath = Constantes.SBF_FILE_PATH;
        FlatFileItemReader<SbfDTO> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new FileSystemResource(filePath));
        flatFileItemReader.setName("SBF-Reader");
        flatFileItemReader.setLineMapper(lineMapperSbf());
        System.out.println("\nValider.itemReaderSbf\n");
        return flatFileItemReader;
    }
	@Bean
    public LineMapper<SbfDTO> lineMapperSbf() {

    	String[] columnNames = Constantes.SBF_ColumnNames;
        DefaultLineMapper<SbfDTO> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter("|");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(columnNames);
        

        BeanWrapperFieldSetMapper<SbfDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(SbfDTO.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);
        return defaultLineMapper;
    }
	
	//ESC
	@Bean
    public FlatFileItemReader<EscDTO> itemReaderEsc() {
    	String filePath = Constantes.ESC_FILE_PATH;
        FlatFileItemReader<EscDTO> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new FileSystemResource(filePath));
        flatFileItemReader.setName("ESC-Reader");
        flatFileItemReader.setLineMapper(lineMapperEsc());
        System.out.println("\nValider.itemReaderEsc\n");
        return flatFileItemReader;
    }
	@Bean
	public LineMapper<EscDTO> lineMapperEsc() {
	
		String[] columnNames = Constantes.ESC_ColumnNames;
	    DefaultLineMapper<EscDTO> defaultLineMapper = new DefaultLineMapper<>();
	    DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
	
	    lineTokenizer.setDelimiter("|");
	    lineTokenizer.setStrict(false);
	    lineTokenizer.setNames(columnNames);
	
	    BeanWrapperFieldSetMapper<EscDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
	    fieldSetMapper.setTargetType(EscDTO.class);
	
	    defaultLineMapper.setLineTokenizer(lineTokenizer);
	    defaultLineMapper.setFieldSetMapper(fieldSetMapper);
	    return defaultLineMapper;
	}
	
	//MCN
	@Bean
    public FlatFileItemReader<McnDTO> itemReaderMcn() {
    	String filePath = Constantes.MCN_FILE_PATH;
        FlatFileItemReader<McnDTO> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new FileSystemResource(filePath));
        flatFileItemReader.setName("MCN-Reader");
        flatFileItemReader.setLineMapper(lineMapperMcn());
        System.out.println("\nValider.itemReaderMcn\n");
        return flatFileItemReader;
    }
	@Bean
	public LineMapper<McnDTO> lineMapperMcn() {
	
		String[] columnNames = Constantes.MCN_ColumnNames;
	    DefaultLineMapper<McnDTO> defaultLineMapper = new DefaultLineMapper<>();
	    DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
	
	    lineTokenizer.setDelimiter("|");
	    lineTokenizer.setStrict(false);
	    lineTokenizer.setNames(columnNames);
	
	    BeanWrapperFieldSetMapper<McnDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
	    fieldSetMapper.setTargetType(McnDTO.class);
	
	    defaultLineMapper.setLineTokenizer(lineTokenizer);
	    defaultLineMapper.setFieldSetMapper(fieldSetMapper);
	    return defaultLineMapper;
	    
	}
	
	//DOC
	@Bean
    public FlatFileItemReader<DocDTO> itemReaderDoc() {
    	String filePath = Constantes.DOC_FILE_PATH;
        FlatFileItemReader<DocDTO> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new FileSystemResource(filePath));
        flatFileItemReader.setName("DOC-Reader");
        flatFileItemReader.setLineMapper(lineMapperDoc());
        System.out.println("\nValider.itemReaderDoc\n");
        return flatFileItemReader;
    }
	@Bean
	public LineMapper<DocDTO> lineMapperDoc() {
	
		String[] columnNames = Constantes.DOC_ColumnNames;
	    DefaultLineMapper<DocDTO> defaultLineMapper = new DefaultLineMapper<>();
	    DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
	
	    lineTokenizer.setDelimiter("|");
	    lineTokenizer.setStrict(false);
	    lineTokenizer.setNames(columnNames);
	
	    BeanWrapperFieldSetMapper<DocDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
	    fieldSetMapper.setTargetType(DocDTO.class);
	
	    defaultLineMapper.setLineTokenizer(lineTokenizer);
	    defaultLineMapper.setFieldSetMapper(fieldSetMapper);
	    return defaultLineMapper;
	    
	}
	
	//EFA
	@Bean
    public FlatFileItemReader<EfaDTO> itemReaderEfa() {
    	String filePath = Constantes.EFA_FILE_PATH;
        FlatFileItemReader<EfaDTO> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new FileSystemResource(filePath));
        flatFileItemReader.setName("EFA-Reader");
        flatFileItemReader.setLineMapper(lineMapperEfa());
        System.out.println("\nValider.itemReaderEfa\n");
        return flatFileItemReader;
    }
	@Bean
	public LineMapper<EfaDTO> lineMapperEfa() {
	
		String[] columnNames = Constantes.EFA_ColumnNames;
	    DefaultLineMapper<EfaDTO> defaultLineMapper = new DefaultLineMapper<>();
	    DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
	
	    lineTokenizer.setDelimiter("|");
	    lineTokenizer.setStrict(false);
	    lineTokenizer.setNames(columnNames);
	
	    BeanWrapperFieldSetMapper<EfaDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
	    fieldSetMapper.setTargetType(EfaDTO.class);
	
	    defaultLineMapper.setLineTokenizer(lineTokenizer);
	    defaultLineMapper.setFieldSetMapper(fieldSetMapper);
	    return defaultLineMapper;
	    
	}
}
