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
@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet {

    private ProductsRepository productsRepository = ProductsRepository.getINSTANSE();
    private int ids;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", productsRepository.getById(ids = Integer.parseInt(req.getParameter("id"))) );
        req.getRequestDispatcher("/views/editProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        productsRepository.editProduct(ids,req.getParameter("title"), Integer.parseInt(req.getParameter("quantity")),
                Double.parseDouble(req.getParameter("price")), req.getParameter("specification"));

        resp.sendRedirect("/addProduct");
    }
}
