package com.eai.BatchJobCDL.readerTEST;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.eai.BatchJobCDL.DTO.DocDTO;
import com.eai.BatchJobCDL.model.ImpayesCDLModel;
import com.eai.BatchJobCDL.utils.Constantes;

/*
 * 
 * @Value("classpath*:/data/customer*.csv")
	@Bean
	public MultiResourceItemReader<Customer> multiResourceItemreader() {
	
		    String filePath = Constantes.FILE_PATH;

	
	
		MultiResourceItemReader<Customer> reader = new MultiResourceItemReader<>();
		
		
		reader.setDelegate(customerItemReader()); //
		
		reader.setResource(new FileSystemResource(filePath));
		
		return reader;

	}*/


/*
 * @Override
protected ItemReader<Foo> getItemReader() throws Exception {
  MultiResourceItemReader<Foo> multiReader = new MultiResourceItemReader<>();
  FlatFileItemReader<Foo> fileReader = new FlatFileItemReader<>();
  fileReader.setLineMapper(new LineMapper<Foo>() {
    @Override
    public Foo mapLine(String line, int lineNumber) throws Exception {
      Foo foo = new Foo();
      foo.setValue(Integer.valueOf(line));
      return foo;
    }
    
  });
  fileReader.setSaveState(true);
  multiReader.setDelegate(fileReader);
  Resource r1 = new ByteArrayResource("1\n2\n".getBytes());
  Resource r2 = new ByteArrayResource("".getBytes());
  Resource r3 = new ByteArrayResource("3\n".getBytes());
  Resource r4 = new ByteArrayResource("4\n5\n".getBytes());
  multiReader.setResources(new Resource[] { r1, r2, r3, r4 });
  multiReader.setSaveState(true);
  multiReader.setComparator(new Comparator<Resource>() {
    @Override
    public int compare(Resource arg0, Resource arg1) {
      return 0; // preserve original ordering
    }
    
  });
  return multiReader;
}*/


/*
 * @Bean
public MultiResourceItemReader<Person> multiItemReader() {
  ResourcePatternResolver patternResolver =
      new PathMatchingResourcePatternResolver();
  Resource[] resources = null;
  try {
    resources = patternResolver
        .getResources("file:target/test-inputs/*.csv");
  } catch (IOException e) {
    LOGGER.error("error reading files", e);
  }

  return new MultiResourceItemReaderBuilder<Person>()
      .name("multiPersonItemReader").delegate(itemReader())
      .resources(resources).setStrict(true).build();
}
 */
/*
 * @Value("input/inputData*.csv")
private Resource[] inputResources;
 
@Bean
public Job readCSVFilesJob() {
  return jobBuilderFactory
      .get("readCSVFilesJob")
      .incrementer(new RunIdIncrementer())
      .start(step1())
      .build();
}
 
@Bean
public Step step1() {
  return stepBuilderFactory.get("step1").<Employee, Employee>chunk(5)
      .reader(multiResourceItemReader())
      .writer(writer())
      .build();
}
 
@Bean
public MultiResourceItemReader<Employee> multiResourceItemReader() 
{
  MultiResourceItemReader<Employee> resourceItemReader = new MultiResourceItemReader<Employee>();
  resourceItemReader.setResources(inputResources);
  resourceItemReader.setDelegate(reader());
  return resourceItemReader;
}
 
@Bean
public FlatFileItemReader<Employee> reader() 
{
  //Create reader instance
  FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>();
   
  //Set number of lines to skips. Use it if file has header rows.
  reader.setLinesToSkip(1);   
   
  //Configure how each line will be parsed and mapped to different values
  reader.setLineMapper(new DefaultLineMapper() {
    {
      //3 columns in each row
      setLineTokenizer(new DelimitedLineTokenizer() {
        {
          setNames(new String[] { "id", "firstName", "lastName" });
        }
      });
      //Set values in Employee class
      setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {
        {
          setTargetType(Employee.class);
        }
      });
    }
  });
  return reader;
}
*/

/*
 * 
  @Bean
  public FlatFileItemReader<User> reader() {
    FlatFileItemReader<User> reader = new FlatFileItemReader<User>();
    reader.setLineMapper(new DefaultLineMapper<User>() {{
      setLineTokenizer(new DelimitedLineTokenizer() {{
        setNames(new String[]{"name", "gender"});
      }});
      setFieldSetMapper(new BeanWrapperFieldSetMapper<User>() {{
        setTargetType(User.class);
      }});
​
    }});
​
    return reader;
  }
​
  @Bean
  public MultiResourceItemReader<User> multiResourceItemReader() {
    MultiResourceItemReader<User> resourceItemReader = new MultiResourceItemReader<User>();
    resourceItemReader.setResources(inputResources);
    resourceItemReader.setDelegate(reader());
    return resourceItemReader;
  }*/

public class ReaderDto extends MultiResourceItemReader<DocDTO> {
	//DOC
	//ll
	private FlatFileItemReader<DocDTO> flatFileItemReader;

	public ReaderDoc() {
	    String filePath = Constantes.FILE_PATH;
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

	
}
	
