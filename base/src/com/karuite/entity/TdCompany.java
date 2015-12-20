package com.karuite.entity;

/**
 * TdUser entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class TdCompany implements java.io.Serializable {

	private static final long serialVersionUID = -7727973772823431603L;
	
	private String id;
	private String companyName;
	private String mainBusiness;
	private String consultProblem;
	private String contactInformation;

	// Constructors

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getMainBusiness() {
		return mainBusiness;
	}

	public void setMainBusiness(String mainBusiness) {
		this.mainBusiness = mainBusiness;
	}

	public String getConsultProblem() {
		return consultProblem;
	}

	public void setConsultProblem(String consultProblem) {
		this.consultProblem = consultProblem;
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	/** default constructor */
	public TdCompany() {
	}

	/** full constructor */
	public TdCompany(String id, String companyName, String mainBusiness,
			String consultProblem, String contactInformation) {
		this.id = id;
		this.companyName = companyName;
		this.mainBusiness = mainBusiness;
		this.consultProblem = consultProblem;
		this.contactInformation = contactInformation;
	}


}
