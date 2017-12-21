package com.ets.service;

import com.ets.common.ServerResponse;
import com.ets.pojo.Item;
import com.ets.vo.ItemDetailVo;

public interface IProductService {
	ServerResponse saveOrUpdateProduct(Item item);
	
	ServerResponse<String> setSaleStatus(Long itemId,Integer status);
	
	ServerResponse<ItemDetailVo> manageProductDetail(Long itemId);
}
