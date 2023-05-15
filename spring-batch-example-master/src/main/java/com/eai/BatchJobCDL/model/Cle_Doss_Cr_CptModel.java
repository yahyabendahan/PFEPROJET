package com.eai.BatchJobCDL.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import java.util.Date;

@Entity
@Table(name = "CLE_DOSS_CR_CPT")
public class Cle_Doss_Cr_CptModel {

		@Id
		@Column(name = "CODE")
		private Long  code;

		@Column(name = "NUMERO_DOSSIER")
		private String numeroDossier;

		@Column(name = "CPT")
		private Long  cpt;

		@Column(name = "DATE_ECHEANCE")
		private Date dateEcheance;

		@Column(name ="CODE_TYPE_DOSSIER")
		private String codeTypeDossier ;
		
		@Column(name= "CLE_DOSSIER")
		private String cleDossier ;
		
		@Column(name = "CODE_NAT_ENG")
		private String codeNatEng;

		public Long  getCode() {
			return code;
		}

		public void setCode(Long  code) {
			this.code = code;
		}

		public String getNumeroDossier() {
			return numeroDossier;
		}

		public void setNumeroDossier(String numeroDossier) {
			this.numeroDossier = numeroDossier;
		}

		public Long  getCpt() {
			return cpt;
		}

		public void setCpt(Long  cpt) {
			this.cpt = cpt;
		}

		public Date getDateEcheance() {
			return dateEcheance;
		}

		public void setDateEcheance(Date dateEcheance) {
			this.dateEcheance = dateEcheance;
		}

		public String getCodeNatEng() {
			return codeNatEng;
		}

		public void setCodeNatEng(String codeNatEng) {
			this.codeNatEng = codeNatEng;
		}
		

}
