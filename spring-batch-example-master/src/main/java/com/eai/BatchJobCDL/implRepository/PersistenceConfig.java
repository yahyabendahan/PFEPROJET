package com.eai.BatchJobCDL.implRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.context.annotation.Configuration;



@Configuration
@EnableJpaRepositories(basePackages = "com.eai.BatchJobCDL.repository"+"com.eai.BatchJobCDL.model")
public class PersistenceConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPersistenceUnitName("your-persistence-unit-name");
        emf.setPackagesToScan("com.eai.BatchJobCDL.model"); // Package(s) containing your entity classes
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return emf;
    }
}
