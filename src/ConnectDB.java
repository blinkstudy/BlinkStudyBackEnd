import java.sql.*;

public class ConnectDB {

    private static ConnectDB instance = new ConnectDB();

    public static ConnectDB getInstance() {
        return instance;
    }

    public ConnectDB(){ }

    private String jdbcUrl="jdbc:mysql://databaseAddress"; // DB주소
    private String dbId = "id"; // DB id
    private String dbPw = "password"; // DB password
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private String query = "";
    String returns = "";

    public String loginDB(String id, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
            query = "SELECT id,pw FROM UserInfo WHERE id=? and pw?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

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
