package utils.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class ExcelWriter extends ExcelUtil {

	public ExcelWriter(String filePath, String sheetName){
		this.setFile(filePath);
		this.setWorkBookType(filePath);
		this.setSheetToRead(sheetName);
		this.setSheetHeaders();
	}

	public void setDataCellsInLastRow(HashMap<String, String> dataSet) {
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		Row newRow = sheet.createRow(rowCount+1);
		Set<String> colHeaders = dataSet.keySet();
		Iterator<String> setItr = colHeaders.iterator();
		while(setItr.hasNext()) {
			String keyName = setItr.next();
			Cell cell = newRow.createCell(columnHeaderMap.get(keyName));
			cell.setCellValue(dataSet.get(keyName));
		}
		this.writeDataAndCloseStream();
	}

	public void setCellDataBasedOnOtherCell(String primaryColumn, String primaryColVal, String depColumn, String depColValue) {
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for (int rowItr=1; rowItr<rowCount+1; rowItr++) {
			Cell cell = sheet.getRow(rowItr).getCell(columnHeaderMap.get(depColumn));
			cell.setCellType(CellType.STRING);
			System.out.println("IN SHEET IS>>>> \n"+cell.getStringCellValue());
			System.out.println("RECEIVED ONE IS>>>> \n"+depColValue);
			if(cell.getStringCellValue().equals(depColValue)) {
				System.out.println("IT IS TRUTHY");
				sheet.getRow(rowItr).getCell(columnHeaderMap.get(primaryColumn)).setCellValue(primaryColVal);
				break;
			}
		}
		this.writeDataAndCloseStream();
	}

	public void writeDataAndCloseStream() {
		try {
			FileOutputStream fos = new FileOutputStream(testFile);
			testWorkbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
