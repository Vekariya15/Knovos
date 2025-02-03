package Session2.Task2EmployeeJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeJDBC {
    private static final String url = "jdbc:mysql://localhost:3306/tjava06";
    private static final String username = "root";
    private static final String password = "tjava@123";
    String E_name;
    int dept_id;
    int org_id;

    EmployeeJDBC(String e_name, int dept_id, int org_id) {
        this.E_name = e_name;
        this.dept_id = dept_id;
        this.org_id = org_id;
    }

    public void addEmployee(EmployeeJDBC employee) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);           // connection build to database
            String query = "INSERT INTO employee (name, dept_id, org_id) VALUES (?, ?, ?)";   // data add into sql table
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employee.E_name);
            preparedStatement.setInt(2, employee.dept_id);
            preparedStatement.setInt(3, employee.org_id);
            int rowAffected = preparedStatement.executeUpdate();
            System.out.println(rowAffected + " row(s) affected.");
        } catch (SQLException e) {
            System.out.println("YOUR SERVER CONNECTION FAILED: " + e.getMessage());
        }
    }

    public static void countEmployeeByOrgId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter organization id: ");
        int orgId = sc.nextInt();
        String query = "SELECT COUNT(id) AS count FROM employee WHERE org_id= ?";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, orgId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Employee count by organization ID: " + resultSet.getString("count"));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void countEmployeeByDeptId() {          // employ count by
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter department id: ");
        int deptId = sc.nextInt();

        String query = "SELECT CASE WHEN EXISTS (SELECT 1 FROM department WHERE id = ?) " +
                "THEN (SELECT COUNT(id) FROM employee WHERE id = ?) " +
                "ELSE -1 END AS count";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, deptId);
            preparedStatement.setInt(2, deptId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                if (count == -1) {
                    System.out.println("Warning: Department ID " + deptId + " does not exist.");
                } else {
                    System.out.println("Employee count by department ID: " + count);
                }
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
