package test;



import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;


public class TestDict {
	@Test
	public void testselectprovince(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml");
	    DictMapper dictMapper = ac.getBean("dictMapper",DictMapper.class);
	    List<Province> list = dictMapper.selectProvince();
	    for(Province p:list){
	    	System.out.println(p.getProvinceName());
	    }
	
	}
	@Test
	public void testselectcity(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml");
		DictMapper dictMapper = ac.getBean("dictMapper",DictMapper.class);
		List<City> list = dictMapper.selectCity("210000");
		for(City p:list){
			System.out.println(p.getCityName());
		}
		
	}
	
	@Test
	public void testselectprovinceName(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml");
		DictMapper dictMapper = ac.getBean("dictMapper",DictMapper.class);
		System.out.println(dictMapper.selectProvinceNameByCode("110000"));
	}

}
