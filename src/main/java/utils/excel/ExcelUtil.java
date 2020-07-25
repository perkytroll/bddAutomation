package utils.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * <p>
 * Base class for excel reader and writer utility
 * </p>
 * @author Singh
 *
 */
public class ExcelUtil {
	protected File testFile;
	protected FileInputStream fis;
	protected Workbook testWorkbook;
	protected Sheet sheet;
	protected Map<String, Integer> columnHeaderMap;
	
	/**
	 * <p>
	 * Sets the file to be worked on
	 * </p>
	 * @param filePath path of the file
	 */
	public void setFile(String filePath) {
		try {
			testFile = new File(filePath);
			fis = new FileInputStream(testFile);
		}
		catch(Exception fnfe) {
			fnfe.printStackTrace();
		}
	}
	
	/**
	 * <p>
	 * Selects the Workbook type based on file extension
	 * </p>
	 * @param fileName Name of the file
	 */
	public void setWorkBookType(String fileName) {
		try {
			String fileExt = fileName.substring(fileName.lastIndexOf("."));
			switch(fileExt) {
			case ".xls":
				testWorkbook = new HSSFWorkbook(fis);
				break;
				
			case ".xlsx":
				testWorkbook = new XSSFWorkbook(fis);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * <p>
	 * Selects the sheet to be modified based on name
	 * </p>
	 * @param sheetName Name of the Sheet
	 */
	public void setSheetToRead(String sheetName) {
		sheet = testWorkbook.getSheet(sheetName);
	}
	
	/**
	 * <p>
	 * Maps the first row as the column headers for easier reading and writing
	 * </p> 
	 */
	public void setSheetHeaders() {
		columnHeaderMap = new HashedMap<String, Integer>();
		Row row = sheet.getRow(0);
		int minColIt = row.getFirstCellNum();
		int maxColIt = row.getLastCellNum();
		for(int colItr=minColIt; colItr<maxColIt; colItr++) {
			Cell cell = row.getCell(colItr);
			columnHeaderMap.put(cell.getStringCellValue(), cell.getColumnIndex());
		}
	}
}
