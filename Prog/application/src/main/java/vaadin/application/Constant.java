package vaadin.application;



public interface Constant {

	// Valeurs de test
	public static final String USER = "postgres";
	public static final String PASSWORD = "db-2017";
	public static final String SRV = "147.87.116.214";
	public static final String DB="ap4tab";

	// Erreurs SQL
	public static final String ERRORSQLBDDDRIVER = "Probl�me de chargement du driver de la BDD SQL";
	public static final String ERRORSQLCONNECTION = "Probl�me de connexion � la BDD SQL";
	public static final String ERRORSQLCLOSE = "Impossible de clore la connexion � la BDD SQL";
	public static final String ERRORSQLREQUEST = "Erreur lors de l'ex�cution de la requ�te SQL";

	// requ�tes SQL
	public static final String SQLPATINFOSHORT = "SELECT [ID_PATIENT] , [PATIENT_FIRST_NAME] , [PATIENT_LAST_NAME] , "
			+ "[PATIENT_BIRTH] FROM [Handylife].[dbo].[T_PATIENT] WHERE PATIENT_BIRTH IS NOT NULL AND PATIENT_FIRST_NAME IS NOT NULL AND PATIENT_LAST_NAME IS NOT NULL";
	public static final String SQLLABOREQUEST = null;
	public static final String ERRORWRITING = "Erreur d'�criture";
	public static final String SQLPATREQUEST = "SELECT ID_PATIENT as NUMPAT,\r\n" + 
			"	PATIENT_LAST_NAME as NOM,\r\n" + 
			"	PATIENT_FIRST_NAME as PRENOM,\r\n" + 
			"	PATIENT_BIRTH as DDN,\r\n" + 
			"	PATIENT_TITLE as TITRE,\r\n" + 
			"	PATIENT_MARITAL_STATE as EtatCivil,\r\n" + 
			"	PATIENT_SEX_0F1M as SEXE,\r\n" + 
			"	PATIENT_ADDRESS as ADRESSE,\r\n" + 
			"	PATIENT_ZIP as NPA,\r\n" + 
			"	PATIENT_CITY as LIEU,\r\n" + 
			"	PATIENT_COUNTRY as PAYS,\r\n" + 
			"	PATIENT_TELEPHONE_DOMICILE as TEL_1,\r\n" + 
			"	PATIENT_NATEL as TEL_2,\r\n" + 
			"	PATIENT_TELEPHONE_PROF as TEL_3,\r\n" + 
			"	PATIENT_EMAIL as E_mail,\r\n" + 
			"	PATIENT_AVS_NUMBER as NUMAVS,\r\n" + 
			"	PATIENT_PROFESSION as PROFESSION,\r\n" + 
			"	PATIENT_PROF_EMPLOYEUR as EMPLOYEUR,\r\n" + 
			"	PATIENT_NATIONALITY as NATIONALITE,\r\n" + 
			"	PATIENT_FAX as FAX,\r\n" + 
			"	PATIENT_INSURANCE_NUMBER as NUMASSURANCE\r\n" + 
			"	FROM [Handylife].[dbo].T_PATIENT where PATIENT_BIRTH IS NOT NULL AND PATIENT_BIRTH < GETDATE()";

	// Methodes statiques

}
