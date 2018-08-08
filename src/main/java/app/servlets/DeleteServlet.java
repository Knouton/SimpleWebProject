package app.servlets;

import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet{
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/delete.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Model model = Model.getInstance();
        for (String s: model.list()
             ) {
            if (s.equals(name)){
                model.remove(name);

                req.setAttribute("userName", name);
                doGet(req, resp);
            }
        }
        req.setAttribute("userNameNotFound", name);
        doGet(req, resp);
    }
}
