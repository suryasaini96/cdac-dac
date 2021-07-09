package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import pojos.Employee;

public interface IEmployeeDao {
//Display emp details , from a specific dept , joined after a particular  date
	List<Employee> fetchEmpDetails(String deptId,Date joinDate) throws SQLException;
	//Add emp details
	String addEmpDetails(Employee e) throws SQLException;
	//update salary
	String updateEmpSalary(int empId,double salIncrement)throws SQLException;
}
