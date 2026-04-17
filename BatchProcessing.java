package jdbcConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BatchProcessing {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/batchprocessing";
        String username = "root";
        String password = "Amit@7355";

        String query = "INSERT INTO employee VALUES (?, ?, ?, ?)";

        try (
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(query);
            Scanner sc = new Scanner(System.in)
        ) {

            // Disable auto-commit (for transaction)
            con.setAutoCommit(false);

            while (true) {
                System.out.print("Enter employee id: ");
                int id = sc.nextInt();
                sc.nextLine(); // clear buffer

                System.out.print("Enter employee name: ");
                String name = sc.nextLine();

                System.out.print("Enter employee job: ");
                String job = sc.nextLine();

                System.out.print("Enter employee salary: ");
                double sal = sc.nextDouble();

                // Set values
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, job);
                ps.setDouble(4, sal);

                // Add to batch
                ps.addBatch();

                System.out.print("Do you want to add more records (Y/N): ");
                String choice = sc.next();

                if (choice.equalsIgnoreCase("N")) {
                    break;
                }
            }

            // Execute batch
            int[] result = ps.executeBatch();

            // Commit transaction
            con.commit();

            // Display result
            System.out.println("\nBatch Execution Result:");
            for (int i = 0; i < result.length; i++) {
                if (result[i] == 1) {
                    System.out.println("Record " + (i + 1) + " inserted successfully");
                } else {
                    System.out.println("Record " + (i + 1) + " failed");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}