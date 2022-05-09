package jdbcnew;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://127.0.0.1:3306/employees_database" ;
		int rowsAffected;
		try {
			//Establish connection object
			Connection conn = DriverManager.getConnection(url,"root","123456");
			
			//create a statement object to send to the database
			
			Statement statement = conn.createStatement();
			
			/** 
			 * For selecting a specific colum from table
			 * 
			 * */
			
			//Execute the statement object
			
			ResultSet resultSet = statement.executeQuery("select * from employees_tbl");
			
			//process the result
			int salary = 0;
			while(resultSet.next()) {
				salary = salary +resultSet.getInt("salary") ;
			}
			System.out.println(salary);
			
			
			/** for inserting into the table
			 * below is followed
			 * 
			 * we use execute update for doing this query'
			 * if we execute the below code twice it throws error bcz
			 * the id is primary key and it can't be duplicate
			 */
			rowsAffected = statement.executeUpdate("insert into employees_tbl (id,name,dept,salary)"
					+ "values (902,'ram','SED',5500) ");
			
			System.out.println("Executed insert statement - Rows Affected: "+ rowsAffected);
			
			/**
			 * for deleting all rows
			 * we use the command "DELETE from employee_tbl"
			 * in the executeUpdate
			 */
			
			/**
			 * for updating the salary of a employee
			 */
			rowsAffected = statement.executeUpdate("UPDATE employees_tbl SET salary = 5900 where id=700; ");
			
			System.out.println("Executed insert statement - Rows Affected: "+ rowsAffected);
			
			/**
			 * we have to observe that we are just inserting sel commands
			 * in the executeUpdate or etc
			 */
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
