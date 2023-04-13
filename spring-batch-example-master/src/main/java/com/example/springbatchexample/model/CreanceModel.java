/*package com.example.springbatchexample.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "CREANCE")
public class CreanceModel {

    @Id
    @Column(name = "CODE")
    private Double code;

    @ManyToOne
    @JoinColumn(name = "CODE_TYPE_DOSSIER")
    private TypeDossierModel typeDossier;

    @Column(name = "CODE_MOTIF")
    private String codeMotif;

    @Column(name = "CODE_NAT_ENG")
    private String codeNatEng;

    @Column(name = "CODE_DOSSIER")
    private Double codeDossier;

    @Column(name = "MONTANT")
    private Double montant;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_ECHEANCE")
    private Date dateEcheance;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_CREANCE")
    private Date dateCreance;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_MISE_IMPAYE")
    private Date dateMiseImpaye;

    @Column(name = "MONTANT_AMORTISS")
    private Double montantAmortiss;

    @Column(name = "MONTANT_INTERET_NORMAL")
    private Double montantInteretNormal;

    @Column(name = "TVA_INTERET_NORMAL")
    private Double tvaInteretNormal;

    @Column(name = "MONTANT_INTERET_RETARD")
    private Double montantInteretRetard;

    @Column(name = "TVA_INTERET_RETARD")
    private Double tvaInteretRetard;

    @Column(name = "PENALITE_RETARD")
    private Double penaliteRetard;

    @Column(name = "TVA_PENALITE_RETARD")
    private Double tvaPenaliteRetard;

    @Column(name = "CODE_GUICHET_BANCAIRE")
    private String codeGuichetBancaire;

    @Column(name = "CODE_ETABLISST_BANCAIRE")
    private String codeEtablissementBancaire;

    @Column(name = "REFERENCE_VALEUR")
    private String referenceValeur;

    @Temporal(TemporalType.DATE)
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

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_PROPOSITION")
    private Date dateProposition;

    @ManyToOne
    @JoinColumn(name = "NATURE_PROPOSITION")
    private String natureProposition;

    @Column(name = "NUMERO")
    private String numero;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_LOAD_OVO")
    private Date dateLoadOvo;

    @Column(name = "STATUT_G19")
    private String statutG19;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_COMITE")
    private Date dateComite;
    
    @Column(name = "NUMERO_LIGNE")
    private String numeroLigne;
    
    @Column(name = "NUMERO_TIRAGE")
    private String numeroTirage;
    
    @Column(name = "USER_CREATION")
    private String userCreation;
    
    @Column(name = "ANCIEN_CODE_DOSSIER")
    private Double ancienCodeDossier;

	public Double getCode() {
		return code;
	}

	public void setCode(Double code) {
		this.code = code;
	}

	public TypeDossierModel getTypeDossier() {
		return typeDossier;
	}

	public void setTypeDossier(TypeDossierModel typeDossier) {
		this.typeDossier = typeDossier;
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

	public Double getCodeDossier() {
		return codeDossier;
	}

	public void setCodeDossier(Double codeDossier) {
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

	public Double getTvaInteretNormal() {
		return tvaInteretNormal;
	}

	public void setTvaInteretNormal(Double tvaInteretNormal) {
		this.tvaInteretNormal = tvaInteretNormal;
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

	public Double getPenaliteRetard() {
		return penaliteRetard;
	}

	public void setPenaliteRetard(Double penaliteRetard) {
		this.penaliteRetard = penaliteRetard;
	}

	public Double getTvaPenaliteRetard() {
		return tvaPenaliteRetard;
	}

	public void setTvaPenaliteRetard(Double tvaPenaliteRetard) {
		this.tvaPenaliteRetard = tvaPenaliteRetard;
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

	public Date getDateLoadOvo() {
		return dateLoadOvo;
	}

	public void setDateLoadOvo(Date dateLoadOvo) {
		this.dateLoadOvo = dateLoadOvo;
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

	public Double getAncienCodeDossier() {
		return ancienCodeDossier;
	}

	public void setAncienCodeDossier(Double ancienCodeDossier) {
		this.ancienCodeDossier = ancienCodeDossier;
	}
    
    
}*/