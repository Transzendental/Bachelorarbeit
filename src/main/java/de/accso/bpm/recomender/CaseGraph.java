package de.accso.bpm.recomender;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.model.cmmn.instance.Case;
import org.camunda.bpm.model.cmmn.instance.Task;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CaseGraph {

    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    Case thisCase;

    private Task currentTask;
    private Task[] possibleTasks;
    private List<Task> executedTasks = new LinkedList<Task>();

    public void addTasks(Object[] tasks){
        possibleTasks = (Task[])tasks;
    }

    public void transistTask(Task task){
        currentTask = task;
    }

    public Task[] getTasks(){
        Arrays.sort(possibleTasks);
        return possibleTasks;
    }

    public void exeuteTask(Task task){
        executedTasks.add(currentTask);
        currentTask = task;
        updateGraph();
    }

    private void updateGraph(){
        List<Task> foo = processEngine.getCaseService().createCaseExecutionQuery().active().available().enabled().list;
    }
}
