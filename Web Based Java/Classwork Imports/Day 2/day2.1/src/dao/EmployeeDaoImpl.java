package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.fetchConnection;

import pojos.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {
	// state
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3;

	// constr : invoked by the upper layer(Tester)
	public EmployeeDaoImpl() throws ClassNotFoundException, SQLException {
		// get cn from DBUtils
		cn = fetchConnection();
		// create pre-parsed n pre compiled stmt : for dynamic n repetative queries
		pst1 = cn.prepareStatement("select * from my_emp where deptid=? and join_date > ?");
		pst2=cn.prepareStatement("insert into my_emp values(default,?,?,?,?,?)");
		pst3=cn.prepareStatement("update my_emp set salary=salary+? where empid=?");
		System.out.println("emp dao created...");
	}

	@Override
	public List<Employee> fetchEmpDetails(String deptId, Date joinDate) throws SQLException {
		// create empty AL
		List<Employee> emps = new ArrayList<>();
		// set IN params
		pst1.setString(1, deptId);
		pst1.setDate(2, joinDate);
		try (ResultSet rst = pst1.executeQuery()) {
			// rst cursor : before the 1st row
			// int empId, String name, String address, double salary, String deptId, Date
			// joinDate
			while (rst.next())
				emps.add(new Employee(rst.getInt(1), rst.getString(2), rst.getString(3),
						rst.getDouble(4), deptId,
						rst.getDate(6)));
		}
		return emps;//dao layer rets --list of emps ---> tester
	}

	//add CRUD type methdo for inserting emp details
	@Override
	public String addEmpDetails(Employee e) throws SQLException {
		String mesg="Inserting emp details failed!!!!!";
		// set IN params
		////empid | name    | addr    | salary | deptid | join_date
		pst2.setString(1,e.getName());//set nm
		pst2.setString(2, e.getAddress());
		pst2.setDouble(3, e.getSalary());
		pst2.setString(4, e.getDeptId());
		pst2.setDate(5,e.getJoinDate());
		int updateCount = pst2.executeUpdate();// rets no of rows updated/ins/deleted
		if(updateCount == 1)
			mesg="Inserting emp details succeeded!!!!";
		return mesg;
	}
	
	
	//salary updation
	@Override
	public String updateEmpSalary(int empId, double salIncrement) throws SQLException {
		String mesg="Updating emp details failed!!!!!";
		// set IN params
		pst3.setDouble(1, salIncrement);
		pst3.setInt(2, empId);
		//exec : execUpdate : DML
		int updateCount=pst3.executeUpdate();
		
		if(updateCount == 1)
			mesg="Updating emp details succeeded!!!!";
		return mesg;
	}

	// add clean up method for releasing db related resources
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		System.out.println("emp dao cleaned up...");
	}

	

}
