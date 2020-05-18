package com.tjetc.dao.impl;

import com.tjetc.dao.CategoryDao;
import com.tjetc.doman.Category;
import com.tjetc.util.DButil;
import sun.security.pkcs11.Secmod;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private Connection conn;
    public List<Category> findAll() {
        List<Category> categoryList=null;
        try {
            this.conn= DButil.getConnection();
            categoryList = DButil.queryList(this.conn, Category.class, "select * from category ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }
}
