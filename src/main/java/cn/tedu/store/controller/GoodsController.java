package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController{
	@Resource
	private IGoodsService goodsService;
	
	@RequestMapping("/showSearch.do")
	public String showSearch(
			Integer categoryId,
			ModelMap map,Integer page){
		if(page==null){
			page=1;
		}
		int offset = (page-1)*IGoodsService.PER_COUNT;
		List<Goods> goodsList = goodsService.getGoodsByCategoryId(categoryId, offset, 12);
		Integer count = goodsService.getCount(categoryId);
		
		map.addAttribute("goodsList",goodsList);
		map.addAttribute("count", count);
		Integer pages = count%IGoodsService.PER_COUNT==0?
				count/IGoodsService.PER_COUNT:count/IGoodsService.PER_COUNT+1;
		map.addAttribute("pages",pages);
		map.addAttribute("categoryId", categoryId);
		
		//设置当前页
		map.addAttribute("curr", page);
		
		return "search";
	}
	@RequestMapping("/showDetails.do")
	public String showDetails(String id,ModelMap map,Integer categoryId){
		Goods goods = goodsService.getGoodsById(id);
		List<Goods> goodsList = goodsService.getGoodsByCategoryId(categoryId, 0, 4);
		map.addAttribute("goods", goods);
		map.addAttribute("goodsList",goodsList);
		return "product_details";
	}

}
