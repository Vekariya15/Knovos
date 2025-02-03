package Session2.Task2EmployeeJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrgJDBC {
    private static final String url = "jdbc:mysql://localhost:3306/tjava06";
    private static final String username = "root";
    private static final String password = "tjava@123";
    String org_name;

    OrgJDBC(String name) {
        this.org_name = name;
    }

    public void addOrg(String name) {
        this.org_name = name;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO Organization (name) VALUES (?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, this.org_name);
            int rowAffected = preparedStatement.executeUpdate();
            System.out.println(rowAffected + " row(s) affected.");
        } catch (SQLException e) {
            System.out.println("YOUR SERVER CONNECTION FAILED: " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }
}
