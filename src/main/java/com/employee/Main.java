package com.employee;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("Oracle connected successfully!");

            EmployeeService employeeService = new EmployeeService() ;

            Employee employee = new Employee(301 , "Abdissamyi" , "SAMIR" , "abde4@gamil.com" , "AD_PRES" , 40000) ;

            employeeService.addEmployee(employee) ;
            Employee employee1 = employeeService.getEmployeeById(100);

            employeeService.updateEmployeeSalary(301 , 50000) ;
            employeeService.deleteEmployee(301) ;


        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }




    }
}