import employee.Employee;
import sun.plugin.com.Dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet",urlPatterns = "/test")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee_1 = new Employee("Mai Văn Hoàn", "20-08-1990", "Hà Nội", "avatar1.png");
        Employee employee_2 = new Employee("Nguyễn Thái Hòa", "17-10-1983", "Đà Nẵng", "avatar2.png");
        Employee employee_3 = new Employee("Trần Đăng Khoa", "30-01-2010", "Vũng Tàu", "avatar3.png");
        Employee employee_4 = new Employee("Nguyễn Đình Thi", "08-03-1993", "Kiên Giang", "avatar4.jpg");
        Employee employee_5 = new Employee("Huấn Hoa Hồng", "24-09-1998", "Thái Bình", "avatar5.png");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee_1);
        employeeList.add(employee_2);
        employeeList.add(employee_3);
        employeeList.add(employee_4);
        employeeList.add(employee_5);
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("index.jsp").forward(request,response);


    }
}
