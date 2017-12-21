package com.ets.service;

import java.util.List;

import com.ets.common.ServerResponse;
import com.ets.pojo.Category;

public interface ICategoryService {
	ServerResponse addCategory(String categoryName,Integer parentId);
	
	ServerResponse updateCategoryName(Integer categoryId,String categoryName);
	
	ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
	
	ServerResponse selectCategoryAndChildrenById(Integer categoryId);
	
	ServerResponse<List<Category>> getCategory();
	
	ServerResponse delectCategoryById(Integer categoryId);
}
