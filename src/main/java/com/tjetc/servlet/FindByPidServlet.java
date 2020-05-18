package com.tjetc.servlet;

import com.tjetc.doman.Product;
import com.tjetc.service.ProductService;
import com.tjetc.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findbypid.do")
public class FindByPidServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        Product product = productService.findByPid(Integer.valueOf(pid));
        req.setAttribute("product",product);
        req.getRequestDispatcher("/admin/manage/product-moddify.jsp").forward(req,resp);
    }
}
