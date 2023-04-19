package com.example.springbatchexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DOSSIER")
public class DossierModel {
	
	@Id
	@Column
	private Double CODE;
	@Column
	private String NUMERO_DOSSIER;
	@Column
	private Double ENCOURS;
	@Column
	private Double CODE_COMPTE;
	@Column
	private String TYPE_DOSSIER;
	@Column
	private String CLE_DOSSIER;
	@Column
	private String NUM_DOSSIER_COMPLET;
	@Column
	private String NUMERO_LIGNE;
	@Column
	private String NUMERO_TIRAGE;
	@Column
	private String ANCIEN_NUMERO_DOSSIER;
	public Double getCODE() {
		return CODE;
	}
	public void setCODE(Double cODE) {
		CODE = cODE;
	}
	public String getNUMERO_DOSSIER() {
		return NUMERO_DOSSIER;
	}
	public void setNUMERO_DOSSIER(String nUMERO_DOSSIER) {
		NUMERO_DOSSIER = nUMERO_DOSSIER;
	}
	public Double getENCOURS() {
		return ENCOURS;
	}
	public void setENCOURS(Double eNCOURS) {
		ENCOURS = eNCOURS;
	}
	public Double getCODE_COMPTE() {
		return CODE_COMPTE;
	}
	public void setCODE_COMPTE(Double cODE_COMPTE) {
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
