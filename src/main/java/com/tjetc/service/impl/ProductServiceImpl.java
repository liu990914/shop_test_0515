package com.tjetc.service.impl;

import com.tjetc.dao.ProductDao;
import com.tjetc.dao.impl.ProductDaoImpl;
import com.tjetc.doman.PageBean;
import com.tjetc.doman.Product;
import com.tjetc.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDAO = new ProductDaoImpl();
    @Override
    public PageBean<Product> findpage(Integer nowpage, Integer eachpage, String term) {
        PageBean<Product> pb  =new PageBean<Product>();
        Integer count = productDAO.getCount(term);
        List<Product> each = productDAO.getEach(nowpage, eachpage, term);
        pb.setCount(count);
        pb.setNowpage(nowpage);
        pb.setEachpage(eachpage);
        pb.setLists(each);
        return pb;
    }

    @Override
    public boolean deleteByPid(Integer pid) {
        return productDAO.deleteByPid(pid);
    }

    @Override
    public boolean insert(Product product) {
        return productDAO.insert(product);
    }

    @Override
    public boolean update(Product product) {
        String pimage = product.getPimage();
        if(pimage==null||"".equals(pimage)){
            return   productDAO.update(product);
        }else {
            return  productDAO.updateWithPimage(product);
        }
    }

    @Override
    public Product findByPid(Integer pid) {
        return productDAO.findByPid(pid);
    }
}
