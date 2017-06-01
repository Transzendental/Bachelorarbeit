package de.accso.bpm.process;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;
import org.camunda.bpm.engine.CaseService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.variable.Variables;

@ProcessApplication("Loan Approval App")
public class LoanProcess extends ServletProcessApplication {

    @PostDeploy
    public void startCaseInstance(ProcessEngine processEngine) {
        CaseService caseService = processEngine.getCaseService();
        caseService.createCaseInstanceByKey("loanCase",
                Variables.createVariables()
                        .putValue("loanApproved ", Variables.booleanValue(null))
                        .putValue("schufaScore", Variables.integerValue(null)));
    }
}