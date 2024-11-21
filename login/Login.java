/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.login;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Login {

    private String registeredUsername;
    private String registeredPassword;
    private String firstName;
    private String lastName;
    private ArrayList<Task> tasks = new ArrayList<>();
    private int totalHours = 0;
    
    private String[] developers = new String[4];
    private String[] taskNames = new String[4];
    private String[] taskIDs = new String[4];
    private int[] taskDurations = new int[4];
    private String[] taskStatuses = new String[4];

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) return false;

        boolean hasUpperCase = false, hasNumber = false, hasSpecialChar = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpperCase = true;
            else if (Character.isDigit(ch)) hasNumber = true;
            else if (!Character.isLetterOrDigit(ch)) hasSpecialChar = true;
        }
        return hasUpperCase && hasNumber && hasSpecialChar;
    }

    public String registerUser(String username, String password, String firstName, String lastName) {
        if (checkUserName(username) && checkPasswordComplexity(password)) {
            this.registeredUsername = username;
            this.registeredPassword = password;
            this.firstName = firstName;
            this.lastName = lastName;
            return "Username and password successfully captured.";
        } else {
            if (!checkUserName(username)) {
                return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than 5 characters.";
            }
            if (!checkPasswordComplexity(password)) {
                return "Password is not correctly formatted; it must contain at least 8 characters, a capital letter, a number, and a special character.";
            }
            return "Registration failed due to incorrect username or password format.";
        }
    }

    public boolean loginUser(String username, String password) {
        return username.equals(registeredUsername) && password.equals(registeredPassword);
    }

    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    public void addTasks() {
        int numTasks = 4;
        Task[] testData = {
            new Task("Create Login", 0, "Create Login functionality", "Mike Smith", 5, "1:0:SMI", "To Do"),
            new Task("Create Add Features", 1, "Add features to the app", "Edward Harrison", 8, "1:1:EDH", "Doing"),
            new Task("Create Reports", 2, "Generate reports for the app", "Samantha Paulson", 2, "1:2:SPA", "Done"),
            new Task("Add Arrays", 3, "Add array functionalities", "Glenda Oberholzer", 11, "1:3:GLO", "To Do")
        };
        
        for (int i = 0; i < numTasks; i++) {
            Task task = testData[i];
            developers[i] = task.getDeveloperDetails();
            taskNames[i] = task.getTaskName();
            taskIDs[i] = task.getTaskID();
            taskDurations[i] = task.getTaskDuration();
            taskStatuses[i] = task.getTaskStatus();
            tasks.add(task);
            totalHours += task.getTaskDuration();
        }

        JOptionPane.showMessageDialog(null, "Total task hours: " + totalHours, "Total Hours", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayDoneTasks() {
        for (int i = 0; i < taskStatuses.length; i++) {
            if (taskStatuses[i].equals("Done")) {
                JOptionPane.showMessageDialog(null, "Developer: " + developers[i] + 
                        "\nTask Name: " + taskNames[i] + 
                        "\nTask Duration: " + taskDurations[i], "Done Task", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void displayLongestTask() {
        int maxDurationIndex = 0;
        for (int i = 1; i < taskDurations.length; i++) {
            if (taskDurations[i] > taskDurations[maxDurationIndex]) {
                maxDurationIndex = i;
            }
        }
        JOptionPane.showMessageDialog(null, "Developer: " + developers[maxDurationIndex] + 
                "\nTask Duration: " + taskDurations[maxDurationIndex], "Longest Task", JOptionPane.INFORMATION_MESSAGE);
    }

    public void searchTaskByName(String taskName) {
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i].equalsIgnoreCase(taskName)) {
                JOptionPane.showMessageDialog(null, "Task Name: " + taskNames[i] + 
                        "\nDeveloper: " + developers[i] + 
                        "\nTask Status: " + taskStatuses[i], "Task Search", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void searchTasksByDeveloper(String developer) {
        for (int i = 0; i < developers.length; i++) {
            if (developers[i].equalsIgnoreCase(developer)) {
                JOptionPane.showMessageDialog(null, "Task Name: " + taskNames[i] + 
                        "\nTask Status: " + taskStatuses[i], "Developer Tasks", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void deleteTaskByName(String taskName) {
        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i].equalsIgnoreCase(taskName)) {
                for (int j = i; j < taskNames.length - 1; j++) {
                    taskNames[j] = taskNames[j + 1];
                    developers[j] = developers[j + 1];
                    taskIDs[j] = taskIDs[j + 1];
                    taskDurations[j] = taskDurations[j + 1];
                    taskStatuses[j] = taskStatuses[j + 1];
                }
                JOptionPane.showMessageDialog(null, "Entry \"" + taskName + "\" successfully deleted", "Task Deletion", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Task not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void displayReport() {
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < taskNames.length; i++) {
            report.append("Task Name: ").append(taskNames[i])
                  .append("\nDeveloper: ").append(developers[i])
                  .append("\nTask ID: ").append(taskIDs[i])
                  .append("\nTask Duration: ").append(taskDurations[i])
                  .append("\nTask Status: ").append(taskStatuses[i])
                  .append("\n\n");
        }
        JOptionPane.showMessageDialog(null, report.toString(), "Full Task Report", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        Login login = new Login();

        String firstName = JOptionPane.showInputDialog("Enter first name:");
        String lastName = JOptionPane.showInputDialog("Enter last name:");
        String username = JOptionPane.showInputDialog("Enter username (must contain an underscore and be no more than 5 characters):");
        String password = JOptionPane.showInputDialog("Enter password (must be at least 8 characters, contain a capital letter, a number, and a special character):");

        String registrationResult = login.registerUser(username, password, firstName, lastName);
        JOptionPane.showMessageDialog(null, registrationResult);

        if (registrationResult.equals("Username and password successfully captured.")) {
            String loginUsername = JOptionPane.showInputDialog("Enter username:");
            String loginPassword = JOptionPane.showInputDialog("Enter password:");
            JOptionPane.showMessageDialog(null, login.returnLoginStatus(loginUsername, loginPassword));

            if (login.loginUser(loginUsername, loginPassword)) {
                boolean exit = false;
                login.addTasks();

                while (!exit) {
                    String option = JOptionPane.showInputDialog("Select an option:\n1. Display Done Tasks\n2. Display Longest Task\n3. Search Task by Name\n4. Search Tasks by Developer\n5. Delete Task by Name\n6. Display Full Report\n7. Exit");
                    switch (option) {
                        case "1":
                            login.displayDoneTasks();
                            break;
                        case "2":
                            login.displayLongestTask();
                            break;
                        case "3":
                            String taskName = JOptionPane.showInputDialog("Enter task name to search:");
                            login.searchTaskByName(taskName);
                            break;
                        case "4":
                            String developer = JOptionPane.showInputDialog("Enter developer name to search tasks:");
                            login.searchTasksByDeveloper(developer);
                            break;
                        case "5":
                            String taskToDelete = JOptionPane.showInputDialog("Enter task name to delete:");
                            login.deleteTaskByName(taskToDelete);
                            break;
                        case "6":
                            login.displayReport();
                            break;
                        case "7":
                            exit = true;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid option.", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                }
            }
        }
    }
}
