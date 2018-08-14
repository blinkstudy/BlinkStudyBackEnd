package DataControl;
import java.sql.*;

public class ConnectDB {

    private static ConnectDB instance = new ConnectDB();

    public static ConnectDB getInstance() {
        return instance;
    }

    public ConnectDB(){ }

    private String jdbcUrl="jdbc:mysql://localhost:3306/BlinkStudy"; // DB주소
    private String dbId = "root"; // DB id
    private String dbPw = "sda1628sda"; // DB password
    private Connection connection = null;
    String returns = "";

    public String loginDB(String id, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, dbId, dbPw);

        } catch (Exception e) {

        } finally {
            if(connection != null) try { connection.close(); } catch (SQLException e){ }
        }
        return returns;
    }
}
