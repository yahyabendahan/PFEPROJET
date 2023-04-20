package com.eai.BatchJobCDL.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "IMPAYES_CDL_REJET")
public class ImpayesCdlRejetModel {
	
	@Id
	@Column(name = "NATENG")
	private String nateng;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "CPT")
	private String cpt;

	@Column(name = "MONTANT_CREANCE")
	private Double montantCreance;

	@Column(name = "DATE_CREANCE")
	private String dateCreance;

	@Column(name = "NO_DOSSIER")
	private String noDossier;

	@Column(name = "DATE_ECHEANCE")
	private String dateEcheance;

	@Column(name = "DATE_MISE_IMPAYE")
	private String dateMiseImpaye;

	@Column(name = "DATE_REGLEMENT")
	private String dateReglement;

	@Column(name = "MONTANT_AMORTISSEMENT")
	private Double montantAmortissement;

	@Column(name = "MONTANT_INTERET_NORMAL")
	private Double montantInteretNormal;

	@Column(name = "TVA_INTERET")
	private Double tvaInteret;

	@Column(name = "MONTANT_INTERET_RETARD")
	private Double montantInteretRetard;

	@Column(name = "TVA_INTERET_RETARD")
	private Double tvaInteretRetard;

	@Column(name = "MONATANT_PENALITE_RETARD")
	private Double montantPenaliteRetard;

	@Column(name = "TVA_PENALITE_RETARD")
	private Double tvaPenaliteRetard;

	@Column(name = "NUM_COMPTE_PAYEUR")
	private String numComptePayeur;

	@Column(name = "REFFERENCE_VALEUR")
	private String refferenceValeur;

	@Column(name = "REFERNCE_LIAISON")
	private String referenceLiaison;

	@Column(name = "COMISSION")
	private Double commission;

	@Column(name = "CODE_REJET")
	private String codeRejet;

	@Column(name = "CODE_ETABLISST_BANCAIRE")
	private String codeEtablissementBancaire;

	@Column(name = "CODE_GUICHET_BANCAIRE")
	private String codeGuichetBancaire;

	@Column(name = "DATE_REMISE")
	private String dateRemise;

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
	
	@Column(name ="ENCOURS_RISQUE")
	private Double encoursRisque;
	
	@Column(name = "TYPE_CLIENT")
	private String typeClient;
	
	@Column(name = "NUM_TIERS")
	private String numTiers;
	
	@Column(name = "CODE_CATEGORIE")
	private String codeCategorie;
	
	@Column(name = "NUM_DOSSIER_COMPLET")
	private String numDossierComplet;
	
	@Column(name = "NUMERO_LIGNE")
	private String numeroLigne;
	
	@Column(name = "NUMERO_TIRAGE")
	private String numeroTirage;
	
	@Column(name = "DATE_REJET")
	private Date dateRejet;
	
	@Column(name = "MOTIF_REJET")
	private String motifRejet;

	public String getNateng() {
		return nateng;
	}

	public void setNateng(String nateng) {
		this.nateng = nateng;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCpt() {
		return cpt;
	}

	public void setCpt(String cpt) {
		this.cpt = cpt;
	}

	public Double getMontantCreance() {
		return montantCreance;
	}

	public void setMontantCreance(Double montantCreance) {
		this.montantCreance = montantCreance;
	}

	public String getDateCreance() {
		return dateCreance;
	}

	public void setDateCreance(String dateCreance) {
		this.dateCreance = dateCreance;
	}

	public String getNoDossier() {
		return noDossier;
	}

	public void setNoDossier(String noDossier) {
		this.noDossier = noDossier;
	}

	public String getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(String dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public String getDateMiseImpaye() {
		return dateMiseImpaye;
	}

	public void setDateMiseImpaye(String dateMiseImpaye) {
		this.dateMiseImpaye = dateMiseImpaye;
	}

	public String getDateReglement() {
		return dateReglement;
	}

	public void setDateReglement(String dateReglement) {
		this.dateReglement = dateReglement;
	}

	public Double getMontantAmortissement() {
		return montantAmortissement;
	}

	public void setMontantAmortissement(Double montantAmortissement) {
		this.montantAmortissement = montantAmortissement;
	}

	public Double getMontantInteretNormal() {
		return montantInteretNormal;
	}

	public void setMontantInteretNormal(Double montantInteretNormal) {
		this.montantInteretNormal = montantInteretNormal;
	}

	public Double getTvaInteret() {
		return tvaInteret;
	}

	public void setTvaInteret(Double tvaInteret) {
		this.tvaInteret = tvaInteret;
	}

	public Double getMontantInteretRetard() {
		return montantInteretRetard;
	}

	public void setMontantInteretRetard(Double montantInteretRetard) {
		this.montantInteretRetard = montantInteretRetard;
	}

	public Double getTvaInteretRetard() {
		return tvaInteretRetard;
	}

	public void setTvaInteretRetard(Double tvaInteretRetard) {
		this.tvaInteretRetard = tvaInteretRetard;
	}

	public Double getMontantPenaliteRetard() {
		return montantPenaliteRetard;
	}

	public void setMontantPenaliteRetard(Double montantPenaliteRetard) {
		this.montantPenaliteRetard = montantPenaliteRetard;
	}

	public Double getTvaPenaliteRetard() {
		return tvaPenaliteRetard;
	}

	public void setTvaPenaliteRetard(Double tvaPenaliteRetard) {
		this.tvaPenaliteRetard = tvaPenaliteRetard;
	}

	public String getNumComptePayeur() {
		return numComptePayeur;
	}

	public void setNumComptePayeur(String numComptePayeur) {
		this.numComptePayeur = numComptePayeur;
	}

	public String getRefferenceValeur() {
		return refferenceValeur;
	}

	public void setRefferenceValeur(String refferenceValeur) {
		this.refferenceValeur = refferenceValeur;
	}

	public String getReferenceLiaison() {
		return referenceLiaison;
	}

	public void setReferenceLiaison(String referenceLiaison) {
		this.referenceLiaison = referenceLiaison;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public String getCodeRejet() {
		return codeRejet;
	}

	public void setCodeRejet(String codeRejet) {
		this.codeRejet = codeRejet;
	}

	public String getCodeEtablissementBancaire() {
		return codeEtablissementBancaire;
	}

	public void setCodeEtablissementBancaire(String codeEtablissementBancaire) {
		this.codeEtablissementBancaire = codeEtablissementBancaire;
	}

	public String getCodeGuichetBancaire() {
		return codeGuichetBancaire;
	}

	public void setCodeGuichetBancaire(String codeGuichetBancaire) {
		this.codeGuichetBancaire = codeGuichetBancaire;
	}

	public String getDateRemise() {
		return dateRemise;
	}

	public void setDateRemise(String dateRemise) {
		this.dateRemise = dateRemise;
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

	public String getCodeCategorie() {
		return codeCategorie;
	}

	public void setCodeCategorie(String codeCategorie) {
		this.codeCategorie = codeCategorie;
	}

	public String getNumDossierComplet() {
		return numDossierComplet;
	}

	public void setNumDossierComplet(String numDossierComplet) {
		this.numDossierComplet = numDossierComplet;
	}

	public String getNumeroLigne() {
		return numeroLigne;
	}

	public void setNumeroLigne(String numeroLigne) {
		this.numeroLigne = numeroLigne;
	}

	public String getNumeroTirage() {
		return numeroTirage;
	}

	public void setNumeroTirage(String numeroTirage) {
		this.numeroTirage = numeroTirage;
	}

	public Date getDateRejet() {
		return dateRejet;
	}

	public void setDateRejet(Date dateRejet) {
		this.dateRejet = dateRejet;
	}

	public String getMotifRejet() {
		return motifRejet;
	}

	public void setMotifRejet(String motifRejet) {
		this.motifRejet = motifRejet;
	}




}

