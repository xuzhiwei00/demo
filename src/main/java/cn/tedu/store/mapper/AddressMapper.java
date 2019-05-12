package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressMapper {
	
	/**
	 * 插入地址的完整信息
	 * @param address
	 */
	void insert(Address address);
	
	/**
	 * 通过uid进行查询
	 * @param uid
	 * @return
	 */
    List<Address> selectByUid(Integer uid);
    /**
     * 把登录用户的所有is_default设置为0
     * @param uid
     * @return
     */
    Integer setCancel(Integer uid);
    
    /**
     * 把选中的地址栏is_default设置为1
     * @param id
     * @return
     */
    Integer setDefault(Integer id);
    /**
     * 通过id查询地址做修改
     * @param id
     * @return
     */
    Address selectAddressById(Integer id);
    
    /**
     * 根据id修改地址信息
     * @param address
     */
    void updateById(Address address);
    
    /**
     * 根据id删除地址信息
     * @param id
     */
    void deleteAddress(Integer id);

}
