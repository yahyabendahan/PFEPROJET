package com.eai.BatchJobCDL.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "DOSSIER")
public class DossierModel {
	

	@Id
	@SequenceGenerator(name = "dossierSeqGen", sequenceName = "SEQ_DOSSIER", initialValue = 1, allocationSize = 10377915)
	@GeneratedValue(generator = "dossierSeqGen",strategy=GenerationType.SEQUENCE)
	@Column(name = "CODE")
	private BigDecimal CODE;
	
	@Column(name="NUMERO_DOSSIER")
	private String NUMERO_DOSSIER;
	
	@Column(name="ENCOURS")
	private BigDecimal ENCOURS;
	
	/*@ManyToOne
    @JoinColumn(name ="CODE_COMPTE")
	private CompteModel CODE_COMPTE;	*/

	@Column(name="CODE_COMPTE")
	private BigDecimal  CODE_COMPTE;
	
	@Column(name="TYPE_DOSSIER")
	private String TYPE_DOSSIER;
	
	@Column(name="CLE_DOSSIER")
	private String CLE_DOSSIER;
	
	@Column(name="NUM_DOSSIER_COMPLET")
	private String NUM_DOSSIER_COMPLET;
	
	@Column(name="NUMERO_LIGNE")
	private String NUMERO_LIGNE;
	
	@Column(name="NUMERO_TIRAGE")
	private String NUMERO_TIRAGE;
	
	@Column(name="ANCIEN_NUMERO_DOSSIER")
	private String ANCIEN_NUMERO_DOSSIER;
	
	
	
	public BigDecimal getCODE() {
		return CODE;
	}
	public void setCODE(BigDecimal cODE) {
		CODE = cODE;
	}
	public String getNUMERO_DOSSIER() {
		return NUMERO_DOSSIER;
	}
	public void setNUMERO_DOSSIER(String nUMERO_DOSSIER) {
		NUMERO_DOSSIER = nUMERO_DOSSIER;
	}
	public BigDecimal getENCOURS() {
		return ENCOURS;
	}
	public void setENCOURS(BigDecimal eNCOURS) {
		ENCOURS = eNCOURS;
	}
	public BigDecimal getCODE_COMPTE() {
		return CODE_COMPTE;
	}
	public void setCODE_COMPTE(BigDecimal cODE_COMPTE) {
		CODE_COMPTE = cODE_COMPTE;
	}
	public String getTYPE_DOSSIER() {
		return TYPE_DOSSIER;
	}
	public void setTYPE_DOSSIER(String tYPE_DOSSIER) {
		TYPE_DOSSIER = tYPE_DOSSIER;
	}
	public String getCLE_DOSSIER() {
		return CLE_DOSSIER;
	}
	public void setCLE_DOSSIER(String cLE_DOSSIER) {
		CLE_DOSSIER = cLE_DOSSIER;
	}
	public String getNUM_DOSSIER_COMPLET() {
		return NUM_DOSSIER_COMPLET;
	}
	public void setNUM_DOSSIER_COMPLET(String nUM_DOSSIER_COMPLET) {
		NUM_DOSSIER_COMPLET = nUM_DOSSIER_COMPLET;
	}
	public String getNUMERO_LIGNE() {
		return NUMERO_LIGNE;
	}
	public void setNUMERO_LIGNE(String nUMERO_LIGNE) {
		NUMERO_LIGNE = nUMERO_LIGNE;
	}
	public String getNUMERO_TIRAGE() {
		return NUMERO_TIRAGE;
	}
	public void setNUMERO_TIRAGE(String nUMERO_TIRAGE) {
		NUMERO_TIRAGE = nUMERO_TIRAGE;
	}
	public String getANCIEN_NUMERO_DOSSIER() {
		return ANCIEN_NUMERO_DOSSIER;
	}
	public void setANCIEN_NUMERO_DOSSIER(String aNCIEN_NUMERO_DOSSIER) {
		ANCIEN_NUMERO_DOSSIER = aNCIEN_NUMERO_DOSSIER;
	}
	
	
}
