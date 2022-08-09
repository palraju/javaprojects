package com.cognizant.jpmorgan.am.webservice.model.common;

public class WebServiceBaseRequest extends WebServiceBaseTO {

	private String invokerSid;
	private String invokingMethod;

	public String getInvokerSid() {
		return invokerSid;
	}

	public void setInvokerSid(String invokerSid) {
		this.invokerSid = invokerSid;
	}

	public String getInvokingMethod() {
		return invokingMethod;
	}

	public void setInvokingMethod(String invokingMethod) {
		this.invokingMethod = invokingMethod;
	}
}
