package com.offcn.controller;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.offcn.po.NewStudent;
import com.offcn.service.stuService;
@Controller
public class FileUploadController {
@Autowired
stuService service;
	@RequestMapping(value="/uploadexcel",method=RequestMethod.POST)
	public String uplaodExcel(@RequestParam("file1") MultipartFile file,HttpServletRequest request,Model model){
		
		//获取服务器端真实路径
		String path=request.getServletContext().getRealPath("upload");
		
		//获取上传文件的原始名称
		String fileName = file.getOriginalFilename();
		//创建目标存储file
		File tFile = new File(path+"\\"+fileName);
		System.out.println(tFile+"tFile============");
		
		//创建目标文件夹file
		File tpath = new File(path);
		
		if(!tpath.exists()){
			tpath.mkdir();
		}
		//把上传的文件存储到目标目录
		try {
			file.transferTo(tFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//存储成功，开始遍历excle
		try {
			Workbook workbook=WorkbookFactory.create(tFile);
			System.out.println(workbook+"===========================1");
			//读取工作表
			Sheet sheet = workbook.getSheet("Sheet1");
			//行数
			int rownum = sheet.getPhysicalNumberOfRows();
			for(int i=0;i<rownum;i++){
				if(i==0){
					continue;
				}
				Row row = sheet.getRow(i);
				StringBuffer b = new StringBuffer();
				//判断单元格数量
				int cellnum = row.getPhysicalNumberOfCells();
				for(int j=0;j<cellnum;j++){
					Cell cell = row.getCell(j);
					if(cell.getCellTypeEnum()==CellType.STRING){
						//System.out.print(cell.getStringCellValue()+"\t");
						b.append(cell.getStringCellValue()+"~");
					}else{
						DecimalFormat df = new DecimalFormat("####");
						//System.out.print(df.format(cell.getNumericCellValue())+"\t");
						b.append(df.format(cell.getNumericCellValue())+"~");
					}
				}
				String str = b.toString();
				String[] rows = str.split("~");
				NewStudent stu = new NewStudent();
				stu.setName(rows[0]);
				stu.setScore(Float.parseFloat(rows[1]));
				stu.setPhone(rows[2]);
				System.out.println("保存学生信息:"+stu);
				service.save(stu);
				
				System.out.println("");
			}
			
			workbook.close();
			
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sucess";
	}
}
