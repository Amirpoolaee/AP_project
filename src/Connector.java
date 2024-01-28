import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
    static Connection connection;
    static Connection connect() throws ClassNotFoundException, SQLException{
         String databaseName = "hotel";
         String url = "jdbc:mysql://localhost:3306/" + databaseName;
         String username = "root";
         String password = "401302";
        connection= DriverManager.getConnection(url,username,password);
        return connection;
    }
    static Statement statement(){
        Statement statement=null;
        try {
            statement=connect().createStatement();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return statement;
    }
    static void close_connection()throws SQLException{
        connection.close();
    }
}
