package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;
import cn.tedu.store.service.IUserService;

@Controller
@RequestMapping("/main")
public class MainController {

	@Resource
	private IUserService userService;
	@Resource
	private IGoodsCategoryService goodsCategoryService;
	@Resource
	private IGoodsService goodsService;
	
	@RequestMapping("/showIndex.do")
	public String showIndex(ModelMap map){
		
		List<GoodsCategory> computerList = goodsCategoryService.
				getGoodsCategoryByParentId(161, 0, 3);
		List<List<GoodsCategory>> category161List =new ArrayList<List<GoodsCategory>>();
		for(GoodsCategory goodsCategory:computerList){
			Integer id2 = goodsCategory.getId();
			List<GoodsCategory> list3 =goodsCategoryService.getGoodsCategoryByParentId(id2, null, null);
			category161List.add(list3);
		}
		//把两个集合分别设置到map中
		map.addAttribute("computerList", computerList);
		map.addAttribute("category161List",category161List);
		
		//热门商品的集合
		List<Goods> goodsList = goodsService.getGoodsByCategoryId(163, 0, 3); 
		map.addAttribute("goodsList",goodsList);
		return "index";
	}

}
