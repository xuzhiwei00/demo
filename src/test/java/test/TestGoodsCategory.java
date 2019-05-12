package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.service.IGoodsCategoryService;

public class TestGoodsCategory {
	

	
	@Test
	public void testselectByparentid(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml");
		GoodsCategoryMapper goodsCategory = ac.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
	
	     System.out.println(goodsCategory.selectCategoryByParentId(0, null, null));
		
	}
	@Test
	public void testSelectByParentService(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IGoodsCategoryService gc = ac.getBean("goodsCategoryService",IGoodsCategoryService.class);
	     List<GoodsCategory> list = gc.getGoodsCategoryByParentId(161, 0, 3);
	    System.out.println(list);
	}

}
