package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String fileName) {
		
		
		File xlsxFile = new File(System.getProperty("user.dir")+"//testData//"+fileName);
		
		//XLSX File
		XSSFWorkbook xssfWorkbook = null;
		Row row;
		Cell emailAddressCell;
		Cell passwordAddressCell;
		User user;
		List<User> userList = null;
		XSSFSheet xssfSheet;
		Iterator<Row>  rowIterator;
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
			userList = new ArrayList<User>();	
			xssfSheet = xssfWorkbook.getSheet("LoginTestData");
			rowIterator= xssfSheet.iterator();
			rowIterator.next(); //skipping the col name
			
			while(rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordAddressCell = row.getCell(1);
				user = new User(emailAddressCell.toString(), passwordAddressCell.toString());
				userList.add(user);
				xssfWorkbook.close();

			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return userList.iterator();
		
	}
	
	
	
	
}
