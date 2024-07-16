package day41;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public static String getData(String XL_PATH, String sheetName, int rc, int cc)
	{
		String value="";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(XL_PATH));
			Cell cell=wb.getSheet(sheetName).getRow(rc).getCell(cc);
			DataFormatter format = new DataFormatter();
			value=format.formatCellValue(cell);
			
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
	}

	public static int getRowCount(String XL_PATH, String sheetName)
	{
		int rc=0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(XL_PATH));
			rc=wb.getSheet(sheetName).getLastRowNum();
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rc;
		
	}
	
	public static int getCellCount(String XL_PATH, String sheetName,int rc)
	{
		int cc=0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(XL_PATH));
			cc=wb.getSheet(sheetName).getRow(rc).getLastCellNum();
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cc;
		
	}
	
	public static void setData(String XL_PATH, String sheetName, int rc, int cc, String value)
	{
		try {
			FileInputStream finput = new FileInputStream(XL_PATH);
			XSSFWorkbook wb = new XSSFWorkbook(finput);
			wb.getSheet(sheetName).getRow(rc).createCell(cc).setCellValue(value);
			FileOutputStream fout = new FileOutputStream(XL_PATH);
			wb.write(fout);
			wb.close();
			finput.close();
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


