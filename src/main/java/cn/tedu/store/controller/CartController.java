package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.ReflectiveStatementInterceptorAdapter;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.ICartService;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController{
	@Resource
	private ICartService cartservice;
	
	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(
			String goodsId,
			Integer num,
			HttpSession session){
		ResponseResult<Void> rr = new ResponseResult<Void>();
		Cart cart = new Cart();
		cart.setGoodsId(goodsId);
		cart.setNum(num);
		cart.setUid(getId(session));
		cartservice.addCart(cart);
		rr.setState(1);
		rr.setMessage("添加成功");
		return rr;
	}
	@RequestMapping("/showCart.do")
	public String showCart(HttpSession session,ModelMap map){
		List<CartVo> voList = cartservice.getAll(getId(session));
		map.addAttribute("voList",voList);
		return "cart";
	}
	@RequestMapping("/deleteByCartId.do")
	public String deleteByCartId(Integer id){
		
		cartservice.deleteByCartId(id);
		
		return "redirect:showCart.do";
	}
	
	@RequestMapping("/deleteByBatch.do")
	public String deleteByBatch(Integer[] ids) {
		cartservice.deleteByBatch(ids);
		return "redirect:showCart.do";
	}
	@RequestMapping("/updateNumById.do")
	@ResponseBody
	public ResponseResult<Void> updateNumById(Integer id,Integer num){
		ResponseResult<Void> rr =new ResponseResult<Void>();
		cartservice.updateById(id, num);
		rr.setState(1);
		return rr;
	}

}
