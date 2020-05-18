package com.tjetc.dao;

import com.tjetc.doman.Product;

import java.util.List;

public interface ProductDao {
    public  Integer getCount(String trem);
    public List<Product> getEach(Integer nowpage, Integer eachpage, String trem);
    public boolean  deleteByPid(Integer pid);
    public boolean  insert(Product product);
    public boolean  updateWithPimage(Product product);
    public boolean  update(Product product);
    public Product  findByPid(Integer pid);
}
