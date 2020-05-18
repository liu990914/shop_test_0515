package com.tjetc.servlet;

import com.tjetc.doman.PageBean;
import com.tjetc.doman.Product;
import com.tjetc.service.ProductService;
import com.tjetc.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findproductbg.do")
public class FindProductBgServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        String key = request.getParameter("key");
        //拼接查询条件
        String trem = "";
        if(!(cid==null||"".equals(cid))){
            trem+="and cid = "+cid;
        }
        if(!(key==null||"".equals(key))){
            trem+=" and pname like '%"+key+"%'";
        }
        String nowpage = request.getParameter("nowpage");
        if(nowpage==null||"".equals(nowpage)){
            nowpage="1";
        }
        Integer eachpage = 6;
        PageBean<Product> pb = productService.findpage(Integer.valueOf(nowpage), eachpage, trem);
        String uri = request.getRequestURI()+"?";
        String queryString = request.getQueryString();
        if(!(queryString==null||"".equals(queryString))){
            uri+=queryString;
        }
        if(uri.indexOf("&nowpage")>-1){
            uri=uri.substring(0,uri.indexOf("&nowpage"));
        }
        pb.setUrl(uri);
        request.setAttribute("cid",cid);
        request.setAttribute("pb",pb);
        request.getRequestDispatcher("/admin/manage/product.jsp").forward(request,response);
    }
}
