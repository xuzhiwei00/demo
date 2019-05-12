package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;

@Service
public class DictService implements IDictService{
    @Resource
	private DictMapper dictMapper;
	
    
    public List<Province> getProvince() {
		
		return dictMapper.selectProvince();
	}
	
	
	public List<City> getCity(String provinceCode) {
		List<City> list = dictMapper.selectCity(provinceCode);
		return list;
	}


	public List<Area> getArea(String cityCode) {
		List<Area> list = dictMapper.selectArea(cityCode);
		return list;
	}

}
