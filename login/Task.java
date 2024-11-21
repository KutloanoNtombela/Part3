/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

public class Task {

    private String taskName;
    private int taskID;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskStatus;

    public Task(String taskName, int taskID, String taskDescription, String developerDetails, int taskDuration, String taskIDString, String taskStatus) {
        this.taskName = taskName;
        this.taskID = taskID;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskID() {
        return "ID" + taskID;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getTaskStatus() {
        return taskStatus;
    }
}
