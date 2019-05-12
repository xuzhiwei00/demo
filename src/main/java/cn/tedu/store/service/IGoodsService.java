package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Goods;

public interface IGoodsService {
	Integer PER_COUNT = 12;
	List<Goods> getGoodsByCategoryId(
			Integer categoryId,Integer offset,Integer count);
	
	Integer getCount(Integer categoryId);
	
	Goods getGoodsById(String id);
	
	

}
