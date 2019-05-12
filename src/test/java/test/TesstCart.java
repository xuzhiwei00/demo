package test;



import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.service.CartService;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ICartService;

public class TesstCart {
	
	@Test
	public void testaddaddress(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
	    /*CartMapper  cartMapper = ac.getBean("cartMapper",CartMapper.class);*/
		ICartService cartService = ac.getBean("cartService",ICartService.class);
		
		Integer[] ids = {16,17,18};
		/*Cart cart = new Cart();
		cart.setUid(2);
		cart.setGoodsId("10000008");
		cart.setNum(15);*/
		
		List<CartVo> list = cartService.getOrderByUid(2, ids);
		System.out.println(list);
		
	}
	@Test
	public void testselectbyuid(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
	    CartMapper  cartMapper = ac.getBean("cartMapper",CartMapper.class);
	     System.out.println(cartMapper.selectAll(2).size());
	    
	    
	}
	@Test
	public void testdeletebyid(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		CartMapper  cartMapper = ac.getBean("cartMapper",CartMapper.class);
		cartMapper.updateById(15, 15);
		
		
	}
}
