package com.ets.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.ets.common.ServerResponse;
import com.ets.mapper.CategoryMapper;
import com.ets.pojo.Category;
import com.ets.service.ICategoryService;


@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {
	private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	public ServerResponse addCategory(String categoryName,Integer parentID){
		if(parentID == null || StringUtils.isBlank(categoryName)){
			return ServerResponse.createByErrorMessage("添加品类参数错误");
		}
		Category category = new Category();
		category.setName(categoryName);
		category.setParentId(parentID);
		category.setState(1);
		
		int rowCount = categoryMapper.insert(category);
		if(rowCount > 0){
			return ServerResponse.createBySuccessMessage("添加品类成功");
		}
		return ServerResponse.createByErrorMessage("添加品类失败");
	}
	
	public ServerResponse updateCategoryName(Integer categoryID,String categoryName){
		if(categoryID == null || StringUtils.isBlank(categoryName)){
			return ServerResponse.createByErrorMessage("更新品类参数错误");
		}
		Category category = new Category();
		category.setCategoryId(categoryID);
		category.setName(categoryName);
		
		int rowCount = categoryMapper.updateByPrimaryKeySelective(category);
		if(rowCount > 0){
			return ServerResponse.createBySuccessMessage("更新品类名字成功");
		}
		return ServerResponse.createByErrorMessage("更新品类名字失败");
	}
	
	public ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId){
		List<Category> list = categoryMapper.selectCategoryChildrenByParentId(categoryId);
		if(CollectionUtils.isEmpty(list)){
			logger.info("未找到当前分类的子分类");
		}
		return ServerResponse.createBySuccess(list);
	}
	
	public ServerResponse<List<Category>> getCategory(){
		List<Category> list = categoryMapper.selectCategory();
		if(CollectionUtils.isEmpty(list)){
			logger.info("未找到Category");
		}
		return ServerResponse.createBySuccess(list);
	}
	
	/**
	 * 递归查询本节点的id及孩子节点的id
	 * @param categoryId
	 * @return
	 */
	public ServerResponse selectCategoryAndChildrenById(Integer categoryId){
		Set<Category> categorySet = new HashSet<Category>();
		findChildCategory(categorySet, categoryId);
		
		List<Integer> categoryIdList = new ArrayList<Integer>();
		if(categoryId != null){
			for (Category categoryItem : categorySet) {
				categoryIdList.add(categoryItem.getCategoryId());
			}
		}
		return ServerResponse.createBySuccess(categoryIdList);
	}
	
	//递归算法，算出子节点
	private Set<Category> findChildCategory(Set<Category> categorySet,Integer categoryId){
		Category category = categoryMapper.selectByPrimaryKey(categoryId);
		if(category != null){
			categorySet.add(category);
		}
		//查询子节点,退出条件子节点为空
		List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(categoryId);
		for (Category categoryItem : categoryList) {
			findChildCategory(categorySet, categoryItem.getCategoryId());
		}
		return categorySet;
	}
	
	/**
	 * 递归查询本节点的id及孩子节点的id,并进行批量删除
	 * @param categoryId
	 * @return
	 */
	public ServerResponse delectCategoryById(Integer categoryId){
		Set<Category> categorySet = new HashSet<Category>();
		findChildCategory(categorySet, categoryId);
		List<Category> list = new ArrayList<Category>();
		if(categoryId != null){
			for (Category categoryItem : categorySet) {
				list.add(categoryItem);
			}
		}
		int rowCount = categoryMapper.batchDeleteById(list);
		if(rowCount > 0){
			return ServerResponse.createBySuccessMessage("删除成功");
		}
		return ServerResponse.createByErrorMessage("删除失败");
	}
}
