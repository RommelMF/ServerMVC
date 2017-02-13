package avito.controllers;

import avito.models.UserSession;
import avito.services.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Home on 12.01.2017.
 */
@WebServlet("/authoriz")
public class AuthorizServlet extends HttpServlet {

    private UsersService usersService = UsersService.getINSTANCE();
    private String success = "Вы не авторизованы :(";
    private String address;
    private UserSession userSession;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("message", success);
        req.getRequestDispatcher("/views/authoriz.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        this.address = "/authoriz";

        boolean auth = this.usersService.securityUser(login, password);
        if (auth != true) {
            this.address = "/regist";
        } else {
            success = "Вы авторизовались :)";
            HttpSession session = req.getSession(true);

            userSession = new UserSession();
            userSession.setUserLogin(login);
            session.setAttribute("userSession",userSession);
        }

        resp.sendRedirect(this.address);
    }
}
