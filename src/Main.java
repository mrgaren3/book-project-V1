import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.SwingUtilities;
import java.util.Scanner;


public class Main {

    static Connection conn;
    static Statement statement;
    static String query ;
    static ResultSet resultSet;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new);

        //Scanner scanner = new Scanner(System.in);
        try {
//            System.out.println("enter your  title and author");
//            int id = scanner.nextInt();
//            String title = scanner.next();
//            String author = scanner.next();
            query = "Insert Table book ";
            conn= new sec().connection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.next();
            System.out.println(resultSet.getString("title"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally{
            try {
                statement.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}