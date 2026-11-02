
package com.employee.model;

public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String jobId;
    private double salary;

    public Employee(int employeeId, String firstName,
                    String lastName, String email,
                    String jobId, double salary) {

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.jobId = jobId;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getJobId() {
        return jobId;
    }

    public double getSalary() {
        return salary;
    }
}
