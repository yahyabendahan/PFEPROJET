package com.eai.BatchJobCDL.config;

import javax.sql.DataSource;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.eai.BatchJobCDL.DTO.*;
import com.eai.BatchJobCDL.model.*;
import com.eai.BatchJobCDL.processor.*;
//import com.eai.BatchJobCDL.repository.ImpayesCDLRejetRepository;
//import com.eai.BatchJobCDL.repository.NatEngRepository;
//import com.eai.BatchJobCDL.repository.TypeDossierRepository;
import com.eai.BatchJobCDL.writer.*;
import com.eai.BatchJobCDL.utils.*;

@Configuration
@EnableBatchProcessing
@EntityScan
@EnableJpaRepositories(basePackages = "com.eai.BatchJobCDL.model"+"com.eai.BatchJobCDL.utils")
public class BatchGlobal {
	
	//cdl:Créance Douteuse Légale
	
	@Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;
   
	 @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	        dataSource.setUrl(url);
	        dataSource.setUsername(username);
	        dataSource.setPassword(password);
	        return dataSource;
	    }
	
	  
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory,
			StepBuilderFactory stepBuilderFactory) throws Exception {

		Step step1 = stepBuilderFactory
				.get("Ech-STEP")
				.<EchDTO, ImpayesCDLModel>chunk(10)
				.reader(itemReaderEch())
				.processor(itemProcessorEch())
				.writer(writerEch())
				.build();

//**********
		Step step2 = stepBuilderFactory
				.get("Sbf-STEP")
				.<SbfDTO, ImpayesCDLModel>chunk(10)
				.reader(itemReaderSbf())
				.processor(itemProcessorSbf())
				.writer(writerSbf())
				.build();

//**********
		Step step3 = stepBuilderFactory
				.get("ESC-STEP")
				.<EscDTO, ImpayesCDLModel>chunk(10)
				.reader(itemReaderEsc())
				.processor(itemProcessorEsc())
				.writer(writerEsc())
				.build();

 //**********
		Step step4 = stepBuilderFactory
				.get("Mcn-STEP")
				.<McnDTO, ImpayesCDLModel>chunk(10)
				.reader(itemReaderMcn())
				.processor(itemProcessorMcn())
				.writer(writerMcn())
				.build();

 //*********
		Step step5 = stepBuilderFactory
				.get("Doc-STEP")
				.<DocDTO, ImpayesCDLModel>chunk(10)
				.reader(itemReaderDoc())
				.processor(itemProcessorDoc())
				.writer(writerDoc())
				.build();

 //*********
		Step step6 = stepBuilderFactory
				.get("Efa-STEP")
				.<EfaDTO, ImpayesCDLModel>chunk(10)
				.reader(itemReaderEfa())
				.processor(itemProcessorEfa())
				.writer(writerEfa())
				.build();

 //*********
//*******

		Job job = jobBuilderFactory
				.get("CDL-JOB")
				.incrementer(new RunIdIncrementer())
				.start(step1)
				.next(step2)
				.next(step3)
				.next(step4)
				.next(step5)
				.next(step6)
				.build();

		return job;
	}

	@Bean
	public Job job2(JobBuilderFactory jobBuilderFactory,
			StepBuilderFactory stepBuilderFactory) throws Exception {
		Step step1 = stepBuilderFactory
				.get("compte")
				.<ImpayesCDLModel,CompteModel>chunk(10)
			    .reader(itemReaderVide())
				.processor(itemProcessorTC())
				.writer(writerTCompte())
				.build();
		
		Step step2 = stepBuilderFactory
				.get("dossier")
				.<ImpayesCDLModel, DossierModel>chunk(10)
			    .reader(itemReaderVide())
				.processor(itemProcessorTD())
				.writer(writerTDossier())
				.build();
	
				
		Step step3 = stepBuilderFactory
				.get("Creance") 
				.<ImpayesCDLModel, CreanceModel>chunk(10)
			    .reader(itemReaderVide())
				.processor(processorCreance())
				.writer(writerCreance())
				.build();
		
		//
		Step step4 = stepBuilderFactory
				.get("cleDossierCreance") //Cle_Doss_Cr_CptModel
				.<CreanceModel, Cle_Doss_Cr_CptModel>chunk(10)
			    .reader(itemReadercreance())
				.processor(processorCleDossCrCpt())
				.writer(writerCleDossCrCpt())
				.build();
		Step step5 = stepBuilderFactory
				.get("Statut_Creance_Hist") //Statut_Creance_Hist
				.<CreanceModel, Statut_Creance_HistModel>chunk(10)
			    .reader(itemReadercreance())
				.processor(processorStatutCreance())
				.writer(writerStatutCreance())
				.build();
	

		Job job = jobBuilderFactory
				.get("CDL-JOB")
				.incrementer(new RunIdIncrementer())
				.start(step1)
				.next(step2)
				.next(step3)
				.next(step4)
				.next(step5)
				.build();

		return job;
	}
	

	
	//SBF
	
	@Bean(name="ProcessorSbf")
	public ProcessorSbf itemProcessorSbf() {
		return new ProcessorSbf();
	}
	@Bean(name="WriterSbf")
	public WriterSbf writerSbf() {
		return new WriterSbf(dataSource()); 
	}

	
	//ESC
	
	@Bean(name="ProcessorEsc")
	public ProcessorEsc itemProcessorEsc() {
		return new ProcessorEsc();
	}
	@Bean(name="WriterEsc")
	public WriterEsc writerEsc() {
		return new WriterEsc(dataSource()); 
	}
	
	
	//ECH

	@Bean(name="ProcessorEch")
	public ProcessorEch itemProcessorEch() {
		return new ProcessorEch();
	}
	@Bean(name="WriterEch")
	public WriterEch writerEch() {
		return new WriterEch(dataSource()); 
	}
	
	//MCN

	@Bean(name="ProcessorMcn")
	public ProcessorMcn itemProcessorMcn() {
		return new ProcessorMcn();
	}
	@Bean(name="WriterMcn")
	public WriterMcn writerMcn() {
		return new WriterMcn(dataSource()); 
	}
	
	//DOC

	@Bean(name="ProcessorDoc")
	public ProcessorDoc itemProcessorDoc() {
		return new ProcessorDoc();
	}
	@Bean(name="WriterDoc")
	public WriterDoc writerDoc() {
		return new WriterDoc(dataSource()); 
	}

	
	//EFA

	@Bean(name="ProcessorEfa")
	public ProcessorEfa itemProcessorEfa() {
		return new ProcessorEfa();
	}
	@Bean(name="WriterEfa")
	public WriterEfa writerEfa() {
		return new WriterEfa(dataSource()); 
	}
	
	//Processor vide
	@Bean(name="ProcessecorRejet")
	public ProcessecorRejet processorRejet() {
		return new ProcessecorRejet();
	}



	//************************************************
		@Bean(name="writecompte")
		public WriterTCompte writerTCompte() {
			return new WriterTCompte(dataSource()); 
		}
		@Bean(name="ProcessorTCompte")
		public ProcessorTCompte itemProcessorTC() {
			return new ProcessorTCompte();
		}
	//**************************************
	
		@Bean(name="writedossieR")
		public WriterTDossier writerTDossier() {
			return new WriterTDossier(dataSource());
		}
		@Bean(name="ProcessorTDossier")
		public ProcessorTDossier itemProcessorTD() {
			return new ProcessorTDossier();
		}

		
		//************************************************
		//Creance Creance
		@Bean(name="processorCreance")
		public ProcessorTCreance processorCreance() {
			return new ProcessorTCreance();
		}
		@Bean(name="writerCreance")
		public WriterTCreance writerCreance() {
			return new WriterTCreance(dataSource());
		}
		
		//********************************************

		//Cle_Doss_Cr_CptModel
		@Bean(name="processorcledosscrcpt")
		public ProcessorCleDossCrCpt processorCleDossCrCpt() {
			return new ProcessorCleDossCrCpt();
		}
		@Bean(name="writercledosscrcpt")
		public WriterCleDossCrCpt writerCleDossCrCpt() {
			return new WriterCleDossCrCpt(dataSource());
		}
		
		//Statut_Creance_HistModel
				
		@Bean(name="processorhistCreance")
		public ProcessorStatutCreance processorStatutCreance() {
			return new ProcessorStatutCreance();
		}
		@Bean(name="writerhistCreance")
		public WriterStatutCreance writerStatutCreance() {
			return new WriterStatutCreance(dataSource());
		}
		
		
	
		
		//ItemReader
		@Bean
		public JdbcCursorItemReader<ImpayesCDLModel> itemReaderVide() {
		    JdbcCursorItemReader<ImpayesCDLModel> reader = new JdbcCursorItemReader<>();
		    reader.setDataSource(dataSource());
		    reader.setName("ItemReaderJustForShow");
		    reader.setSql("SELECT * FROM IMPAYES_CDL");
		    reader.setRowMapper(new BeanPropertyRowMapper<>(ImpayesCDLModel.class));
		     return reader;
		}
	
		//Readercreance
				@Bean
				public JdbcCursorItemReader<CreanceModel> itemReadercreance() {
				    JdbcCursorItemReader<CreanceModel> reader = new JdbcCursorItemReader<>();
				    reader.setDataSource(dataSource());
				    reader.setName("ItemReaderJustForShow");
				    reader.setSql("SELECT * FROM CREANCE");
				    reader.setRowMapper(new BeanPropertyRowMapper<>(CreanceModel.class));
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
