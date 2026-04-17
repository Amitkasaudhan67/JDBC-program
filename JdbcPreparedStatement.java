package jdbcConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcPreparedStatement {
	public static void main(String args[])
	{
		try {
			// 1. load Driver.
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. create Connection 
			String url="jdbc:mysql://localhost:3306/jdbcpreparedstatement";
			String username="root";
			String password="Amit@7355";
		    Connection connection= DriverManager.getConnection(url,username,password);
		    
		    //3. create statement
		    //String query= "Create table Bank(id int primary Key, username varchar(10), pin int);";
		    //String query= "insert into Bank values(?,?,?);";
		    //String query="Delete from bank where id=?";
		    String query="select * from bank where id=?;";
		    PreparedStatement ps= connection.prepareStatement(query);
		    Scanner sc= new Scanner (System.in);
		    System.out.println("Enter bank id");
      	    ps.setInt(1,sc.nextInt());
		    sc.nextLine();
//		    System.out.println("Enter username");
//		    ps.setString(2,sc.nextLine());
//		    System.out.println("Enter pin");
//		    ps.setInt(3, sc.nextInt());
		   // sc.nextLine(); // to clear buffer.
		    
		    //4. execute query
		    
		    ResultSet result= ps.executeQuery();
		    while(result.next())
		    {
		    	//int id=result.getInt("id");
		    	String user = result.getString("username");
		    	int pin =result.getInt("pin");
		    //	System.out.println("User id: "+id);
		     System.out.println("User name: "+user);
		     System.out.println("User Pin: "+pin);
		    	
		    	
//		    	System.out.println("Deleted sucessfully");
//		    }
//		    else
//		    {
//		    	System.out.println("data already deleted inserted");
		    }
		     // output false because it not return any value this give only true for select 
		    } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
