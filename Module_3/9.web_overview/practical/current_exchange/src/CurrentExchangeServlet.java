import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CurrentExchangeServlet", urlPatterns = "/convert")
public class CurrentExchangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float rate = Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<p>Rate: " + rate + "</p>");
        writer.println("<p> " + usd + "USD = " + (rate * usd) + " VND</p>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float rate = Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<p>Rate: " + rate + "</p>");
        writer.println("<p> " + usd + "USD = " + (rate * usd) + " VND</p>");
        writer.println("</html>");
    }
}
