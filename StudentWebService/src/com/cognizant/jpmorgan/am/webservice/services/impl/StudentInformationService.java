package com.cognizant.jpmorgan.am.webservice.services.impl;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.cognizant.jpmorgan.am.webservice.model.request.GetStudentRequest;
import com.cognizant.jpmorgan.am.webservice.model.response.GetStudentResponse;

@WebService
public class StudentInformationService {
	
	@WebMethod(operationName="getStudentInformation")
	public GetStudentResponse getStudentInformation(GetStudentRequest studentRequest) {
		System.out.println("Incoming Request : " + studentRequest);
		GetStudentResponse studentResponse = new GetStudentResponse();
		//GetStudentResponse studentResponse1 =null;
		studentResponse.setAppId(studentRequest.getAppId());
		studentResponse.setRequestId(studentRequest.getRequestId());
		studentResponse.setRole(studentRequest.getRoleId());
		studentResponse.setRegistrationNo(studentRequest.getRegistrationNo());		
		studentResponse.setName("Tulika Pal");
		studentResponse.setSchoolName("UDDV Girls");
		studentResponse.setStandard("MA");
		return studentResponse;
	}
}
