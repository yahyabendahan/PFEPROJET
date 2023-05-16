package com.eai.BatchJobCDL.utils;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Configuration
public class ValidVal {
	
    private final JdbcTemplate jdbcTemplate;
    
    
    private static List<String> VALID_VALUES = new ArrayList<>();

    public ValidVal(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    public void init() {
        String sql = "SELECT LIBELLE_COURT FROM TYPE_DOSSIER";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        
        for (Map<String, Object> row : rows) {
            VALID_VALUES.add((String) row.get("LIBELLE_COURT"));
        }
        
    }
    @Bean
    public static List<String> getLibelleCourt() {
        return VALID_VALUES;
        
    }
}
