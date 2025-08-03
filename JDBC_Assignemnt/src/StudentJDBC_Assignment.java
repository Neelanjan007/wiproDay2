import myDButilities.DButilities;
import java.sql.*;
import java.util.Scanner;

public class StudentJDBC_Assignment {
    public static void main(String[] args) {
        try (Connection conn = DButilities.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            String insertQuery = "INSERT INTO student (id, name, age, course, marks) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);

            System.out.print("How many students do you want to insert? ");
            int count = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < count; i++) {
                System.out.println("\nEnter details for Student " + (i + 1) + ":");

                System.out.print("ID: ");
                int id = Integer.parseInt(scanner.nextLine());

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Age: ");
                int age = Integer.parseInt(scanner.nextLine());

                System.out.print("Course: ");
                String course = scanner.nextLine();

                System.out.print("Marks: ");
                double marks = Double.parseDouble(scanner.nextLine());

                pstmt.setInt(1, id);
                pstmt.setString(2, name);
                pstmt.setInt(3, age);
                pstmt.setString(4, course);
                pstmt.setDouble(5, marks);

                pstmt.executeUpdate();
            }

            System.out.println("\n✅ Data inserted successfully!");

          
            System.out.println("\nFetching all student records from database:\n");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("Marks: " + rs.getDouble("marks"));
                System.out.println("---------------");
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
