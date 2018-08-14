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

            if(resultSet.next()) {
                if(resultSet.getString("ID").equals(id)
                        && resultSet.getString("password").equals(password)) {
                    returns = "success";
                } else {
                    returns = "fail";
                }
            } else {
                returns = "noId";
            }

        } catch (Exception e) {

        } finally {
            if(resultSet != null) try { resultSet.close(); } catch (SQLException e){ }
            if(preparedStatement != null) try { preparedStatement.close(); } catch (SQLException e){ }
            if(connection != null) try { connection.close(); } catch (SQLException e){ }
        }
        return returns;
    }
}
