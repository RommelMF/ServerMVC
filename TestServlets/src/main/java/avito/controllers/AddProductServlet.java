package avito.controllers;

import avito.repositories.ProductsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Home on 13.01.2017.
 */
@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet{

    private ProductsRepository productsRepository = ProductsRepository.getINSTANSE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products",productsRepository.getAll());
        req.getRequestDispatcher("/views/addProducts.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String title = req.getParameter("title");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        double price = Double.parseDouble(req.getParameter("price"));
        String specification = req.getParameter("specification");

        productsRepository.addProduct(title, quantity, price, specification);
        resp.sendRedirect("/addProduct");
    }
}
