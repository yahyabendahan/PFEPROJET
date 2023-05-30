package com.eai.BatchJobCDL.model;

import java.math.BigDecimal;
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
	private BigDecimal montantCreance;

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
	private BigDecimal montantAmortissement;

	@Column(name = "MONTANT_INTERET_NORMAL")
	private BigDecimal montantInteretNormal;

	@Column(name = "TVA_INTERET")
	private BigDecimal tvaInteret;

	@Column(name = "MONTANT_INTERET_RETARD")
	private BigDecimal montantInteretRetard;

	@Column(name = "TVA_INTERET_RETARD")
	private BigDecimal tvaInteretRetard;

	@Column(name = "MONATANT_PENALITE_RETARD")
	private BigDecimal montantPenaliteRetard;

	@Column(name = "TVA_PENALITE_RETARD")
	private BigDecimal tvaPenaliteRetard;

	@Column(name = "NUM_COMPTE_PAYEUR")
	private String numComptePayeur;

	@Column(name = "REFFERENCE_VALEUR")
	private String refferenceValeur;

	@Column(name = "REFERNCE_LIAISON")
	private String referenceLiaison;

	@Column(name = "COMISSION")
	private BigDecimal commission;

	@Column(name = "CODE_REJET")
	private String codeRejet;

	@Column(name = "CODE_ETABLISST_BANCAIRE")
	private String codeEtablissementBancaire;

	@Column(name = "CODE_GUICHET_BANCAIRE")
	private String codeGuichetBancaire;

	@Column(name = "DATE_REMISE")
	private String dateRemise;

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
	
	@Column(name ="ENCOURS_RISQUE")
	private BigDecimal encoursRisque;
	
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

	public BigDecimal getMontantCreance() {
		return montantCreance;
	}

	public void setMontantCreance(BigDecimal montantCreance) {
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

	public BigDecimal getMontantAmortissement() {
		return montantAmortissement;
	}

	public void setMontantAmortissement(BigDecimal montantAmortissement) {
		this.montantAmortissement = montantAmortissement;
	}

	public BigDecimal getMontantInteretNormal() {
		return montantInteretNormal;
	}

	public void setMontantInteretNormal(BigDecimal montantInteretNormal) {
		this.montantInteretNormal = montantInteretNormal;
	}

	public BigDecimal getTvaInteret() {
		return tvaInteret;
	}

	public void setTvaInteret(BigDecimal tvaInteret) {
		this.tvaInteret = tvaInteret;
	}

	public BigDecimal getMontantInteretRetard() {
		return montantInteretRetard;
	}

	public void setMontantInteretRetard(BigDecimal montantInteretRetard) {
		this.montantInteretRetard = montantInteretRetard;
	}

	public BigDecimal getTvaInteretRetard() {
		return tvaInteretRetard;
	}

	public void setTvaInteretRetard(BigDecimal tvaInteretRetard) {
		this.tvaInteretRetard = tvaInteretRetard;
	}

	public BigDecimal getMontantPenaliteRetard() {
		return montantPenaliteRetard;
	}

	public void setMontantPenaliteRetard(BigDecimal montantPenaliteRetard) {
		this.montantPenaliteRetard = montantPenaliteRetard;
	}

	public BigDecimal getTvaPenaliteRetard() {
		return tvaPenaliteRetard;
	}

	public void setTvaPenaliteRetard(BigDecimal tvaPenaliteRetard) {
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

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
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

