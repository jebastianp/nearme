package com.nearme.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nearme.dao.CategoryDao;
import com.nearme.data.Category;
import com.nearme.model.NearmeJsonModel;

@Controller
public class CategoryController {
	private static final Logger logger = LoggerFactory
			.getLogger(CategoryController.class);

	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value = APIRequestMappings.GET_ALL_CATEGORY, method = {
			RequestMethod.POST, RequestMethod.GET }, produces = "application/json")
	public @ResponseBody NearmeJsonModel getAllCategory() {
		NearmeJsonModel model = new NearmeJsonModel();
		Map<String, Object> header = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		model.setSpData(data);
		model.setSpHeader(header);
		boolean status = false;
		try {
			List<String> errorList = new ArrayList<String>();
			List<Category> categoryList = categoryDao.getAllCategory();
			status = true;
			data.put("categories", categoryList != null ? categoryList
					: new ArrayList<>());
			logger.info("Category Size is: " + categoryList);
			header.put("status", status);
			header.put("errorList", errorList);
		} catch (Exception e) {
			logger.error(
					"Exception while fetching the Categories: "
							+ e.getMessage(), e);
		}
		return model;
	}
}
