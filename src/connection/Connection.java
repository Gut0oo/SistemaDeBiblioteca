package connection;

import java.sql.DriverManager;

public class Connection {
    private static final String url = "jdbc:mysql://localhost:3306/database_test";
    private static final String user = "root";
    private static final String password = "Dev_gustavo123!";

    public static java.sql.Connection conn;

    public static java.sql.Connection getConnect() {
        try {
            // Carrega o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conecta ao banco
            return DriverManager.getConnection(
                    url,
                    user,
                    password
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
