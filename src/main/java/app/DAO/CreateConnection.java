package app.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//Создаём коннектор к базе данных
public class CreateConnection
{
    private static Connection connection = null;
    public static Connection getConnection() {
        {
            try {
                //Ввести данные своей базы
                String userName = "root";
                String password = "admin1";

                String url = "jdbc:mysql://localhost:3306/" +
                        "javaDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

                connection = DriverManager.getConnection(url, userName, password);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
                }
        } return connection;
    }
}
