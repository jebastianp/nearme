package com.nearme.dao;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.nearme.data.Category;
import com.nearme.data.CategoryImpl;
import com.nearme.utils.Utils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@TransactionConfiguration
@Transactional(value = "nearmeTran")
public class CategoryDaoTest {
	@Autowired
	private CategoryDao categoryDao;

	@Test
	public void testGetAllCategory() {
		createCategory();
		List<Category> categorys = categoryDao.getAllCategory();
		Assert.assertNotNull(categorys);

	}

	public Category createCategory() {
		Category category = new CategoryImpl();
		category.setName("Test category" + Utils.generateGuid());
		category.setCreatedDate(new DateTime().toDate());
		category.setUpdatedDate(new DateTime().toDate());
		Category newCategory = categoryDao.saveOrUpdate(category);
		return newCategory;
	}

	@Test
	@Rollback(false)
	public void testCreateCategory() {
		Category newCategory = createCategory();
		Assert.assertNotNull(newCategory);
		Assert.assertNotNull(newCategory.getId());
	}

	@Test
	public void testUpdateCategoryName() {
		Category newCategory = createCategory();
		Assert.assertNotNull(newCategory);
		Assert.assertNotNull(newCategory.getId());
		newCategory.setName("Test categoryupdate");
		Category updatedCategory = categoryDao.saveOrUpdate(newCategory);
		Assert.assertNotNull(updatedCategory);
		Assert.assertTrue(updatedCategory.getName().equalsIgnoreCase(
				"Test categoryupdate"));
	}

	@Test
	public void testDeleteCategory() {
		Category newCategory = createCategory();
		Assert.assertNotNull(newCategory);
		Assert.assertNotNull(newCategory.getId());
		boolean deleteStatus = categoryDao.delete(newCategory);
		Assert.assertTrue(deleteStatus);
	}
}
