import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sec {
    public Connection connection() throws SQLException {
        final String user = "root";
        final String pass = "";
        final String ada = "jdbc:mysql://localhost/bookshop";
        return  DriverManager.getConnection(ada, user, pass);
    }
}
