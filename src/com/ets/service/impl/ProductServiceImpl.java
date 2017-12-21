package com.ets.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ets.common.ResponseCode;
import com.ets.common.ServerResponse;
import com.ets.mapper.CategoryMapper;
import com.ets.mapper.ItemMapper;
import com.ets.pojo.Category;
import com.ets.pojo.Item;
import com.ets.service.IProductService;
import com.ets.util.DateTimeUtil;
import com.ets.util.IDUtils;
import com.ets.util.PropertiesUtil;
import com.ets.vo.ItemDetailVo;


@Service("productService")
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	public ServerResponse saveOrUpdateProduct(Item item){
		if(item != null){
			if(item.getItemId() != null){
				int rowCount =  itemMapper.updateByPrimaryKey(item);
				if(rowCount > 0){
					return ServerResponse.createBySuccessMessage("更新产品成功");
				}
				return ServerResponse.createByErrorMessage("更新产品失败");
			}else{
				item.setItemId(IDUtils.getItemId());
				item.setState(1);
				item.setUserId((long)10001);
				int rowCount = itemMapper.insert(item);
				if(rowCount > 0){
					return ServerResponse.createBySuccessMessage("新增产品成功");
				}
				return ServerResponse.createByErrorMessage("新增产品失败");
			}
		}
		return ServerResponse.createByErrorMessage("新增或更新产品产参数不正常");
	}
	
	public ServerResponse<String> setSaleStatus(Long itemId,Integer status){
		if(itemId == null || status == null){
			return ServerResponse.createByErrorCodeMeaage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
		}
		Item item = new Item();
		item.setItemId(itemId);
		item.setState(status);
		int rowCount = itemMapper.updateByPrimaryKeySelective(item);
		if(rowCount > 0){
			return ServerResponse.createBySuccessMessage("修改产品销售状态成功");
		}
		return ServerResponse.createByErrorMessage("修改产品销售状态失败");
	}
	
	public ServerResponse<ItemDetailVo> manageProductDetail(Long itemId){
		if(itemId == null){
			return ServerResponse.createByErrorCodeMeaage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
		}
		Item item = itemMapper.selectByPrimaryKey(itemId);
		if(item == null){
			return ServerResponse.createByErrorMessage("产品已下架或者删除");
		}
		ItemDetailVo itemDetailVo = assembleItemDetailVo(item);
		return ServerResponse.createBySuccess(itemDetailVo);
	}
	
	private ItemDetailVo assembleItemDetailVo(Item item){
		ItemDetailVo itemDetailVo = new ItemDetailVo();
		itemDetailVo.setItemId(item.getItemId());
		itemDetailVo.setTitle(item.getTitle());
		itemDetailVo.setPrice(item.getPrice());
		itemDetailVo.setCategoryId(item.getCategoryId());
		itemDetailVo.setImage(item.getImage());
		itemDetailVo.setItemDesc(item.getItemDesc());
		itemDetailVo.setNum(item.getNum());
		itemDetailVo.setState(item.getState());
		
		//imageHost  
		itemDetailVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix","http://img.mymall11.com/"));
		
		//parentCategoryId
		Category category = categoryMapper.selectByPrimaryKey(item.getCategoryId());
		if(category == null){
			itemDetailVo.setParentCategoryId(0);//默认根节点
		}else{
			itemDetailVo.setParentCategoryId(category.getParentId());
		}
		
		//createTime updateTime
		itemDetailVo.setCreatetime(DateTimeUtil.dateToStr(item.getCreatedtime()));
		itemDetailVo.setUpdatetime(DateTimeUtil.dateToStr(item.getUpdatedtime()));
		
		return itemDetailVo;
	}
}
