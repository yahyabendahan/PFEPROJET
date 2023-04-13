package com.example.springbatchexample.constantes;

import org.springframework.stereotype.Service;

@Service
public class Constantes {

	public static final String ECH_FILE_PATH = "C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\CDL_ECH.creances";
	public static final String ESC_FILE_PATH = "C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\CDL_ESC.creances";
	public static final String SBF_FILE_PATH = "C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\CDL_SBF.creances";
	public static final String MCN_FILE_PATH = "C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\CDL_MCN.creances";
	public static final String DOC_FILE_PATH = "C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\CDL_DOC.creances";
	public static final String EFA_FILE_PATH = "C:\\Users\\acer\\Desktop\\pfe\\fichier donnees\\CDL_EFA.creances";
	public static final String[] ECH_ColumnNames = {"age", "nateng", "type", "cpt", "raisonSocial", "montantCreance", "dateCreance", "idClient", "noDossier", "dateEcheance", "dateMiseImpaye", "dateReglement", "montantAmortissement", "montantInteretNormal", "tvaInteret", "montantInteretRetard", "tvaInteretRetard", "montantPenaliteRetard", "tvaPenaliteRetard", "numComptePayeur", "codeCategorie", "numDossierComplet", "numeroLigne", "numeroTirage"};
	public static final String[] SBF_ColumnNames = {"age", "nateng", "type", "cpt", "raisonSocial", "montantCreance", "dateCreance", "idClient", "noDossier", "refferenceValeur", "codeEtablissementBancaire", "codeGuichetBancaire", "dateRemise", "referenceLiaison", "codeRejet", "commission", "field16", "field17"};
	public static final String[] ESC_ColumnNames = {"age", "nateng", "type", "cpt", "raisonSocial", "montantCreance", "dateCreance", "noDossier", "refferenceValeur", "dateEcheance", "codeEtablissementBancaire", "codeGuichetBancaire", "dateRemise", "referenceLiaison", "codeRejet", "commission", "field16", "field17"};
	public static final String[] MCN_ColumnNames = {"age", "nateng", "type", "cpt", "raisonSocial", "montantCreance", "dateCreance", "idClient", "noDossier", "dateEcheance", "dateMiseImpaye", "referenceValeur", "field13", "field14", "field15", "field16", "field17"};
	public static final String[] DOC_ColumnNames = {"age", "nateng", "type", "cpt", "raisonSocial", "montantCreance", "dateCreance", "idClient", "noDossier", "dateEcheance", "dateMiseImpaye", "referenceValeur", "field13", "field14", "field15", "field16", "field17"};
	public static final String[] EFA_ColumnNames = {"age", "nateng", "type", "cpt", "raisonSocial", "montantCreance", "dateCreance", "idClient", "noDossier", "dateEcheance", "dateMiseImpaye", "referenceValeur", "field13", "field14", "field15", "field16", "field17"};
}
