package com.example.springbatchexample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.eai.BatchJobCDL.SpringBatchExampleApplication;

@SpringBootTest(classes = SpringBatchExampleApplication.class)
@ComponentScan(basePackages = "com.eai.BatchJobCDL")
public class SpringBatchExampleApplicationTests {

	@Test
	void contextLoads() {
	}

}
