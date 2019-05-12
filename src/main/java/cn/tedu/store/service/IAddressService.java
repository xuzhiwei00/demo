package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface IAddressService {
	/**
	 * 添加收货地址
	 * @param address
	 */
	void addAddress(Address address);
	
	/**
	 * 获取登录用户的收货地址
	 * @param uid
	 * @return
	 */
	
	List<Address> getAddressByUId(Integer uid);
	
	/**
	 * 
	 * @param uid
	 * @param id
	 */
	void setDefault(Integer uid,Integer id);
	/**
	 * 通过查询进行修改地址信息
	 * @return
	 */
	Address getAddressById(Integer id);
	/**
	 * 根据id进行修改
	 * @param address
	 */
	void updateAddressById(Address address);
	/**
	 * 根据id进行删除
	 * @param id
	 */
	
	void deleteAddress(Integer id);

}
