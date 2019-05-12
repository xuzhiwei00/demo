package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.GoodsCategory;

public interface GoodsCategoryMapper {
	/**
	 * 通过parent_id进行查询一级二级分类
	 * @param parentId
	 * @param offset
	 * @param count
	 * @return
	 */
	
	
	List<GoodsCategory> selectCategoryByParentId(
			@Param("parentId")Integer parentId,
			@Param("offset")Integer offset,
			@Param("count")Integer count);

}
