package com.eai.BatchJobCDL.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NATURE_ENGAGEMENT")
public class NatEngModel {

	@Id
	@Column(name = "CODE")
	private String code;
	
	@Column(name = "LIBELLE_COURT")
	private String LibelleCourt;
	
	@Column(name = "LIBELLE_LONG")
	private String LibelleLong;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelleCourt() {
		return LibelleCourt;
	}

	public void setLibelleCourt(String libelleCourt) {
		LibelleCourt = libelleCourt;
	}

	public String getLibelleLong() {
		return LibelleLong;
	}

	public void setLibelleLong(String libelleLong) {
		LibelleLong = libelleLong;
	}
	
	
}
