package jdbcConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class batch {
    public static void main(String[] args) {

        try {
        	    //1.Driver load
        	    Class.forName("com.mysql.cj.jdbc.Driver");
        	    //2.create connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch", "root", "Amit@7355");
            //3. create statement
            Statement stmt = con.createStatement();
            Scanner sc=new Scanner(System.in);
            while(true)
            {
            System.out.println("Enter student id");
            int id=sc.nextInt();
            sc.nextLine();
            System.out.println("Enter student name");
            String name=sc.nextLine();
            System.out.println("Enter more data(Y/N): ");
            String choice=sc.next(); 
            String query=String.format("INSERT INTO student1 VALUES (%d,'%s')",id,name);
            stmt.addBatch(query);
            if(choice.toUpperCase().equals("N"))
            {
            	break;
            }
            }
//            stmt.addBatch("INSERT INTO employee VALUES (102, 'Rahul', 'Tester')");
//            stmt.addBatch("INSERT INTO employee VALUES (103, 'Sumit', 'Manager')");

            int[] result = stmt.executeBatch();

            for (int i : result) {
            	if(i==1)
            	{
            		System.out.println("Sucessfully added on index "+i);
            		
            	}
            	else
            	{
            		System.out.println("Sucessfully not added on index "+i);
            	}
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}