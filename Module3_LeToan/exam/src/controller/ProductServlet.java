package controller;

import bo.category_bo.CategoryBO;
import bo.category_bo.CategoryBOImpl;
import bo.product_bo.ProductBO;
import bo.product_bo.ProductBOImpl;
import model.Category;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private CategoryBO categoryBO = new CategoryBOImpl();
    private ProductBO productBO = new ProductBOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                editProductInfo(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "create":
                createProduct(request, response);
                break;
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
            case "edit":
                showProductEditForm(request, response);
                break;
            case "delete":
                showProductDeleteForm(request, response);
                break;
            case "create":
                showProductCreateForm(request, response);
                break;
            case "search":
                showProductSearch(request, response);
                break;
            default:
                showProductList(request, response);
                break;
        }
    }

    private void showProductList (HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productBO.findAllProduct();
        request.setAttribute("productList", productList);
        List<Category> categoryList = categoryBO.findAllCategory();
        request.setAttribute("categoryList", categoryList);
        try {
            request.getRequestDispatcher("view/product/product-list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = categoryBO.findAllCategory();
        request.setAttribute("categoryList", categoryList);
        try {
            request.getRequestDispatcher("/view/product/product-create.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Product product = new Product( name, price, amount, color, description, categoryId);
        productBO.create(product);
        request.setAttribute("messageInform", "Create Successful !!!");
        showProductList(request, response);
    }

    private void showProductEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productBO.findProductById(id);
        if (product == null) {
            request.setAttribute("messageInform", "Not Found !!!");
        } else {
            request.setAttribute("product", product);
        }
        try {
            request.getRequestDispatcher("/view/product/product-edit.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editProductInfo(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productBO.findProductById(id);
        if (product == null) {
            request.setAttribute("message", "Not Found !!!");
        } else {
            product.setProductName(request.getParameter("name" + id));
            product.setProductPrice(Double.parseDouble(request.getParameter("price" + id)));
            product.setProductAmount(Integer.parseInt(request.getParameter("amount" + id)));
            product.setProductColor(request.getParameter("color" + id));
            product.setProductDescription(request.getParameter("description" + id));
            product.setProductCategoryId(Integer.parseInt(request.getParameter("categoryId" + id)));
            productBO.editProductInfo(product);
            request.setAttribute("messageInform", "Edit Successful !!!");
            showProductList(request, response);
        }
    }

    private void showProductDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productBO.findProductById(id);
        if (product == null) {
            request.setAttribute("messageInform", "Not Found !!!");
        } else {
            request.setAttribute("product", product);
        }
        try {
            request.getRequestDispatcher("/view/product/product-delete.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productBO.findProductById(id);
        if (product == null) {
            request.setAttribute("messageInform", "Not Found !!!");
        } else {
            productBO.deleteProduct(id);
            request.setAttribute("messageInform", "Delete Successful !!!");
        }
        showProductList(request, response);
    }

    private void showProductSearch(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList;
        List<Category> categoryList;
        String search = request.getParameter("search");
        String action = request.getParameter("action");
        productList = productBO.search(search);
        categoryList = categoryBO.findAllCategory();
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("search", search);
        request.setAttribute("action", action);
        try {
            request.getRequestDispatcher("/view/product/product-list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
