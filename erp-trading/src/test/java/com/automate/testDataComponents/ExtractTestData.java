package com.automate.testDataComponents;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
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
	
	public static Map<String,List<Map<String, String>>> getExcelDatasWithUniqueColumn(String filename, String sheetName) {
		Map<String,List<Map<String, String>>> groupListWithInvoiceId=new HashMap<>();
		try {
			XSSFWorkbook sheetPath=new XSSFWorkbook("./testDataExternalFiles/" + filename + ".xlsx");
			XSSFSheet sheet = sheetPath.getSheet(sheetName);
			XSSFRow headerRow = sheet.getRow(0);
			int noOfRows = sheet.getPhysicalNumberOfRows();
			int noOfColumns = headerRow.getPhysicalNumberOfCells();
			
			int uniqueIdColumnIndex = -1;

	        for (Cell cell : headerRow) {
	            if (cell.getStringCellValue().equals("sampleId")) {
	                uniqueIdColumnIndex = cell.getColumnIndex();
	                break;
	            }
	        }
	        
	        List<Map<String, String>> newList =null;
			for (int i = 1; i < noOfRows; i++) {
				XSSFRow currentRow = sheet.getRow(i);
				String invoiceId = currentRow.getCell(uniqueIdColumnIndex).getStringCellValue();
				if(!groupListWithInvoiceId.containsKey(invoiceId)) {
					newList = new ArrayList<>();
					}
				Map<String, String> currentRowKeyPairData = new HashMap<>();
				for (int j = 0; j < noOfColumns; j++) {
					if (j != uniqueIdColumnIndex) {
						String keyColumnName = headerRow.getCell(j).getStringCellValue();
						XSSFCell currentCell = currentRow.getCell(j);
						if (currentCell != null) {
							DataFormatter formatCells = new DataFormatter();
							String currentCellValue = formatCells.formatCellValue(currentCell);
							currentRowKeyPairData.put(keyColumnName, currentCellValue);
						}
					}
				}
				newList.add(currentRowKeyPairData);
				groupListWithInvoiceId.put(invoiceId, newList);
			}
			
			sheetPath.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return groupListWithInvoiceId;
	}

}
