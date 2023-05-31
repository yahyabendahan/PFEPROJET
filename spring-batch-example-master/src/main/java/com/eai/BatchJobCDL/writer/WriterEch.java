package com.eai.BatchJobCDL.writer;

import javax.sql.DataSource;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.eai.BatchJobCDL.model.ImpayesCDLModel;

@Component
public class WriterEch extends JdbcBatchItemWriter<ImpayesCDLModel> {
    
	
	
    @Autowired
    public WriterEch(DataSource dataSource) {

        this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        String deleteSql = "DELETE FROM IMPAYES_CDL";
        new JdbcTemplate(dataSource).update(deleteSql);
        System.out.println("WriterEch: ");

        System.out.println("delete TABLE IMPAYES_CDL ");
        this.setSql("INSERT INTO IMPAYES_CDL (NATENG, TYPE, CPT, MONTANT_CREANCE, DATE_CREANCE, NO_DOSSIER, DATE_ECHEANCE, DATE_MISE_IMPAYE, DATE_REGLEMENT, MONTANT_AMORTISSEMENT, MONTANT_INTERET_NORMAL, TVA_INTERET, MONTANT_INTERET_RETARD, TVA_INTERET_RETARD, MONATANT_PENALITE_RETARD, TVA_PENALITE_RETARD, NUM_COMPTE_PAYEUR, CODE_CATEGORIE, NUM_DOSSIER_COMPLET, NUMERO_LIGNE, NUMERO_TIRAGE) " +
                "VALUES (:nateng, :type, :cpt, :montantCreance, :dateCreance, :noDossier, :dateEcheance, :dateMiseImpaye, :dateReglement, :montantAmortissement, :montantInteretNormal, :tvaInteret, :montantInteretRetard, :tvaInteretRetard, :montantPenaliteRetard, :tvaPenaliteRetard, :numComptePayeur, :codeCategorie, :numDossierComplet, :numeroLigne, :numeroTirage)");
        this.setDataSource(dataSource);

    }
    
}