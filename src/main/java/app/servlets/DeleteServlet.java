package app.servlets;

import app.DAO.DeleteUser;
import app.DAO.UserListDAO;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DeleteServlet extends HttpServlet{
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/delete.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        UserListDAO userListDAO = new UserListDAO();
        List<String> names = null;
        try {
            names = userListDAO.list();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        for (String s: names
             ) {
            if (s.equals(name)){
                DeleteUser deleteUser = new DeleteUser();
                deleteUser.deleteUser(name);

                req.setAttribute("userName", name);
                doGet(req, resp);
            }
        }
        req.setAttribute("userNameNotFound", name);
        doGet(req, resp);
    }
}
