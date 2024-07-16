package day40;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcelFile {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream("/Users/shiv/eclipse-workspace/seleniumwebdriver/data/input.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int lastRowCount=sheet.getLastRowNum();
		int lastCellCount=sheet.getRow(1).getLastCellNum();
		
		for(int r=1;r<=lastRowCount;r++)
		{
			XSSFRow row=sheet.getRow(r);
			for(int c=0;c<lastCellCount;c++)
			{
				XSSFCell cell=row.getCell(c);
				System.out.print(cell.toString()+"\t");
			}
			System.out.println();
		}
		workbook.close();
		file.close();
		
		
		
	}

}
