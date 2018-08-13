package app.DAO;

import app.entities.User;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//вывод списка Name из базы данных users
public class UserListDAO {
    public UserListDAO() {

    }
    public List<String> list() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        /*String userName = "root";
        String password = "admin1";

        String url = "jdbc:mysql://localhost:3306/" +
                "javaDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.jdbc.Driver").newInstance();*/
        List<String> usersList = new ArrayList<>();

        try (Connection connection = CreateConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT Name FROM users");
            ResultSet resultSet = statement.executeQuery();
            ) {
            connection.setAutoCommit(false);
            connection.commit();

            while (resultSet.next()) {
                usersList.add(resultSet.getString("Name"));
            }
        }
        return usersList;

    }
    /*private MysqlDataSource dataSource;
    List<User> usersList;
    public UserListDAO(MysqlDataSource dataSource) {
        this.dataSource = dataSource;
        dataSource.setUser("root");
        dataSource.setPassword("admin1");
        dataSource.setServerName("javaDB");
        dataSource.setPort(3306);
    }
    public List<String> list() throws SQLException {
        usersList = new ArrayList<>();

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT Name, password FROM users");
                ResultSet resultSet = statement.executeQuery();
                ){
            while(resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("Name"));
                user.setPassword(resultSet.getString("password"));
                usersList.add(user);
            }
        }

        return usersList.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }*/
}
