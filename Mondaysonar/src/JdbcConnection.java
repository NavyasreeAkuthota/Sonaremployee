import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Logger;

public class JdbcConnection {

	static Scanner scan = new Scanner(System.in);
	Logger logger = Logger.getLogger(JdbcConnection.class.getName());
	Connection con;
	Statement st;

	JdbcConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iprimed", "root", "Navya@123");
			st = con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	JdbcConnection(String name, int age, String job, int sal) {
		this();
		try {
			st.executeUpdate("insert into employee(name, age, designation, salary) values('" + name + "'," + age + ",'" + job+ "'," + sal + ");");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void raiseSal() {
		new JdbcConnection();
		new Service(st);
	}

	public void display() {
		new JdbcConnection();
		new Service().display(st);
	}

	public void displayByDesignation() {
		new JdbcConnection();
		logger.info("SELECT THE DESIGNATION \n1.MANAGER \n2.PROGRAMMER \n3.CLERK");
		var desig = scan.nextInt();
		new Service().displayByDesignation(st, desig);

	}

	public void raiseById() {
		new JdbcConnection();
		logger.info("ENTER THE ID TO RAISE SALARY....");
		var id = scan.nextInt();
		new Service().raiseByID(id, st);

	}

	public void deleteEmployee() {
		new JdbcConnection();
		logger.info("ENTER THE ID TO DELETE RECORD OF EMPLOYEE..");
		var id = scan.nextInt();
		new Service().deleteById(st, id);

	}

}