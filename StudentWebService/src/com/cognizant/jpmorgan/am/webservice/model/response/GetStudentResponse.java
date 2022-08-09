
package com.cognizant.jpmorgan.am.webservice.model.response;

import com.cognizant.jpmorgan.am.webservice.model.common.WebServiceBaseResponse;

public class GetStudentResponse extends WebServiceBaseResponse {

	private String name;
	private String role;
	private String standard;
	private String schoolName;
	private String registrationNo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	@Override
	public String toString() {
		return "GetStudentResponse [name=" + name + ", role=" + role + ", standard=" + standard + ", schoolName="
				+ schoolName + ", registrationNo=" + registrationNo + ", getName()=" + getName() + ", getRole()="
				+ getRole() + ", getStandard()=" + getStandard() + ", getSchoolName()=" + getSchoolName()
				+ ", getRegistrationNo()=" + getRegistrationNo() + ", getRequestId()=" + getRequestId()
				+ ", getAppId()=" + getAppId() + "]";
	}	

}
