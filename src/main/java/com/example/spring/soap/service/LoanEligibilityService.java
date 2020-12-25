package com.example.spring.soap.service;

import com.example.spring.soap.api.loaneligibility.Acknowledgement;
import com.example.spring.soap.api.loaneligibility.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanEligibilityService {


    public Acknowledgement getAcknowledgement(CustomerRequest customerRequest){
        Acknowledgement acknowledgement = new Acknowledgement();
        List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();

        if(!(customerRequest.getAge() > 30 && customerRequest.getAge() <= 60)){
            mismatchCriteriaList.add("Person age should in between 30 to 60");
        }
        if(!(customerRequest.getCibilScore() > 500)){
            mismatchCriteriaList.add("Low CIBIL score please try after 6 months");
        }
        if(!(customerRequest.getYearlyIncome() > 200000)){
            mismatchCriteriaList.add("Minimum income should be more than 200000");
        }

        if(!mismatchCriteriaList.isEmpty()){
            acknowledgement.setApprovedAmount(0);
            acknowledgement.setIsEligible(false);
        }else {
            acknowledgement.setApprovedAmount(500000);
            acknowledgement.setIsEligible(true);
        }
        return acknowledgement;
    }
}
