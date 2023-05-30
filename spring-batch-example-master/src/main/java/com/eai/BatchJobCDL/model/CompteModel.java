package com.eai.BatchJobCDL.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMPTE")
public class CompteModel {
	@Id
	@SequenceGenerator(name = "compteSeqGen", sequenceName = "SEQ_COMPTE", initialValue = 1, allocationSize = 10000)
	@GeneratedValue(generator = "compteSeqGen")
	@Column(name = "CODE")
	private BigDecimal code;

	@Column(name = "NUMERO_COMPTE_EMPRUNTEUR")
	private String numeroCompteEmprunteur;

	@Column(name = "ENCOURS_EES_CONSO")
	private BigDecimal encoursEESConso;

	@Column(name = "ENCOURS_EES_COMM")
	private BigDecimal encoursEESComm;

	@Column(name = "ENCOURS_ESB")
	private BigDecimal encoursESB;

	@Column(name = "ENCOURS_ESI")
	private BigDecimal encoursESI;

	@Column(name = "SOLDE")
	private BigDecimal solde;

	@Column(name = "ENCOURS_DECLASSE")
	private BigDecimal encoursDeclasse;

	@Column(name = "ENCOURS_RISQUE")
	private BigDecimal encoursRisque;

	@Column(name = "TYPE_CLIENT")
	private String typeClient;

	@Column(name = "NUM_TIERS")
	private String numTiers;
//blow is not much use
	@Column(name = "TYPE_PROPOSITION")
	private String typeProposition;

	@Column(name = "DATE_PROPOSITION")
	private Date dateProposition;

	@Column(name = "NATURE_PROPOSITION")
	private String natureProposition;

	@Column(name = "STATUT")
	private String statut;

	@Column(name = "DATE_STATUT")
	private Date dateStatut;

	@Column(name = "RAISON_SOCIALE")
	private String raisonSociale;

	public BigDecimal getCode() {
		return code;
	}

	public void setCode(BigDecimal code) {
		this.code = code;
	}

	public String getNumeroCompteEmprunteur() {
		return numeroCompteEmprunteur;
	}

	public void setNumeroCompteEmprunteur(String numeroCompteEmprunteur) {
		this.numeroCompteEmprunteur = numeroCompteEmprunteur;
	}

	public BigDecimal getEncoursEESConso() {
		return encoursEESConso;
	}

	public void setEncoursEESConso(BigDecimal encoursEESConso) {
		this.encoursEESConso = encoursEESConso;
	}

	public BigDecimal getEncoursEESComm() {
		return encoursEESComm;
	}

	public void setEncoursEESComm(BigDecimal encoursEESComm) {
		this.encoursEESComm = encoursEESComm;
	}

	public BigDecimal getEncoursESB() {
		return encoursESB;
	}

	public void setEncoursESB(BigDecimal encoursESB) {
		this.encoursESB = encoursESB;
	}

	public BigDecimal getEncoursESI() {
		return encoursESI;
	}

	public void setEncoursESI(BigDecimal encoursESI) {
		this.encoursESI = encoursESI;
	}

	public BigDecimal getSolde() {
		return solde;
	}

	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}

	public BigDecimal getEncoursDeclasse() {
		return encoursDeclasse;
	}

	public void setEncoursDeclasse(BigDecimal encoursDeclasse) {
		this.encoursDeclasse = encoursDeclasse;
	}

	public BigDecimal getEncoursRisque() {
		return encoursRisque;
	}

	public void setEncoursRisque(BigDecimal encoursRisque) {
		this.encoursRisque = encoursRisque;
	}

	public String getTypeClient() {
		return typeClient;
	}

	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}

	public String getNumTiers() {
		return numTiers;
	}

	public void setNumTiers(String numTiers) {
		this.numTiers = numTiers;
	}

	public String getTypeProposition() {
		return typeProposition;
	}

	public void setTypeProposition(String typeProposition) {
		this.typeProposition = typeProposition;
	}

	public Date getDateProposition() {
		return dateProposition;
	}

	public void setDateProposition(Date dateProposition) {
		this.dateProposition = dateProposition;
	}

	public String getNatureProposition() {
		return natureProposition;
	}

	public void setNatureProposition(String natureProposition) {
		this.natureProposition = natureProposition;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateStatut() {
		return dateStatut;
	}

	public void setDateStatut(Date dateStatut) {
		this.dateStatut = dateStatut;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	
}