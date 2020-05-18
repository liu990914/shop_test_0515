package com.tjetc.dao.impl;

import com.tjetc.dao.ProductDao;
import com.tjetc.doman.Product;
import com.tjetc.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private Connection conn = null;
    @Override
    public Integer getCount(String trem) {
        Integer count = 0;
        String sql ="select count(*) from product where 1=1 "+trem;
        try {
            this.conn = DButil.getConnection();
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            if(re.next()){
                count=  re.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Product> getEach(Integer nowpage, Integer eachpage, String trem) {
        String sql ="select * from product where 1=1 "+trem+" limit ?,?";
        List<Product> products =null;
        try {
            this.conn = DButil.getConnection();

            products = DButil.queryList(this.conn, Product.class, sql,
                    (nowpage - 1) * eachpage, eachpage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean deleteByPid(Integer pid) {
        boolean flag = false;
        try {
            this.conn =DButil.getConnection();
            int update = DButil.update(this.conn, "delete from product where pid = ?",
                    pid);
            if(update>0){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean insert(Product product) {
        boolean flag = false;
        try {
            this.conn =DButil.getConnection();
            int update = DButil.update(this.conn,
                    "insert into product (pname,market_price,shop_price,cid,pimage,pdesc) values " +
                            " (?,?,?,?,?,?)",product.getPname(),product.getMarket_price(),product.getShop_price(),product.getCid(),product.getPimage(),product.getPdesc());
            if(update>0){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateWithPimage(Product product) {
        boolean flag = false;
        try {
            this.conn =DButil.getConnection();
            int update = DButil.update(this.conn, "update product set " +
                    "pname = ?,market_price = ?, shop_price = ? ,pdesc = ?,cid = ? ,pimage = ? where pid = ?",product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPdesc(),product.getCid(),product.getPimage(),product.getPid());
            if(update>0){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(Product product) {
        boolean flag = false;
        try {
            this.conn =DButil.getConnection();
            int update = DButil.update(this.conn, "update product set " +
                    "pname = ?,market_price = ?, shop_price = ? ,pdesc = ?,cid = ? where pid = ?",product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPdesc(),product.getCid(),product.getPid());
            if(update>0){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Product findByPid(Integer pid) {

        Product product =null;
        try {
            this.conn = DButil.getConnection();

            product = DButil.query(this.conn, Product.class,
                    "select * from product where pid = ?",
                    pid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}
