package app.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUser {
    public void deleteUser(String userName) {

        try (Connection connection = CreateConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE Name = '" + userName +"'");
                ){

            connection.setAutoCommit(false);

            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
