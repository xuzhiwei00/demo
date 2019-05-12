package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;

public interface CartMapper {
	/**
	 * 插入数据给购物车
	 * @param cart
	 */
	void insertCart(Cart cart);
	/**
	 * 根据uid查询一个人的商品列表
	 * @param uid
	 * @return
	 */
	List<Cart> selectCartByUid(Integer uid);
	/**
	 * 根据uid和商品id进行修改商品的数量
	 * @param cart
	 * @return
	 */
	void updateNum(Cart cart);
	/**
	 * 根据uid查询所有的购物商品的信息
	 * @param uid
	 * @return
	 */
	List<CartVo> selectAll(Integer uid);
	/**
	 * 通过cart  id删除购物车商品
	 * @param id
	 */
	void deleteByCartId(Integer id);
	/**
	 * 批量删除
	 * @param ids
	 */
	void deleteByBatch(Integer[] ids);
	/**
	 * 通过id处理数量问题
	 * @param id
	 * @param num
	 */
	void updateById(
			@Param("id")Integer id,
			@Param("num")Integer num);
	

}
