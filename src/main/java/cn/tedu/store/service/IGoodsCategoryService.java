package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.GoodsCategory;

public interface IGoodsCategoryService {
	

	List<GoodsCategory> getGoodsCategoryByParentId
	(Integer parentId,Integer offset,Integer count);

}
