package com.tjetc.service.impl;

import com.tjetc.dao.CategoryDao;
import com.tjetc.dao.impl.CategoryDaoImpl;
import com.tjetc.doman.Category;
import com.tjetc.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao dao;

    public CategoryServiceImpl() {
        this.dao=new CategoryDaoImpl();
    }

    public List<Category> findAll() {
        return this.dao.findAll();
    }
}
