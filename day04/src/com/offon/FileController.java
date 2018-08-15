package com.offon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("action1")

public class FileController {
	//上传文件
	@RequestMapping("action2")
	public String action2(Model model,HttpServletRequest res,MultipartFile[] files) throws Exception, IOException{
		
		//文件的相对路径
		String realpath=res.getSession().getServletContext().getRealPath("imgs");
		System.out.println(realpath);
		String msg="";
		for(MultipartFile m:files){
		System.out.println(m.getOriginalFilename());
		//获取绝对路径
		File file=new File(realpath,m.getOriginalFilename());
		System.out.println(file);
		//保存到file文件中去
		m.transferTo(file);
		
		
		msg  += " <img  src='imgs/"+m.getOriginalFilename()+"height='100'  width='200'/>";
		System.out.println(m.getOriginalFilename());
		
		
		}
		model.addAttribute("msg", msg);
		
		
		
		return "action3";
		
	}
	
	@RequestMapping("action4") 
	public String action4(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String filename=request.getParameter("filename");
		String realpath=request.getSession().getServletContext().getRealPath("imgs");
		File file=new File(realpath,filename);
		response.setHeader("Content-disposition", URLEncoder.encode(file.getAbsolutePath(),"UTF-8"));
		OutputStream write=response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		byte[]b=new byte[1024];
		int len=0;
		while((len=fis.read(b))!=-1){
			write.write(b, 0, len);
			                        
		}
		fis.close();
		write.close();
		
		
		
		
				
		
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
