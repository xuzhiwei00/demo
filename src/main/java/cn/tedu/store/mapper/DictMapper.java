package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;

public interface DictMapper {
	
	/**
	 * 查询省
	 * @return
	 */
	List<Province> selectProvince();
	/**
	 * 
	 * @param provinceCode
	 * @return
	 */
	List<City> selectCity(String provinceCode);
	/**
	 * 
	 * @param cityCode
	 * @return
	 */
	List<Area> selectArea(String cityCode);
	/**
	 * 
	 * @param provinceCode
	 * @return
	 */
	String selectProvinceNameByCode(String provinceCode);
	/**
	 * 
	 * @param cityCode
	 * @return
	 */
	String selectCityNameByCode(String cityCode);
	/**
	 * 
	 * @param areaCode
	 * @return
	 */
	String selectAreaNameByCode(String areaCode);

}
