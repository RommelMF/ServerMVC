package avito.controllers;


import avito.repositories.StorageUserImpl;
import avito.repositories.StorageUsers;
import avito.repositories.UserRepository;

import javax.management.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * сервлет, отвечающий за регистрацию пользователей
 */
@WebServlet("/regist")
public class RegistrationServlet extends HttpServlet {

//    private UserRepository userRepository = UserRepository.getINSTANCE();
    private StorageUserImpl storageUser = StorageUserImpl.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("listUsers", this.storageUser.getAll());
        req.getRequestDispatcher("/views/registr.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String login = req.getParameter("login");
        String password = req.getParameter("password");


        this.storageUser.userAdd(name, email, password, login);

        resp.sendRedirect("/regist");
    }
}
