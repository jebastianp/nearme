package com.nearme.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nearme.data.Category;

public class CategoryDaoImpl extends DaoImpl implements CategoryDao {

	/* (non-Javadoc)
	 * @see com.nearme.dao.CategoryDao#getAllCategory()
	 */
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(value = "nearmeTran", readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Category> getAllCategory() {
		final String queryString = "select model from CategoryImpl model";
		Query query = em.createQuery(queryString);
		List<Category> result = query.getResultList();
		return result;
	}

	/* (non-Javadoc)
	 * @see com.nearme.dao.CategoryDao#getCategory(java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(value = "nearmeTran", readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Category> getCategory(String categoryName) {
		final String queryString = "select model from CategoryImpl model where model.name=:categoryName";
		Query query = em.createQuery(queryString);
		query.setParameter("categoryName", categoryName);
		List<Category> result = query.getResultList();
		return result;

	}

	/* (non-Javadoc)
	 * @see com.nearme.dao.CategoryDao#saveOrUpdate(com.nearme.data.Category)
	 */
	@Override
	@Transactional(value = "nearmeTran", readOnly = false, propagation = Propagation.REQUIRED)
	public Category saveOrUpdate(Category category) {
		if (category == null) {
			return null;
		}
		Category createdCategory = em.merge(category);
		return createdCategory;
	}

	/* (non-Javadoc)
	 * @see com.nearme.dao.CategoryDao#delete(com.nearme.data.Category)
	 */
	@Override
	@Transactional(value = "nearmeTran", readOnly = false, propagation = Propagation.REQUIRED)
	public boolean delete(Category category) {
		if (category == null) {
			return false;
		}
		try {
			em.remove(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
