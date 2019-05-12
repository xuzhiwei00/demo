package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;

public interface ICartService {

	void addCart(Cart cart);
	
	List<CartVo> getAll(Integer uid);
	
	void deleteByCartId(Integer id);
	
	void deleteByBatch(Integer[] ids);
	
	void updateById(Integer id,Integer num);
	
	List<CartVo> getOrderByUid(Integer uid,Integer[] ids);
}
