package test;

import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.service.IGoodsService;

public class TestGoods {
	
	@Test
	public void select(){
		
			ApplicationContext ac = new 
					ClassPathXmlApplicationContext("spring-dao.xml");
			GoodsMapper goodsMapper = ac.getBean("goodsMapper",GoodsMapper.class);
		    List<Goods> list= goodsMapper.select(16, 0, 3);
		    System.out.println(list);	
	}
	@Test
	public void selectcount(){
		
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml");
		GoodsMapper goodsMapper = ac.getBean("goodsMapper",GoodsMapper.class);

		System.out.println(goodsMapper.selectCount(163));	
	}
	@Test
	public void selectgoodsbyid(){
		
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml");
		GoodsMapper goodsMapper = ac.getBean("goodsMapper",GoodsMapper.class);
		
		System.out.println(goodsMapper.selectGoodsById("10000044"));	
	}
	@Test
	public void testgetgoodsbYcategory(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
	     IGoodsService goodsService = ac.getBean("goodsService",IGoodsService.class);
	     System.out.println(goodsService.getGoodsByCategoryId(163, 0, 3).size());
	}

}
