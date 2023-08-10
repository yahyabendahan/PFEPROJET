package com.eai.BatchJobCDL.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STATUT_CREANCE_HIST")
public class Statut_Creance_HistModel {

	

	@Id
	@SequenceGenerator(name = "statutcreanceSeqGen", sequenceName = "SEQ_HIST_CREANCE", initialValue = 0, allocationSize = 17599000)
	@GeneratedValue(generator = "statutcreanceSeqGen",strategy=GenerationType.SEQUENCE)
	@Column(name = "CODE")
	private BigDecimal code;
	//It is possible that the database is expecting a different data type for the "CODE" column. 
	//checked 	
	
	//You could also check if the sequence generator is set up correctly and if the sequence exists in the database.
	//checked
	
	@Column(name = "CODE_NAT_DECL")
	private String codeNatDecl ;

	@Column(name = "CODE_CREANCE")
	private BigDecimal codeCreance ;

	@Column(name = "CODE_DEC")
	private String codeDec ;

	@Column(name = "DATE_CREATION")
	private Date dateCreation ;

	@Column(name = "USER_CREATION")
	private String userCreaction ;

	@Column(name = "DATE_COMITE")
	private Date dateComite ;

	public BigDecimal getCode() {
		return code;
	}

	public void setCode(BigDecimal code) {
		this.code = code;
	}

	public String getCodeNatDecl() {
		return codeNatDecl;
	}

	public void setCodeNatDecl(String codeNatDecl) {
		this.codeNatDecl = codeNatDecl;
	}

	public BigDecimal getCodeCreance() {
		return codeCreance;
	}

	public void setCodeCreance(BigDecimal codeCreance) {
		this.codeCreance = codeCreance;
	}

	public String getCodeDec() {
		return codeDec;
	}

	public void setCodeDec(String codeDec) {
		this.codeDec = codeDec;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getUserCreaction() {
		return userCreaction;
	}

	public void setUserCreaction(String userCreaction) {
		this.userCreaction = userCreaction;
	}

	public Date getDateComite() {
		return dateComite;
	}

	public void setDateComite(Date dateComite) {
		this.dateComite = dateComite;
	}
	
}
