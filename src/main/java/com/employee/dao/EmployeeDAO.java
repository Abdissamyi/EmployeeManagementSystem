package com.employee.dao;

import com.employee.DBConnection;
import com.employee.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

    public void getAllEmployees() {

        String sql = """
                SELECT employee_id, first_name, last_name, salary
                FROM HR.employees
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("employee_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                double salary = rs.getDouble("salary");

                System.out.println(
                        id + " | " + firstName + " " +
                                lastName + " | " + salary
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public Employee getEmployeeById(int employeeId) {

        String sql = """
        SELECT employee_id, first_name, last_name,
               email, job_id, salary
        FROM HR.employees
        WHERE employee_id = ?
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, employeeId);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {

                    return new Employee(
                            rs.getInt("employee_id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("job_id"),
                            rs.getDouble("salary")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }





    public boolean addEmployee(Employee employee) {

        String sql = """
        INSERT INTO HR.employees
        (employee_id, first_name, last_name,
         email, hire_date, job_id, salary)
        VALUES (?, ?, ?, ?, SYSDATE, ?, ?)
        """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, employee.getEmployeeId());
            pstmt.setString(2, employee.getFirstName());
            pstmt.setString(3, employee.getLastName());
            pstmt.setString(4, employee.getEmail());
            pstmt.setString(5, employee.getJobId());
            pstmt.setDouble(6, employee.getSalary());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    public boolean updateEmployeeSalary(int employeeId, double newSalary) {
        String sql = "UPDATE HR.employees SET salary = ? WHERE employee_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, newSalary);
            pstmt.setInt(2, employeeId);

            return pstmt.executeUpdate() > 0 ;

        } catch (SQLException e) {
            e.printStackTrace();
            return false ;
        }


    }


    public boolean deleteEmployee(int employeeId) {

        String sql = "DELETE FROM HR.employees WHERE employee_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, employeeId);

            return pstmt.executeUpdate() > 0;


        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
            return  false ;
        }
    }




}
