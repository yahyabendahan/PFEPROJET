package com.eai.BatchJobCDL.repository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eai.BatchJobCDL.model.TypeDossierModel;


@Repository
public interface TypeDossierRepository extends JpaRepository<TypeDossierModel, String> {

    public static final Logger log = LoggerFactory.getLogger(TypeDossierRepository.class);
    @Transactional
    @Primary
    @Query("SELECT t FROM TypeDossierModel t WHERE t.LIBELLE_COURT = :libelleCourt")
    TypeDossierModel findAllByLibelleCourt(@Param("libelleCourt") String libelleCourt);

	
    // Other methods...	
	@Query("SELECT t FROM TypeDossierModel t")
	TypeDossierModel findAllByCODE(String CODE);
	
	
	
	
	@Transactional
	// Logging example for findOneByLibelleCourt
    //@Query("SELECT t FROM TypeDossierModel t WHERE t.LIBELLE_COURT = :libelleCourt")
    default TypeDossierModel findAllByLibelleCourtWithLogging(@Param("libelleCourt") String libelleCourt) {
        TypeDossierModel result = findAllByLibelleCourt(libelleCourt);
        if (result != null) {
            log.info("Data is available in the database for LIBELLE_COURT: {}", libelleCourt);
        } else {
            log.info(" data is not available in the database for LIBELLE_COURT: {}", libelleCourt);
        }
        return result;
    }

	
}

