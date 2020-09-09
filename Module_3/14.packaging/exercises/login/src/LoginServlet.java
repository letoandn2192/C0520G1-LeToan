import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginController")
public class LoginServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            // tao Session
            HttpSession session = request.getSession();
            if (username.equals("admin") && password.equals("admin")) {
                // luu vao session
                session.setAttribute("username", "admin");

                // tao Cookie lay thong tin cua nguoi dung de nho lai
                Cookie user = new Cookie("user", "admin");
                Cookie pass = new Cookie("pass", "admin");
                if (request.getParameter("chkRemember") != null) {
                    user.setMaxAge(60 * 60 * 24);
                    pass.setMaxAge(60 * 60 * 24);
                } else {
                    user.setMaxAge(0);
                    pass.setMaxAge(0);
                }
                response.addCookie(user);
                response.addCookie(pass);
                RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
                dis.forward(request, response);
            } else {
                request.setAttribute("error", "Username and Password invalid !");
                RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
                dis.forward(request, response);
            }

        } finally {
            out.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        processRequest(request, response);
    }
}
