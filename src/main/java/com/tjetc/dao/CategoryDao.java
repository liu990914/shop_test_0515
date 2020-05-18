package com.tjetc.dao;

import com.tjetc.doman.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAll();
}
