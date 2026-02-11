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
		File xlxsFile = new File(System.getProperty("user.dir") + "\\testData\\" + fileName);
		XSSFWorkbook xssfWorkbook = null;
		Row row;
		Cell emailAddresscell;
		Cell passwordcell;
		User user;
		List<User> userlist = null;
		userlist = new ArrayList<User>();
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator;
		try {
			xssfWorkbook = new XSSFWorkbook(xlxsFile);
			userlist = new ArrayList<User>();
			 xssfSheet = xssfWorkbook.getSheet("LoginTestData");
			rowIterator = xssfSheet.iterator();
			rowIterator.next();// skip col Name
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddresscell = row.getCell(0);
				passwordcell = row.getCell(0);
				user = new User(emailAddresscell.toString(), passwordcell.toString());
				userlist.add(user);
				xssfWorkbook.close();
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return userlist.iterator();
	}
}
