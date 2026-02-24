package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {
	public static Iterator<User> readCSVFile(String fileName) {
		File csvFile = new File(System.getProperty("user.dir") + "//testData//"+fileName);
		FileReader fileReader = null;
		CSVReader csvReader = null;
		String[] line; // full line print
		List<User>userList = null;
		User userdata;
		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			
			line = csvReader.readNext();
			System.out.println(Arrays.toString(line));
			userList=new ArrayList<User>();
			
			while((line=csvReader.readNext())!=null)
			{
				userdata=new User(line[0],line[1]);
				userList.add(userdata);
			}
			for(User user:userList)
			{
				System.out.println(user);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		return userList.iterator(); //it is return object form becoz data provider need in two dimensional object form
	}
}