package com.employee.service;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;

public class EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public boolean addEmployee(Employee employee) {

        if (employee.getSalary() <= 0) {
            return false;
        }

        return employeeDAO.addEmployee(employee);
    }

    public boolean updateEmployeeSalary(int employeeId, double newSalary) {
        if (employeeId <= 0 || newSalary <= 0) {
            return false;
        }

        return employeeDAO.updateEmployeeSalary(employeeId, newSalary);
    }

    public Employee getEmployeeById(int employeeId) {
        if(employeeId <= 0 ) {
            System.out.println("Invalid employee ID!");
            return null ;
        }
        return employeeDAO.getEmployeeById(employeeId);

    }

    public boolean deleteEmployee(int employeeId) {
        if (employeeId <= 0 ) {
            return false;
        }
        return employeeDAO.deleteEmployee(employeeId);
    }
}