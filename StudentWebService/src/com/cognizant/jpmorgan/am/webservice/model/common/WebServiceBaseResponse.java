package com.cognizant.jpmorgan.am.webservice.model.common;

import java.util.List;

import com.cognizant.jpmorgan.am.webservice.model.error.ErrorTO;

public class WebServiceBaseResponse extends WebServiceBaseTO {
	private List<ErrorTO> responseErrors;

	public List<ErrorTO> getResponseErrors() {
		return responseErrors;
	}

	public void setResponseErrors(List<ErrorTO> responseErrors) {
		this.responseErrors = responseErrors;
	}

}
