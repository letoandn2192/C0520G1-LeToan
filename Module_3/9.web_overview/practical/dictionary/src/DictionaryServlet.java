import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "DictionaryServlet", urlPatterns = "/translate")
public class DictionaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new TreeMap<>();
        dictionary.put("hello", "xin chao");
        dictionary.put("beautiful", "xinh dep");
        dictionary.put("house", "ngoi nha");
        dictionary.put("dictionary", "tu dien");
        dictionary.put("laptop", "may tinh ca nhan");

        PrintWriter writer = response.getWriter();

        writer.println("<html>");

        String search = request.getParameter("search");
        String result = dictionary.get(search.toLowerCase());
        if (result != null) {
            writer.println(search + ": " + result);
        } else {
            writer.println("Not Found!!!");
        }

        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new TreeMap<>();
        dictionary.put("hello", "xin chao");
        dictionary.put("beautiful", "xinh dep");
        dictionary.put("house", "ngoi nha");
        dictionary.put("dictionary", "tu dien");
        dictionary.put("laptop", "may tinh ca nhan");

        PrintWriter writer = response.getWriter();

        writer.println("<html>");

        String search = request.getParameter("search");
        String result = dictionary.get(search.toLowerCase());
        if (result != null) {
            writer.println(search + ": " + result);
        } else {
            writer.println("Not Found!!!");
        }

        writer.println("</html>");
    }
}
