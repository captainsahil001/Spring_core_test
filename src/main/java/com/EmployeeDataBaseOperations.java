package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDataBaseOperations {

	@Autowired
	DataBaseConnections db;

	@Autowired
	Scanner sc;

	public void insertEmployeeDetails() {

		try {

			Connection con = db.mysqlDbConnections();
			System.out.println("Connection Established");

			Statement stmt = con.createStatement();

			String query = "CREATE TABLE IF NOT EXISTS employee (" + "id INT AUTO_INCREMENT PRIMARY KEY, "
					+ "name VARCHAR(50), " + "salary DOUBLE, " + "deptno INT" + ")";

			stmt.executeUpdate(query);

			System.out.println("Employee Table Created Successfully");

			System.out.println("Enter Employee Name");
			String name = sc.next();
			System.out.println("Enter Employee Salary");
			double salary = sc.nextDouble();
			System.out.println("Enter dept no");
			int deptno = sc.nextInt();

			String query1 = "INSERT INTO employee(name, salary, deptno) VALUES(?,?,?)";

			PreparedStatement ps = con.prepareStatement(query1);

			ps.setString(1, name);
			ps.setDouble(2, salary);
			ps.setInt(3, deptno);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Employee Inserted Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getAllEmployeeDetails() {
		try {
			Connection con = db.mysqlDbConnections();
			System.out.println("Connection Established");
			String query2 = "SELECT * FROM employeedb.employee";

			PreparedStatement ps = con.prepareStatement(query2);

			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				System.out.print("\nEmployee Name:- " + resultSet.getString("name"));
				System.out.print("\nEmployee Mobile No.:- " + resultSet.getDouble("salary"));
				System.out.println("\nEmployee Dept No.:- " + resultSet.getInt("deptno"));
				System.out.print("\t****************************-------------------------**************************");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getEmployeeUsingId(int id) {
    	try {
    	Connection con = db.mysqlDbConnections();
    	String select = "SELECT * FROM employeedb.employee WHERE id=?";
    	PreparedStatement ps = con.prepareStatement(select);
    	ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();
		if(resultSet.next()) {
			System.out.print("\nEmployee Id:- " +resultSet.getInt("id"));
			System.out.print("\nEmployee Name:- " +resultSet.getString("name"));
			System.out.print("\nEmployee Mobile No.:- " +resultSet.getDouble("salary"));
			System.out.println("\nEmployee Dept No.:- " +resultSet.getInt("deptno"));
			System.out.print("\t****************************-------------------------**************************");
		}else {
			System.out.println("No data found");
		}
		
    	}catch(Exception e){
			e.printStackTrace();
		}
    	
    	
    }

	public void UpdateSalaryUsingDeptNo(double salary, int deptno) {
		try {

	        Connection con = db.mysqlDbConnections();

	        String update = "UPDATE employeedb.employee SET salary=? WHERE deptno=?";

	        PreparedStatement ps = con.prepareStatement(update);

	        ps.setDouble(1, salary);
	        ps.setInt(2, deptno);

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Salary Updated Successfully for " + rows + " employee(s)");
	        } else {
	            System.out.println("No employees found in this department");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void DeleteDetailsOfEmployeeUsingId(int id) {
		try {

	        Connection con = db.mysqlDbConnections();

	        String delete = "DELETE FROM employee WHERE id=?";

	        PreparedStatement ps = con.prepareStatement(delete);

	        ps.setInt(1, id);

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Employee Deleted Successfully");
	        } else {
	            System.out.println("Employee not found");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	}
}