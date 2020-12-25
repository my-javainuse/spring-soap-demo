package com.example.spring.soap.api.endpoint;


import com.example.spring.soap.api.loaneligibility.Acknowledgement;
import com.example.spring.soap.api.loaneligibility.CustomerRequest;
import com.example.spring.soap.service.LoanEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoanAndEligibilityEndpoint {

    private static final String NAME_SPACE = "http://www.example.com/spring/soap/api/loanEligibility";

    @Autowired
    private LoanEligibilityService loanEligibilityService;

    @ResponsePayload
    @PayloadRoot(namespace = NAME_SPACE, localPart = "CustomerRequest")
    public Acknowledgement getAcknowledgement(@RequestPayload CustomerRequest customerRequest){
        return loanEligibilityService.getAcknowledgement(customerRequest);
    }
}
