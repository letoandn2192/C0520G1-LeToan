package controller;

import bo.login_bo.LoginBO;
import bo.login_bo.LoginBOImpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private LoginBO loginBO = new LoginBOImpl();
    protected void processRequest (HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        HttpSession session =request.getSession();
        User user = loginBO.findUser(userName, password);
        if (user != null) {
            session.setAttribute("userName", userName);
            try {
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("error", "Id or Password incorrect!!!");
            try {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
