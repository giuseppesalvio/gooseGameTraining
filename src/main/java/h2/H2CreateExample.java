package h2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class H2CreateExample {

    private static final String createTableSQL =
            "create table users ( " +
                    "id  int(3) primary key, " +
                    "name varchar(20), " +
                    "email varchar(20), " +
                    "country varchar(20), " +
                    "password varchar(20) " +
                    ");";

    public static void execute() throws SQLException {
        H2CreateExample createTableExample = new H2CreateExample();
        createTableExample.createTable();
    }

    public void createTable() throws SQLException {

        System.out.println(createTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(createTableSQL);

        } catch (SQLException e) {
            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }
    }
}
