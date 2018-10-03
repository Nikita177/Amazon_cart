package com.amazon.app.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Unit test for simple App.
 */

// public static Logger log = Logger.getLogger("fisf");

public class ExcelUtility {
	// public static void main( String[] args ) throws IOException

	public static ArrayList<String> readFile(String path, String excel,
			String sheet, String Testcase) throws IOException {
		System.out.println("*********Enter readFile*********");
		ArrayList<String> a = new ArrayList<String>();
		// Create object of FileInputStream to read a file
		FileInputStream fis = new FileInputStream(path + "\\" + excel);
		// Create object of XssFWorkbook class
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// Read the sheet inside the file by its name
		XSSFSheet sh = wb.getSheet(sheet);
		// file no of row in excel file
		int rowcount = (sh.getLastRowNum() - sh.getFirstRowNum()) + 1;

		System.out.println("rowcount" + rowcount);

		// Create a a loop overr all the row to read it
		for (int i = 1; i < rowcount; i++) {
			Row r = sh.getRow(i);
			// Create a loop to print cell value over each row
			for (int j = 0; j < r.getLastCellNum(); j++) {
				// read all the data from the rows
				System.out.print(r.getCell(j).getStringCellValue() + "|| ");

				// Condition to find specific data from the first row
				if (r.getCell(j).getStringCellValue().contains("TC")) {
					// loop to read the cell value for specific row
					Cell c = sh.getRow(i).getCell(2);

					a.add(c.getStringCellValue());

				}
			}
			System.out.println(" ");

		}
		fis.close();
		wb.close();
		return a;
	}

}
