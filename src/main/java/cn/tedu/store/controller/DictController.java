package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IDictService;

@Controller
@RequestMapping("/dict")
public class DictController {
	@Resource
	private IDictService dictService;
	
	@RequestMapping("/showProvince.do")
	@ResponseBody
	public ResponseResult<List<Province>> showProvince(){
		ResponseResult<List<Province>> rr = new ResponseResult<List<Province>>();
		List<Province> list = dictService.getProvince();
		rr.setData(list);
		return rr;
	}
	@RequestMapping("/showCity.do")
	@ResponseBody
	public ResponseResult<List<City>> showCity(String provinceCode){
		ResponseResult<List<City>> rr = new ResponseResult<List<City>>();
		
		List<City> list = dictService.getCity(provinceCode);
		rr.setData(list); 
		return rr;
	}
	@RequestMapping("/showArea.do")
	@ResponseBody
	public ResponseResult<List<Area>> showArea(String cityCode){
		ResponseResult<List<Area>> rr = new ResponseResult<List<Area>>();
		List<Area> list = dictService.getArea(cityCode);
		rr.setData(list);
		return rr;
	}

}
