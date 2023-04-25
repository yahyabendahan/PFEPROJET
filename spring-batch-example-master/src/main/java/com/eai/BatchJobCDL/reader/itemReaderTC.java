package com.eai.BatchJobCDL.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.eai.BatchJobCDL.model.ImpayesCDLModel;


public class itemReaderTC extends JdbcCursorItemReader<ImpayesCDLModel> {
	
		public  itemReaderTC(DataSource dataSource) {
	    JdbcCursorItemReader<ImpayesCDLModel> reader = new JdbcCursorItemReader<>();
	    reader.setDataSource(dataSource);
	    reader.setName("ItemReaderJustForShow");
	    reader.setSql("SELECT * FROM IMPAYES_CDL");
	    reader.setRowMapper(new BeanPropertyRowMapper<>(ImpayesCDLModel.class));
	}
		
}
	
