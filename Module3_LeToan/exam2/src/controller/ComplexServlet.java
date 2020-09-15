package controller;

import bo.complex_bo.ComplexBO;
import bo.complex_bo.ComplexBOImpl;
import model.Complex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ComplexServlet", urlPatterns = "/complex")
public class ComplexServlet extends HttpServlet {
    private ComplexBO complexBO = new ComplexBOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "edit":
//                editProductInfo(request, response);
//                break;
            case "delete":
//                deleteComplex(request, response);
                break;
            case "create":
                createComplex(request, response);
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
//                showComplexDeleteForm(request, response);
                break;
            case "create":
                showComplexCreateForm(request, response);
                break;
            case "search":
//                showComplexSearch(request, response);
                break;
            default:
                showComplexList(request, response);
                break;
        }
    }

    private void showComplexList (HttpServletRequest request, HttpServletResponse response) {
        List<Complex> complexList = complexBO.findAllComplex();
        request.setAttribute("complexList", complexList);
        try {
            request.getRequestDispatcher("/view/complex/complex-list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showComplexCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/view/complex/complex-create.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void createComplex(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String status = request.getParameter("status");
        String area = request.getParameter("area");
        String floor = request.getParameter("floor");
        String type = request.getParameter("type");
        String cost = request.getParameter("cost");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        List<String> errMessList = complexBO.checkValidateComplex(id, area, floor, cost, startDate, endDate);
        if (errMessList.isEmpty()) {
            Complex complex = new Complex(id, status, Double.parseDouble(area), Integer.parseInt(floor), type, Double.parseDouble(cost), startDate, endDate);
            complexBO.create(complex);
            request.setAttribute("messageInform", "Create Successful !!!");
            showComplexList(request, response);
        } else {
            request.setAttribute("errMessList", errMessList);
            try {
                request.getRequestDispatcher("view/complex/complex-create.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

//    private void showComplexDeleteForm(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Complex product = productBO.findProductById(id);
//        if (product == null) {
//            request.setAttribute("messageInform", "Not Found !!!");
//        } else {
//            request.setAttribute("product", product);
//        }
//        try {
//            request.getRequestDispatcher("/view/product/product-delete.jsp").forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
//    }

//    private void deleteComplex(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Complex product = productBO.findProductById(id);
//        if (product == null) {
//            request.setAttribute("messageInform", "Not Found !!!");
//        } else {
//            productBO.deleteProduct(id);
//            request.setAttribute("messageInform", "Delete Successful !!!");
//        }
//        showProductList(request, response);
//    }
//
//    private void showComplexSearch(HttpServletRequest request, HttpServletResponse response) {
//        List<Complex> productList;
//        List<Category> categoryList;
//        String search = request.getParameter("search");
//        String action = request.getParameter("action");
//        productList = productBO.search(search);
//        categoryList = categoryBO.findAllCategory();
//        request.setAttribute("productList", productList);
//        request.setAttribute("categoryList", categoryList);
//        request.setAttribute("search", search);
//        request.setAttribute("action", action);
//        try {
//            request.getRequestDispatcher("/view/product/product-list.jsp").forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
//    }
}
