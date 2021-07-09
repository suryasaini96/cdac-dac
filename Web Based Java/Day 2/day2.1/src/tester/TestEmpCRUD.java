package tester;

import java.sql.Date;
import java.util.Scanner;

import dao.EmployeeDaoImpl;
import pojos.Employee;

import static utils.DBUtils.closeConnection;

public class TestEmpCRUD {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			// init DAO layer : create instance of dao layer
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			while (!exit) {
				System.out.println("Options 1 . Display emp details  2. Add Emp Details 3. Update Salary 100.Exit");
				try {
					switch (sc.nextInt()) {
					case 1:// Display emp details , from a specific dept , joined after a particular date
						System.out.println("Enter dept id n join date(yr-mon-day)");
						System.out.println("Emp list");
						dao.fetchEmpDetails(sc.next(), Date.valueOf(sc.next())).forEach(System.out::println);

						break;
					case 2: // add emp details
						System.out
								.println("Enter emp details : name,  address,  salary,  deptId,  joinDate(yr-mon-day)");
						System.out.println("Status mesg " + dao.addEmpDetails(new Employee(sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), Date.valueOf(sc.next()))));
						break;
					case 3:
						System.out.println("Enter emp id n sal increment");
						System.out.println("Status mesg " + dao.updateEmpSalary(sc.nextInt(), sc.nextDouble()));
						break;

					case 100:
						exit = true;
						dao.cleanUp();
						closeConnection();
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				sc.nextLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
