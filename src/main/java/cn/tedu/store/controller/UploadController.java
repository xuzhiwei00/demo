package cn.tedu.store.controller;


import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {

	//显示页面
	@RequestMapping("/showUpload.do")
	public String showUpload(){
		return "upload";
	}
	
	
	//
	@RequestMapping("/doUpload.do")
	public String doUpload(MultipartFile file){
		//实现上传
		//transferTo实现上传功能
		try {
			file.transferTo(new File("d:/",file.getOriginalFilename()));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//重定向到index.jsp
		return "redirect:../main/showIndex.do";
		
	}
}
