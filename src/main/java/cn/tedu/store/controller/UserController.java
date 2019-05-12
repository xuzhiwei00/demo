package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;
import java.util.function.DoublePredicate;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.ClassNameAlreadyExistException;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Resource
	private IUserService userService;
	@RequestMapping("/showPersonInfo.do")
	public String showPersonInfo(){
		return "personInfo";
	}
	
	@RequestMapping("/password.do")
	@ResponseBody
	public ResponseResult<Void> password(HttpSession session,String oldPassword,
			String newPassword){
		ResponseResult<Void> rr = new ResponseResult<Void>();
		
		try {
			Integer id = getId(session);
			userService.changePassword(id, oldPassword, newPassword);
			rr.setState(1);
			rr.setMessage("密码修改成功");
		} catch (Exception e) {
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
		return rr;
	}
	
	/**
	 * 
	 * 显示登录页面
	 * @return  视图名
	 */
	@RequestMapping("/showPassword.do")
	public String showPassword(){
		return "personal_password";
	}
	@RequestMapping("showLogin.do")
	public String showLogin(){
		return "login";
	}
	@RequestMapping("/showRegister.do")
	public String showRegist(){
		return "register";
	}
	@RequestMapping("/doUpload.do")
	@ResponseBody
	public ResponseResult<Void> doUpdoad(@RequestParam("file") MultipartFile file,
			                            HttpSession session) throws IllegalStateException, IOException{
		ResponseResult<Void> rr = new ResponseResult<Void>();
		//上传tupian
		//获取服务器的真实路径
		String path = session.getServletContext().getRealPath("/");
		System.out.println(path);
		file.transferTo(new File(path,"/upload/"+file.getOriginalFilename()));
		//修改image字段的值
		userService.updateImageById("/upload/"+file.getOriginalFilename(),getId(session));
		//更新session的user对象
		session.setAttribute("user", userService.getUserById(getId(session)));
		rr.setState(1);
		rr.setMessage("xhagnchuanchenggong");
		return rr;
		
	}
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username){ 
		ResponseResult<Void> rr = new ResponseResult<Void>();
		if(userService.checkUsername(username)){
			rr.setState(0);
			rr.setMessage("用户名已存在");
			
		}else{
			rr.setState(1);
			rr.setMessage("用户名可以使用");
		}
		return rr;
	}
	
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone){ 
		ResponseResult<Void> rr = new ResponseResult<Void>();
		if(userService.checkPhone(phone)){
			rr.setState(0);
			rr.setMessage("电话已存在");
			
		}else{
			rr.setState(1);
			rr.setMessage("电话可以使用");
		}
		return rr;
	}
	
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email){ 
		ResponseResult<Void> rr = new ResponseResult<Void>();
		if(userService.checkMail(email)){
			rr.setState(0);
			rr.setMessage("邮箱已存在");
			
		}else{
			rr.setState(1);
			rr.setMessage("邮箱可以使用");
		}
		return rr;
	}
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(
			@RequestParam("uname")String username,
			@RequestParam("upwd")String password,
			String email,String phone){
		ResponseResult<Void> rr = new ResponseResult<Void>();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		try {
			userService.register(user);
			
		} catch (ClassNameAlreadyExistException e) {
			rr.setState(0);
			rr.setMessage("用户名已经存在");
		}
		return rr;
	}
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username,
			String password,HttpSession session){
		ResponseResult<Void> rr = new ResponseResult<Void>();
		try {
			User user = userService.login(username, password);
			//登陆成功后user存到session对象中
			session.setAttribute("user", user);
			rr.setState(0);
			rr.setMessage("登陆成功");
			
		} catch (Exception e) {
			
			rr.setMessage(e.getMessage());
		}
		return rr;
	}
	@RequestMapping("/exit.do")
	public String exit(HttpSession session){
		session.invalidate();
		return "redirect:/main/showIndex.do";
	}
	@RequestMapping("/updateUser.do")
	@ResponseBody
	public ResponseResult<Void> updateUser(HttpSession session,String username,
			Integer gender,String phone,String email){
		ResponseResult<Void> rr = new ResponseResult<Void>();
		
		try {
			userService.updateUser(getId(session), username, gender, phone, email);
			session.setAttribute("user", 
					userService.getUserById(getId(session)));
			rr.setState(1);
			rr.setMessage("修改成功");
		} catch (Exception e) {
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
		return rr;
	}
	
	

}
