package com.offcn.cat;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.dao.Userdao;
import com.offcn.pojo.User;


public class Usersave {
	
	public static void main(String[] args) throws Exception, InvalidFormatException, IOException {
         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		Userdao bean = context.getBean(Userdao.class);
		
			// 1、指定要读取EXCEL文档名称
			String filename = "D:\\chart\\Mobile.xls";
			// filename="d:\\hello.xls";
			// 2、创建输入流
			FileInputStream input = new FileInputStream(filename);
			// 3、通过工作簿工厂类来创建工作簿对象
			Workbook workbook = WorkbookFactory.create(input);
			//4、遍历工作簿下面的所有工作表
			int sheetnum=workbook.getNumberOfSheets();
			for(int i=0;i<sheetnum;i++){
				//获取到单个工作表
				Sheet sheet=workbook.getSheetAt(i);
				//获取工作表下的所有行数
				int rownum=sheet.getPhysicalNumberOfRows();
				//获取第一行的单元格个数
				
				for(int j=0;j<rownum;j++){
					//获取到每一行
					Row row=sheet.getRow(j);
					int cellnum=row.getPhysicalNumberOfCells();
					//获取每一行下的全部单元格
					/*for(int x=0;x<cellnum;x++){*/
						Cell cell=row.getCell(1);
						Cell cell1=row.getCell(2);
						Cell cell2=row.getCell(3);
						Cell cell3=row.getCell(4);
						Cell cell4=row.getCell(5);
						
						User user = new User();
						user.setMobileNumber(String.valueOf(cell));
						user.setMobileArea(String.valueOf(cell1));
						user.setMobileType(String.valueOf(cell2));
						user.setAreaCode(String.valueOf(cell3));
						user.setPostCode(String.valueOf(cell4));
						System.out.println(user);
						 bean.save(user);
						
						/*//判断单元格类型,获取对应数据
						if(cell.getCellTypeEnum()==CellType.STRING){
							
							System.out.print(cell.getStringCellValue()+"\t");
						}else if(cell.getCellTypeEnum()==CellType.NUMERIC){
							System.out.print(cell.getNumericCellValue()+"\t");
						}*/
					}
					System.out.println("");
				}
				
			/*}*/
	}
}
		


