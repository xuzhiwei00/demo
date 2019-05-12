package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.Goods;

public interface GoodsMapper {
	/**
	 * 通过categoryid进行查询  商品的热度
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> select(
			@Param("categoryId")Integer categoryId,
			@Param("offset")Integer offset,
			@Param("count")Integer count);
	
	
	/**
	 * 查询类别的总个数 做分页管理
	 * @param categoryId
	 * @return
	 */
	Integer selectCount(Integer categoryId);
	
	/**
	 * 查询商品的细节
	 * @param id
	 * @return
	 */
	Goods selectGoodsById(String id);
	

}
