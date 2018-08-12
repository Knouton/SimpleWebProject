package app.DAO;

import app.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddUser {
    public void addUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = CreateConnection.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement
                    ("INSERT INTO users (Name) VALUES ('" + user.getName() + "');");
            //("INSERT INTO users (Name, password) VALUES ('" + user.getName() + "' , '" + user.getPassword()+"');")

                statement.executeUpdate();
                connection.commit();
            } catch(SQLException e){
                e.printStackTrace();
            } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        }
    }
