package com.automate.testDataComponents;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExtractTestData {
	
	
	public static List<Map<String, String>> getExcelDatasWithoutUniqueColumn(String filename, String sheetName) {
		List<Map<String, String>> currentRowList=new ArrayList<>();
		try {
			XSSFWorkbook excelPath=new XSSFWorkbook("./testDataExternalFiles/" + filename + ".xlsx");
			XSSFSheet currentSheet = excelPath.getSheet(sheetName);
			
			XSSFRow headerRow = currentSheet.getRow(0);
			
			int noOfRows = currentSheet.getPhysicalNumberOfRows();
			int nofOfColumns = headerRow.getPhysicalNumberOfCells();
			
			for (int i = 1; i < noOfRows; i++) {
				XSSFRow currentRow = currentSheet.getRow(i);
				Map<String, String> currentRowKeyValueData = new HashMap<>();
				for (int j = 0; j < nofOfColumns; j++) {
					String headerKey = headerRow.getCell(j).getStringCellValue();
					XSSFCell currentRowCell = currentRow.getCell(j);

					DataFormatter formatCellData = new DataFormatter();
					String currentCellValue = formatCellData.formatCellValue(currentRowCell);
					currentRowKeyValueData.put(headerKey, currentCellValue);
				}
				currentRowList.add(currentRowKeyValueData);
			}
			
			excelPath.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return currentRowList;
	}

}
