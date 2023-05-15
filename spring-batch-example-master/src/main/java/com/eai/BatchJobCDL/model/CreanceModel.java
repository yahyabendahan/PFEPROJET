package com.eai.BatchJobCDL.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CREANCE")
public class CreanceModel {

	@Id
	@SequenceGenerator(name = "creanceSeqGen", sequenceName = "SEQ_CREANCE", initialValue = 1, allocationSize = 999999999)
	@GeneratedValue(generator = "creanceSeqGen")
	@Column(name = "CODE")
	private Long id;
	
	@Column(name = "CODE_TYPE_DOSSIER")
	private String codeTypeDossier;

	@Column(name = "CODE_MOTIF")
	private String codeMotif;

	@Column(name = "CODE_NAT_ENG")
	private String codeNatEng;

	/*@ManyToOne
    @JoinColumn(name ="CODE_DOSSIER")
	private DossierModel dossier;*/

	@ManyToOne
	@Column(name ="CODE_DOSSIER")
	private Long  codeDossier;
	
	@Column(name = "MONTANT")
	private Double montant;

	@Column(name = "DATE_ECHEANCE")
	private Date dateEcheance;

	@Column(name = "DATE_CREANCE")
	private Date dateCreance;

	@Column(name = "DATE_MISE_IMPAYE")
	private Date dateMiseImpaye;

	@Column(name = "MONTANT_AMORTISS")
	private Double montantAmortiss;

	@Column(name = "MONTANT_INTERET_NORMAL")
	private Double montantInteretNormal;

	@Column(name = "TVA_INTERET_NORMAL")
	private Double TVAInteretNormal;

	@Column(name = "MONTANT_INTERET_RETARD")
	private Double montantInteretRetard;

	@Column(name = "TVA_INTERET_RETARD")
	private Double TVAInteretRetard;

	@Column(name = "PENALITE_RETARD")
	private Double penaliteRetard;

	@Column(name = "TVA_PENALITE_RETARD")
	private Double TVApenaliteRetard;

	@Column(name = "CODE_GUICHET_BANCAIRE")
	private String codeGuichetBancaire;

	@Column(name = "CODE_ETABLISST_BANCAIRE")
	private String codeEtablissementBancaire;

	@Column(name = "REFERENCE_VALEUR")
	private String referenceValeur;

	@Column(name = "DATE_REMISE")
	private Date dateRemise;

	@Column(name = "REFERENCE_LIAISON")
	private String referenceLiaison;

	@Column(name = "CODE_CATEGORIE")
	private String codeCategorie;

	@Column(name = "NUMERO_COMPTE_PAYEUR")
	private String numeroComptePayeur;

	@Column(name = "STATUT")
	private String statut;

	@Column(name = "TYPE_CREANCE")
	private String typeCreance;

	@Column(name = "TYPE_PROPOSITION")
	private String typeProposition;

	@Column(name = "DATE_PROPOSITION")
	private Date dateProposition;

	@Column(name = "NATURE_PROPOSITION")
	private String natureProposition;

	@Column(name = "NUMERO")
	private String numero;

	@Column(name = "DATE_LOAD_OVO")
	private Date dateLoadOVO;

	@Column(name = "STATUT_G19")
	private String statutG19;

	@Column(name = "DATE_COMITE")
	private Date dateComite;

	@Column(name = "NUMERO_LIGNE")
	private String numeroLigne;

	@Column(name = "NUMERO_TIRAGE")
	private String numeroTirage;

	@Column(name = "USER_CREATION")
	private String userCreation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeTypeDossier() {
		return codeTypeDossier;
	}

	public void setCodeTypeDossier(String codeTypeDossier) {
		this.codeTypeDossier = codeTypeDossier;
	}

	public String getCodeMotif() {
		return codeMotif;
	}

	public void setCodeMotif(String codeMotif) {
		this.codeMotif = codeMotif;
	}

	public String getCodeNatEng() {
		return codeNatEng;
	}

	public void setCodeNatEng(String codeNatEng) {
		this.codeNatEng = codeNatEng;
	}

	public Long  getcodeDossier() {
		return codeDossier;
	}

