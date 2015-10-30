package com.nearme.dao;

import java.util.List;

import com.nearme.data.Category;

public interface CategoryDao {

	public abstract List<Category> getAllCategory();

	public abstract List<Category> getCategory(String categoryName);

	public abstract Category saveOrUpdate(Category category);

	public abstract boolean delete(Category category);

}