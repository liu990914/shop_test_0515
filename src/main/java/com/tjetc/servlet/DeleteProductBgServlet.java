package com.tjetc.servlet;

import com.tjetc.service.ProductService;
import com.tjetc.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteproductbg.do")
public class DeleteProductBgServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        boolean flag = productService.deleteByPid(Integer.valueOf(pid));
        if(flag){
            response.sendRedirect(request.getContextPath()+"/findproductbg.do");
        }else{
            response.sendRedirect(request.getContextPath()+"/findproductbg.do");
        }

    }
}
