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
@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {

    private ProductsRepository productsRepository = ProductsRepository.getINSTANSE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productsRepository.removeProduct(Integer.parseInt(req.getParameter("id")));
        req.getRequestDispatcher("/views/addProducts.jsp").forward(req, resp);
    }
}
