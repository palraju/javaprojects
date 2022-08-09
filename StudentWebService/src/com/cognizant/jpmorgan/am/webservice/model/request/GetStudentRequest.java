package com.cognizant.jpmorgan.am.webservice.model.request;

import com.cognizant.jpmorgan.am.webservice.model.common.WebServiceBaseRequest;

public class GetStudentRequest extends WebServiceBaseRequest {
	private String roleId;
	private String registrationNo;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	@Override
	public String toString() {
		return "GetStudentRequest [getRoleId()=" + getRoleId() + ", getRegistrationNo()=" + getRegistrationNo()
				+ ", getInvokerSid()=" + getInvokerSid() + ", getInvokingMethod()=" + getInvokingMethod()
				+ ", getRequestId()=" + getRequestId() + ", getAppId()=" + getAppId() + "]";
	}	

}
