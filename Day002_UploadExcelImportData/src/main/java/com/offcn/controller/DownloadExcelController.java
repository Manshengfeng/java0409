package com.offcn.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.offcn.po.NewStudent;
import com.offcn.service.stuService;

@Controller
public class DownloadExcelController {
@Autowired
stuService service;

    @RequestMapping("/downloadexcel")
	public void downloadExcel(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//读取数据库现有数据
		List<NewStudent> list = service.getAll();
		
		//获取服务器真实路径
		String path = request.getServletContext().getRealPath("down");
		String filename="java0409.xlsx";
		
		//创建目标文件file
		File tfile = new File(path+"\\"+filename);
		
		File tpath = new File(path);
		
		if(!tpath.exists()){
			tpath.mkdir();
		}
		
		//生成excel文档
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("学生信息表");
		XSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("id");
		row.createCell(1).setCellValue("name");
		row.createCell(2).setCellValue("score");
		row.createCell(3).setCellValue("phone");
		int rownum=1;
		for(NewStudent stu:list){
			
			System.out.println("学生信息:"+stu);
			XSSFRow row1 = sheet.createRow(rownum);
			row1.createCell(0).setCellValue(stu.getId());
			row1.createCell(1).setCellValue(stu.getName());
			row1.createCell(2).setCellValue(stu.getScore());
			row1.createCell(3).setCellValue(stu.getPhone());
			rownum++;
		}
			
		//把工作簿写入磁盘
		try {
			workbook.write(new FileOutputStream(tfile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//设置响应头
		response.setContentType("application/x-xls;charset=GBK");
		//设置下载提示，告诉浏览器要下载的文件名称
		response.setHeader("Content-Disposition", "attachment;filename=\""+new String(filename.getBytes(),"ISO8859-1")+"\"");
		
		//告诉浏览器文件的大小
		response.setContentLength((int)tfile.length());
		
		//服务器端开始写入数据给浏览器
		byte[] buf=new byte[4096];
		BufferedOutputStream output=new BufferedOutputStream(response.getOutputStream());
		BufferedInputStream input=new BufferedInputStream(new FileInputStream(tfile));
		//遍历输入流，写入到输出流
		int len=-1;
		while((len=input.read(buf))!=-1){
			
			output.write(buf, 0, len);
		}
		
		output.close();
		input.close();
		
		
	}
}
