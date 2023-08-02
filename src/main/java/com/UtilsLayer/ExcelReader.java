package com.UtilsLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.BaseLaye.BaseClass;

public class ExcelReader extends BaseClass {

	XSSFWorkbook workbook;

	public ExcelReader(String path) {
		File file = new File(path);
		try {
			FileInputStream fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getRowcount(int sheetindex) {
		return workbook.getSheetAt(sheetindex).getLastRowNum() + 1;
	}

	public int getColCount(int sheetindex) {
		return workbook.getSheetAt(sheetindex).getRow(0).getLastCellNum();
	}

	public Object getSpecificCellValue(int sheetindex, int row, int col) {
		XSSFCell cell = workbook.getSheetAt(sheetindex).getRow(row).getCell(col);

		if (cell == null) {
			return "";
		}

		if (cell != null) {
			if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
				return cell.getNumericCellValue();
			if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN)
				return cell.getBooleanCellValue();
			if (cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA)
				return cell.getCellFormula();

		}
		return null;
	}

	public Object[][] getTestData(int sheetindex) {
		int rows = getRowcount(sheetindex);
		int cols = getColCount(sheetindex);

		Object[][] data = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				data[i][j] = getSpecificCellValue(sheetindex, i, j);
			}
		}
		return data;
	}

}
