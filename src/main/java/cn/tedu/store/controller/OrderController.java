package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ICartService;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{

	@Resource
	private IAddressService addressService;
	@Resource
	private ICartService cartService;
	@RequestMapping("/showOrder.do")
	public String showOrder(HttpSession session,Integer[] ids,ModelMap map){
		List<CartVo> volist =
				cartService.getOrderByUid(getId(session), ids);
		map.addAttribute("volist", volist);
		//
		List<Address> addresslist = 
				addressService.getAddressByUId(getId(session));
		map.addAttribute("addresslist", addresslist);
		return "orderConfirm";
	}
}
