package question2.Utilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DoesFileExist {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet1;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public DoesFileExist(String path) {
	try {
		File src = new File(path);
		FileInputStream fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		sheet1=wb.getSheetAt(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
	}
	}


	public String getData(int Sheetnumber, int row, int col)
	{
		sheet1=wb.getSheetAt(Sheetnumber);
		String data=sheet1.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	//Method return the number of rows in excel sheet
	public int getRowCount(int sheetIndex)
	{
		int row=wb.getSheetAt(sheetIndex).getLastRowNum();
		row=row+1;
		return row;
	}

	
	


}

