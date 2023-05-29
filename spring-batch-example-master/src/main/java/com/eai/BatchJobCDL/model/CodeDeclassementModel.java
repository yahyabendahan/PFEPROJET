package com.eai.BatchJobCDL.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CODE_DECLASSEMENT")
public class CodeDeclassementModel {

	@Id
	@Column(name = "CODE")
	private String CODE;
	
	@Column(name = "LIBELLE_COURT")
	private String LIBELLE_COURT;
	
	@Column(name = "LIBELLE_LONG")
	private String LIBELLE_LONG;
	
	@Column(name="NUMERO_ORDRE")
	private Double NUMERO_ORDRE;

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String cODE) {
		CODE = cODE;
	}

	public String getLIBELLE_COURT() {
		return LIBELLE_COURT;
	}

	public void setLIBELLE_COURT(String lIBELLE_COURT) {
		LIBELLE_COURT = lIBELLE_COURT;
	}

	public String getLIBELLE_LONG() {
		return LIBELLE_LONG;
	}

	public void setLIBELLE_LONG(String lIBELLE_LONG) {
		LIBELLE_LONG = lIBELLE_LONG;
	}

	public Double getNUMERO_ORDRE() {
		return NUMERO_ORDRE;
	}

	public void setNUMERO_ORDRE(Double nUMERO_ORDRE) {
		NUMERO_ORDRE = nUMERO_ORDRE;
	}

	
}
