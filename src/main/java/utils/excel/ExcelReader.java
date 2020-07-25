package utils.excel;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ExcelReader extends ExcelUtil{

	DataFormatter formatter;

	public ExcelReader(String fileNameWithPath, String sheetName){
		this.setFile(fileNameWithPath);
		this.setWorkBookType(fileNameWithPath);
		this.setSheetToRead(sheetName);
		this.setSheetHeaders();
	}

	public ArrayList<Object> getAllValuesInAColumn(String columnName) {
		ArrayList<Object> columnData = new ArrayList<Object>();
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

		for (int rowItr=1; rowItr<rowCount+1; rowItr++) {
			Cell cell = sheet.getRow(rowItr).getCell(columnHeaderMap.get(columnName));
			switch(cell.getCellType()) {
			case NUMERIC:
				columnData.add(cell.getNumericCellValue());
				break;

			case STRING:
				columnData.add(cell.getStringCellValue());
				break;

			case _NONE:
				break;

			default:
				break;
			}
		}
		return columnData;
	}

	public ArrayList<Object> returnDependentColumnsData(String columnToReturn, String depColumn, String value, Boolean allVals){
		ArrayList<Object> columnData = new ArrayList<Object>();
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		for (int rowItr=1; rowItr<rowCount+1; rowItr++) {
			Cell primCell = sheet.getRow(rowItr).getCell(columnHeaderMap.get(columnToReturn));
			primCell.setCellType(CellType.STRING);
			Cell secCell = sheet.getRow(rowItr).getCell(columnHeaderMap.get(depColumn));
			secCell.setCellType(CellType.STRING);
			if(secCell.getStringCellValue().equals(value)) {
				columnData.add(primCell.getStringCellValue());
				if(allVals == false) {
					break;
				}
			}
		}
		return columnData;
	}
	
	
	public Object getLastDataCellValue(String columnToReturn) {
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		Cell primeCell = sheet.getRow(rowCount).getCell(columnHeaderMap.get(columnToReturn));
		if (primeCell.getCellType() == CellType.STRING)
			return primeCell.getStringCellValue();
		if (primeCell.getCellType() == CellType.BOOLEAN)
			return primeCell.getBooleanCellValue();
		if (primeCell.getCellType() == CellType.NUMERIC)
			return primeCell.getNumericCellValue();
		return null;
		
	}

}
