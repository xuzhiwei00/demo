package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;
@Service
public class AddressService implements IAddressService{

	@Resource
	private AddressMapper addressMapper;
	@Resource
	private DictMapper dictMapper;
	
	public void addAddress(Address address) {
		
		String provinceName = dictMapper.selectProvinceNameByCode(address.getRecvProvince());
		String cityName = dictMapper.selectCityNameByCode(address.getRecvCity());
		String areaName = dictMapper.selectAreaNameByCode(address.getRecvArea());
		
		address.setRecvDistrict(provinceName+cityName+areaName);
	    List<Address> list = addressMapper.selectByUid(address.getUid());
	    if(list.size()>0){
	    	address.setIsDefault(0);
	    }else if(list.size()==0){
	    	address.setIsDefault(1);
	    }
		addressMapper.insert(address);
	}

	public List<Address> getAddressByUId(Integer uid) {
		List<Address> list = addressMapper.selectByUid(uid);
		return list;
	}

	public void setDefault(Integer uid, Integer id) {
		//a和b代表的是数据库改动的条数，如果等于0则说明数据库没有发生改动
		Integer a = addressMapper.setCancel(uid);
		if(a==0){
			throw new RuntimeException("修改数据失败");
		}
		Integer b = addressMapper.setDefault(id);
		if(b==0){
			throw new RuntimeException("修改数据失败");
		}
		
		
	}

	public Address getAddressById(Integer id) {
		Address address = addressMapper.selectAddressById(id);
		return address;
	}

	public void updateAddressById(Address address) {
		address.setRecvDistrict(dictMapper.selectProvinceNameByCode(address.getRecvProvince())+
				dictMapper.selectCityNameByCode(address.getRecvCity())+
				dictMapper.selectAreaNameByCode(address.getRecvArea()));
		addressMapper.updateById(address);
		
	}
	
	public void deleteAddress(Integer id){
		addressMapper.deleteAddress(id);
	}

}
