import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Float.parseFloat(request.getParameter("first_operand"));
        float secondOperand = Float.parseFloat(request.getParameter("second_operand"));
        String operator = request.getParameter("operator");

        try {
            float result = Calculator.calculate(operator, firstOperand, secondOperand);
            request.setAttribute("result", result);

        } catch (Exception e) {
            String result = e.getMessage();
            request.setAttribute("result", result);
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
