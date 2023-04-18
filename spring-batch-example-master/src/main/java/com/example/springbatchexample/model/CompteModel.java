package com.example.springbatchexample.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPTE")
public class CompteModel {
	@Id
	@Column(name = "CODE")
	private Double code;

	@Column(name = "NUMERO_COMPTE_EMPRUNTEUR")
	private String numeroCompteEmprunteur;

	@Column(name = "ENCOURS_EES_CONSO")
	private Double encoursEESConso;

	@Column(name = "ENCOURS_EES_COMM")
	private Double encoursEESComm;

	@Column(name = "ENCOURS_ESB")
	private Double encoursESB;

	@Column(name = "ENCOURS_ESI")
	private Double encoursESI;

	@Column(name = "SOLDE")
	private Double solde;

	@Column(name = "ENCOURS_DECLASSE")
	private Double encoursDeclasse;

	@Column(name = "ENCOURS_RISQUE")
	private Double encoursRisque;

	@Column(name = "TYPE_CLIENT")
	private String typeClient;

	@Column(name = "NUM_TIERS")
	private String numTiers;
//blow is not much use
	@Column(name = "TYPE_PROPOSITION")
	private String typeProposition;

	@Column(name = "DATE_PROPOSITION")
	private LocalDate dateProposition;

	@Column(name = "NATURE_PROPOSITION")
	private String natureProposition;

	@Column(name = "STATUT")
	private String statut;

	@Column(name = "DATE_STATUT")
	private LocalDate dateStatut;

	@Column(name = "RAISON_SOCIALE")
	private String raisonSociale;

	public Double getCode() {
		return code;
	}

	public void setCode(Double code) {
		this.code = code;
	}

	public String getNumeroCompteEmprunteur() {
		return numeroCompteEmprunteur;
	}

	public void setNumeroCompteEmprunteur(String numeroCompteEmprunteur) {
		this.numeroCompteEmprunteur = numeroCompteEmprunteur;
	}

	public Double getEncoursEESConso() {
		return encoursEESConso;
	}

	public void setEncoursEESConso(Double encoursEESConso) {
		this.encoursEESConso = encoursEESConso;
	}

	public Double getEncoursEESComm() {
		return encoursEESComm;
	}

	public void setEncoursEESComm(Double encoursEESComm) {
		this.encoursEESComm = encoursEESComm;
	}

	public Double getEncoursESB() {
		return encoursESB;
	}

	public void setEncoursESB(Double encoursESB) {
		this.encoursESB = encoursESB;
	}

	public Double getEncoursESI() {
		return encoursESI;
	}

	public void setEncoursESI(Double encoursESI) {
		this.encoursESI = encoursESI;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Double getEncoursDeclasse() {
		return encoursDeclasse;
	}

	public void setEncoursDeclasse(Double encoursDeclasse) {
		this.encoursDeclasse = encoursDeclasse;
	}

	public Double getEncoursRisque() {
		return encoursRisque;
	}

	public void setEncoursRisque(Double encoursRisque) {
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

	public LocalDate getDateProposition() {
		return dateProposition;
	}

	public void setDateProposition(LocalDate dateProposition) {
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

	public LocalDate getDateStatut() {
		return dateStatut;
	}

	public void setDateStatut(LocalDate dateStatut) {
		this.dateStatut = dateStatut;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	
	

}