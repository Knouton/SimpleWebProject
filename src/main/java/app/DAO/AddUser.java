package app.DAO;

import app.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddUser {
    public void addUser(User user) {
        String[] protectionFromSQLinjection = user.getName().split(" "); //Разделяем вводимую строку по пробелу для защиты от sql инъекции

        String SQLcommand = ("INSERT INTO users (Name) VALUES ('" + protectionFromSQLinjection[0] + "');");
        //("INSERT INTO users (Name, password) VALUES ('" + user.getName() + "' , '" + user.getPassword()+"');")
        try (Connection connection = CreateConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLcommand);
                ) {
            connection.setAutoCommit(false);
            statement.executeUpdate();
            connection.commit();
        } catch(SQLException e){
                e.printStackTrace();
        }
    }
}
