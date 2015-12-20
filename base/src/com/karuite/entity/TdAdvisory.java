package com.karuite.entity;

/**
 * TdUser entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class TdAdvisory implements java.io.Serializable {

	private static final long serialVersionUID = -7727973772823431603L;
	
	private String id;
	private String businessBackground;
	private String successfulCase;
	private String excelField;
	private String contactInformation;

	// Constructors

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBusinessBackground() {
		return businessBackground;
	}

	public void setBusinessBackground(String businessBackground) {
		this.businessBackground = businessBackground;
	}

	public String getSuccessfulCase() {
		return successfulCase;
	}

	public void setSuccessfulCase(String successfulCase) {
		this.successfulCase = successfulCase;
	}

	public String getExcelField() {
		return excelField;
	}

	public void setExcelField(String excelField) {
		this.excelField = excelField;
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	/** default constructor */
	public TdAdvisory() {
	}

	public TdAdvisory(String id, String businessBackground,
			String successfulCase, String excelField, String contactInformation) {
		this.id = id;
		this.businessBackground = businessBackground;
		this.successfulCase = successfulCase;
		this.excelField = excelField;
		this.contactInformation = contactInformation;
	}

	/** full constructor */


}
