package Session2.Task2EmployeeJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeptJDBC {
    private static final String url = "jdbc:mysql://localhost:3306/tjava06";
    private static final String username = "root";
    private static final String password = "tjava@123";
    int org_id;
    String dept_name;

    DeptJDBC(String name, int org_id) {
        this.dept_name = name;
        this.org_id = org_id;
    }

    public void addDept(String deptName, int org_id) {
        this.dept_name = deptName;
        this.org_id = org_id;

        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO department (name, org_id) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, dept_name);
            preparedStatement.setInt(2, org_id);
            int rowAffected = preparedStatement.executeUpdate();
            System.out.println(rowAffected + " row(s) affected.");
        } catch (SQLException e) {
            System.out.println("YOUR SERVER CONNECTION FAILED: " + e.getMessage());
        }
    }
}
