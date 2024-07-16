package day40;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcelFile {

	public static void main(String[] args) throws IOException {
		//
		
		FileOutputStream file = new FileOutputStream("/Users/shiv/eclipse-workspace/seleniumwebdriver/data/output.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("data");
		XSSFRow row1 = sheet.createRow(0);
			row1.createCell(0).setCellValue("Python");
			row1.createCell(1).setCellValue("300");
			row1.createCell(2).setCellValue("Asia");
			
		XSSFRow row2 = sheet.createRow(1);
			row2.createCell(0).setCellValue("Java");
			row2.createCell(1).setCellValue("400");
			row2.createCell(2).setCellValue("India");
			
		XSSFRow row3= sheet.createRow(2);
			row3.createCell(0).setCellValue("C");
			row3.createCell(1).setCellValue("600");
			row3.createCell(2).setCellValue("USA");
			
		workbook.write(file);
		System.out.println("File created");
		workbook.close();
		file.close();
		
		
		
		
	}

}
