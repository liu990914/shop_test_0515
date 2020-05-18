package com.tjetc.servlet;

import com.alibaba.fastjson.JSON;
import com.tjetc.doman.Category;
import com.tjetc.service.CategoryService;
import com.tjetc.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findallcategory.do")
public class FindAllCategoryServlet extends HttpServlet {
    private CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Category> categorys = categoryService.findAll();
        String jsonstr = JSON.toJSONString(categorys);
        System.out.println(jsonstr);
        response.getWriter().write(jsonstr);

    }
}