	public void setcodeDossier(Long  codeDossier) {
		this.codeDossier = codeDossier;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public Date getDateCreance() {
		return dateCreance;
	}

	public void setDateCreance(Date dateCreance) {
		this.dateCreance = dateCreance;
	}

	public Date getDateMiseImpaye() {
		return dateMiseImpaye;
	}

	public void setDateMiseImpaye(Date dateMiseImpaye) {
		this.dateMiseImpaye = dateMiseImpaye;
	}

	public Double getMontantAmortiss() {
		return montantAmortiss;
	}

	public void setMontantAmortiss(Double montantAmortiss) {
		this.montantAmortiss = montantAmortiss;
	}

	public Double getMontantInteretNormal() {
		return montantInteretNormal;
	}

	public void setMontantInteretNormal(Double montantInteretNormal) {
		this.montantInteretNormal = montantInteretNormal;
	}

	public Double getTVAInteretNormal() {
		return TVAInteretNormal;
	}

	public void setTVAInteretNormal(Double tVAInteretNormal) {
		TVAInteretNormal = tVAInteretNormal;
	}

	public Double getMontantInteretRetard() {
		return montantInteretRetard;
	}

	public void setMontantInteretRetard(Double montantInteretRetard) {
		this.montantInteretRetard = montantInteretRetard;
	}

	public Double getTVAInteretRetard() {
		return TVAInteretRetard;
	}

	public void setTVAInteretRetard(Double tVAInteretRetard) {
		TVAInteretRetard = tVAInteretRetard;
	}

	public Double getPenaliteRetard() {
		return penaliteRetard;
	}

	public void setPenaliteRetard(Double penaliteRetard) {
		this.penaliteRetard = penaliteRetard;
	}

	public Double getTVApenaliteRetard() {
		return TVApenaliteRetard;
	}

	public void setTVApenaliteRetard(Double tVApenaliteRetard) {
		TVApenaliteRetard = tVApenaliteRetard;
	}

	public String getCodeGuichetBancaire() {
		return codeGuichetBancaire;
	}

	public void setCodeGuichetBancaire(String codeGuichetBancaire) {
		this.codeGuichetBancaire = codeGuichetBancaire;
	}

	public String getCodeEtablissementBancaire() {
		return codeEtablissementBancaire;
	}

	public void setCodeEtablissementBancaire(String codeEtablissementBancaire) {
		this.codeEtablissementBancaire = codeEtablissementBancaire;
	}

	public String getReferenceValeur() {
		return referenceValeur;
	}

	public void setReferenceValeur(String referenceValeur) {
		this.referenceValeur = referenceValeur;
	}

	public Date getDateRemise() {
		return dateRemise;
	}

	public void setDateRemise(Date dateRemise) {
		this.dateRemise = dateRemise;
	}

	public String getReferenceLiaison() {
		return referenceLiaison;
	}

	public void setReferenceLiaison(String referenceLiaison) {
		this.referenceLiaison = referenceLiaison;
	}

	public String getCodeCategorie() {
		return codeCategorie;
	}

	public void setCodeCategorie(String codeCategorie) {
		this.codeCategorie = codeCategorie;
	}

	public String getNumeroComptePayeur() {
		return numeroComptePayeur;
	}

	public void setNumeroComptePayeur(String numeroComptePayeur) {
		this.numeroComptePayeur = numeroComptePayeur;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getTypeCreance() {
		return typeCreance;
	}

	public void setTypeCreance(String typeCreance) {
		this.typeCreance = typeCreance;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateLoadOVO() {
		return dateLoadOVO;
	}

	public void setDateLoadOVO(Date dateLoadOVO) {
		this.dateLoadOVO = dateLoadOVO;
	}

	public String getStatutG19() {
		return statutG19;
	}

	public void setStatutG19(String statutG19) {
		this.statutG19 = statutG19;
	}

	public Date getDateComite() {
		return dateComite;
	}

	public void setDateComite(Date dateComite) {
		this.dateComite = dateComite;
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

	public String getUserCreation() {
		return userCreation;
	}

	public void setUserCreation(String userCreation) {
		this.userCreation = userCreation;
	}
	

}
