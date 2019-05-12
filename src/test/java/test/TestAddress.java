package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.AddressService;
import cn.tedu.store.service.IAddressService;


public class TestAddress {
	
	
	@Test
	public void testinsert(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper addressMapper = ac.getBean("addressMapper",AddressMapper.class);
		Address address = new Address();
		address.setUid(2);
		address.setRecvName("小黄");
		address.setRecvPhone("672328732932");
		address.setRecvProvince("130000");
		address.setRecvCity("130100");
		address.setRecvArea("130102");
		address.setRecvDistrict("河北省石家庄长安区");
		address.setRecvAddress("城南村");
		
		
		addressMapper.insert(address);
	}
	@Test
	public void testupdatebyid(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService addressService = ac.getBean("addressService",IAddressService.class);
		Address address = new Address();
		address.setId(2);
		address.setRecvName("小黑");
		address.setRecvPhone("18812311231");
		address.setRecvProvince("110000");
		address.setRecvCity("110100");
		address.setRecvArea("110101");
		
		address.setRecvAddress("城南村");
		addressService.updateAddressById(address);
	}
	
	@Test
	public void testselectByUid(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper addressMapper = ac.getBean("addressMapper",AddressMapper.class);
	    List<Address> list = addressMapper.selectByUid(2);
	    System.out.println(list);
	}
	@Test
	public void testdelete(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper addressMapper = ac.getBean("addressMapper",AddressMapper.class);
		addressMapper.deleteAddress(27);
		
	}
	@Test
	public void testsetCancel(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper addressMapper = ac.getBean("addressMapper",AddressMapper.class);
		addressMapper.setDefault(3);
		
	}
	@Test
	public void testselectById(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml");
		AddressMapper addressMapper = ac.getBean("addressMapper",AddressMapper.class);
		Address address = addressMapper.selectAddressById(3);
		System.out.println(address);
		
		
	}
	@Test
	public void testaddaddress(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
	    IAddressService addressService = ac.getBean("addressService",IAddressService.class);
		Address address = new Address();
		address.setUid(2);
		address.setRecvName("admin");
		address.setRecvProvince("130000");
		address.setRecvCity("130100");
		address.setRecvArea("130102");
		address.setRecvAddress("姚家庄");
		address.setRecvPhone("1000000000");
		addressService.addAddress(address);
		
		
	}
	@Test
	public void testgetaddressbyid(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService addressService = ac.getBean("addressService",IAddressService.class);
		List<Address> list = addressService.getAddressByUId(8);
		System.out.println(list);
		
	}
	@Test
	public void testsetDefault(){
		ApplicationContext ac = new 
				ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IAddressService addressService = ac.getBean("addressService",IAddressService.class);
		addressService.setDefault(2, 2);
		
		
	}

}
