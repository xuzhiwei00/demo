package cn.tedu.store.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.mapper.CartMapper;
@Service
public class CartService implements ICartService{
    @Resource
	private CartMapper cartMapper;
	
    public void addCart(Cart cart) {
    	List<Cart> listCart = cartMapper.selectCartByUid(cart.getUid());
    	for(Cart cart1:listCart){
    		if(cart.getGoodsId().equals(cart1.getGoodsId())){
    			Integer quantity = cart1.getNum()+cart.getNum();
    			cart.setNum(quantity);
        		cartMapper.updateNum(cart);
        		return;
        	}
    	}
    	cartMapper.insertCart(cart);
	}

	public List<CartVo> getAll(Integer uid) {
		List<CartVo> voList = cartMapper.selectAll(uid);
		return voList;
	}

	public void deleteByCartId(Integer id) {
		cartMapper.deleteByCartId(id);
		
	}

	public void deleteByBatch(Integer[] ids) {
		cartMapper.deleteByBatch(ids);
		
	}

	public void updateById(Integer id, Integer num) {
		cartMapper.updateById(id, num);
		
	}

	public List<CartVo> getOrderByUid(Integer uid, Integer[] ids) {
		List<CartVo> list = cartMapper.selectAll(uid);
		
		List<CartVo> newList = new ArrayList<CartVo>();
		for(CartVo cartvo:list){
			for(Integer id:ids){
				if(cartvo.gettCartId()==id){
					newList.add(cartvo);
					break;
				}
			}
		}
		return newList;
	}

}
