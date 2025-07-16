package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	
	public static Iterator<User> readCSVFile(String fileName)  {
		
		File csvFile = new File(System.getProperty("user.dir")+"\\testData\\"+fileName);
		FileReader fileReader = null;
		CSVReader csvReader;
		String[] line;
		List<User> userList = null;
		
		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext(); //Reading the Col names -- Row 1 skip the col names
			
			userList = new ArrayList<User>();
			User userData;
			while((line=csvReader.readNext()) != null)  // if readnext reaches beyond the line where data is not present, it will store null
			{
				userData = new User(line[0], line[1]);
				userList.add(userData);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		
		return userList.iterator();
		
		
	}


}	

