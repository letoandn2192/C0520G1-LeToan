package controller;

import bo.UserBO;
import bo.UserBOImpl;
import model.SortUserByName;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserBO userBO;

    @Override
    public void init() throws ServletException {
        userBO = new UserBOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewUser(request, response);
                break;
            case "update":
                updateUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
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
            case "create":
                showCreateForm(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "sort":
                sort(request, response);
            case "search":
                search(request, response);
                break;
            default:
                listUser(request, response);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("userList", userBO.selectAllUser());
        try {
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        User user = new User(name, email, address);
        try {
            userBO.createUser(user);
            request.setAttribute("message", "Create Successful !!!");
            request.setAttribute("userList", userBO.selectAllUser());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userBO.selectUserById(id);
        if (user == null) {
            request.setAttribute("message", "Fail");
        } else {
            request.setAttribute("user", user);
        }
        try {
            request.getRequestDispatcher("view/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userBO.selectUserById(id);
        if (user == null) {
            request.setAttribute("message", "Fail");
        } else {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            user.setName(name);
            user.setEmail(email);
            user.setAddress(address);
            try {
                userBO.updateUser(user);
                request.setAttribute("message", "Update Successful !!!");
                request.setAttribute("userList", userBO.selectAllUser());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                request.getRequestDispatcher("view/list.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            try {
//                response.sendRedirect("/user");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userBO.selectUserById(id);
        if (user == null) {
            request.setAttribute("message", "Fail");
        } else {
            request.setAttribute("user", user);
        }
        try {
            request.getRequestDispatcher("view/delete.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userBO.selectUserById(id);
        if (user == null) {
            request.setAttribute("message", "Fail");
        } else {
            try {
                userBO.deleteUser(id);
                request.setAttribute("message", "Delete Successful !!!");
                request.setAttribute("userList", userBO.selectAllUser());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            response.sendRedirect("/user");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void search (HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        String findBy = request.getParameter("findBy");
        List<User> userList = new ArrayList<>();
        if ("byId".equals(findBy)) {
            for (User user: userBO.selectAllUser()) {
                if (String.valueOf(user.getId()).contains(search)) {
                    userList.add(user);
                }
            }
        } else if ("byName".equals(findBy)) {
            for (User user: userBO.selectAllUser()) {
                if (user.getName().contains(search)) {
                    userList.add(user);
                }
            }
        } else {
            for (User user: userBO.selectAllUser()) {
                if (user.getAddress().contains(search)) {
                    userList.add(user);
                }
            }
        }

        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sort (HttpServletRequest request, HttpServletResponse response) {
        String sort = request.getParameter("sortBy");
        List<User> userList = userBO.selectAllUser();
        if ("sortName".equals(sort)) {
            Collections.sort(userList, new SortUserByName());
        }
        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("view/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
