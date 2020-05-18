package com.tjetc.service;

import com.tjetc.doman.PageBean;
import com.tjetc.doman.Product;

public interface ProductService {
    public PageBean<Product> findpage(Integer nowpage,Integer eachpage,String term);
    public boolean deleteByPid(Integer pid);
    public boolean insert(Product product);
    public boolean update(Product product);
    public Product findByPid(Integer pid);
}
