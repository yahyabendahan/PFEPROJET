package com.eai.BatchJobCDL.DTO;

public class McnFail {
	private String age;
	private String nateng;
	private String type;
	private String cpt;
	private String raisonSocial;
	private double montantCreance;
	private String dateCreance;
	private String idClient;
	private String noDossier;
	private String dateEcheance;
	private String dateMiseImpaye;
	private String refferenceValeur;
	private String field13;
	private String field14;
	private String field15;
	private String field16;
	private String field17;
	
	
	public String getRaisonSocial() {
		return raisonSocial;
	}
	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}
	public double getMontantCreance() {
		return montantCreance;
	}
	public void setMontantCreance(double montantCreance) {
		this.montantCreance = montantCreance;
	}
	public String getDateCreance() {
		return dateCreance;
	}
	public void setDateCreance(String dateCreance) {
		this.dateCreance = dateCreance;
	}
	public String getIdClient() {
		return idClient;
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
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

	public String getRefferenceValeur() {
		return refferenceValeur;
	}
	public void setRefferenceValeur(String refferenceValeur) {
		this.refferenceValeur = refferenceValeur;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
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

	public String getField13() {
		return field13;
	}
	public void setField13(String field13) {
		this.field13 = field13;
	}
	public String getField14() {
		return field14;
	}
	public void setField14(String field14) {
		this.field14 = field14;
	}
	public String getField15() {
		return field15;
	}
	public void setField15(String field15) {
		this.field15 = field15;
	}
	public String getField16() {
		return field16;
	}
	public void setField16(String field16) {
		this.field16 = field16;
	}
	public String getField17() {
		return field17;
	}
	public void setField17(String field17) {
		this.field17 = field17;
	}
	public String getDateMiseImpaye() {
		return dateMiseImpaye;
	}
	public void setDateMiseImpaye(String dateMiseImpaye) {
		this.dateMiseImpaye = dateMiseImpaye;
	}
	@Override
	public String toString() {
		return "McnFail [age=" + age + ", nateng=" + nateng + ", type=" + type + ", cpt=" + cpt + ", raisonSocial="
				+ raisonSocial + ", montantCreance=" + montantCreance + ", dateCreance=" + dateCreance + ", idClient="
				+ idClient + ", noDossier=" + noDossier + ", dateEcheance=" + dateEcheance + ", dateMiseImpaye="
				+ dateMiseImpaye + ", refferenceValeur=" + refferenceValeur + ", field13=" + field13 + ", field14="
				+ field14 + ", field15=" + field15 + ", field16=" + field16 + ", field17=" + field17 + "]";
	}
	
}
