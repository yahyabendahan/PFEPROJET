package com.eai.BatchJobCDL.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STATUT_CREANCE_HIST")
public class Statut_Creance_HistModel {

	

	@Id
	@SequenceGenerator(name = "statutcreanceSeqGen", sequenceName = "SEQ_HIST_CREANCE", initialValue = 0, allocationSize = 999999999)
	@GeneratedValue(generator = "statutcreanceSeqGen")
	@Column(name = "CODE")
	private Double code;
	//It is possible that the database is expecting a different data type for the "CODE" column. 
	//checked 
	
	//You could also check if the sequence generator is set up correctly and if the sequence exists in the database.
	//checked
	
	@Column(name = "CODE_NAT_DECL")
	private String codeNatDecl ;

	@Column(name = "CODE_CREANCE")
	private Double codeCreance ;

	@Column(name = "CODE_DEC")
	private String codeDec ;

	@Column(name = "DATE_CREATION")
	private Date dateCreation ;

	@Column(name = "USER_CREATION")
	private String userCreaction ;

	@Column(name = "DATE_COMITE")
	private Date dateComite ;

	public Double getCode() {
		return code;
	}

	public void setCode(Double code) {
		this.code = code;
	}

	public String getCodeNatDecl() {
		return codeNatDecl;
	}

	public void setCodeNatDecl(String codeNatDecl) {
		this.codeNatDecl = codeNatDecl;
	}

	public Double getCodeCreance() {
		return codeCreance;
	}

	public void setCodeCreance(Double codeCreance) {
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
