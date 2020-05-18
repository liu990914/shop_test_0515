package com.tjetc.test;

import com.tjetc.dao.CategoryDao;
import com.tjetc.dao.impl.CategoryDaoImpl;
import com.tjetc.doman.Category;
import com.tjetc.doman.PageBean;
import com.tjetc.doman.Product;
import com.tjetc.service.CategoryService;
import com.tjetc.service.ProductService;
import com.tjetc.service.impl.CategoryServiceImpl;
import com.tjetc.service.impl.ProductServiceImpl;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        CategoryDao dao=new CategoryDaoImpl();
        List<Category> all = dao.findAll();
        for (Category category : all) {
            System.out.println(category);
        }
        CategoryService service=new CategoryServiceImpl();
        List<Category> all1 = service.findAll();
        for (Category category : all1) {
            System.out.println(category);
        }
        ProductService service1=new ProductServiceImpl();
        PageBean<Product> findpage = service1.findpage(1, 10, " and cid = 1");
        System.out.println(findpage.toString());

    }
}
