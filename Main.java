package jdbcConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	private static final String url="jdbc:mysql://localhost:3306/studentjdbc";
	private static final String username="root";
	private static final String password="Amit@7355";
	
	public static void main(String args[])
	{
		// 1.load driver.
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());		
		}
		try 
		{
			// 2. create Connection
			Connection connection =DriverManager.getConnection(url,username,password);
			
			//3. Create statement
			
			Statement statement= connection.createStatement();
			//4. execute a statement and process a result
			
			
			
			//a) to perform dml operation(insert ,delete,update);
//			String query="insert into student values(103,'Ankit','bsc.ag')";
//			
//			int resultset= statement.executeUpdate(query);
//			
//			if(resultset>0)
//			{
//				System.out.print("1 rows inserted in table");
//				System.out.print(resultset);
//			}
//			else
//			{
//				System.out.print("no rows affected");
//			}
//			
			//b)this statement only for fetch or retrive data
		     //String query="select * from student;";
//			ResultSet resultset=statement.executeQuery(query);
//			System.out.println(resultset);
//			while(resultset.next())
//			{
//				int id=resultset.getInt("St_id");
//				String Sname=resultset.getString("Sname");
//				String course=resultset.getString("Course");
//				
//				System.out.println("St_Id: "+id);
//				System.out.println("Student Name: "+id);
//				System.out.println("Course: "+id);
//				
//			}
			// if you want to execute any sql queries than use execute()
			
//			String query="insert into student values(104,'sumit','vlsi');";
//			boolean result=statement.execute(query);
//            System.out.println(result);   // false because it doses not return any thing only rows affected.
			String query1= "select * from student";
			boolean result1= statement.execute(query1);
			System.out.println(result1); // it return value so  it return true
			
			
			
			
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());	
		}
		
		
	}

}
