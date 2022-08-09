package org.excelfiles.com;

import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFiles {

	public WriteExcelFiles() {
		// TODO Auto-generated constructor stub
	}
	
	//Escribir un arreglo de datos
	public void writeExcel (String filepath, String sheetname, String[] dataToWrite) throws IOException {
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newsheet = newWorkbook.getSheet(sheetname);
		int rowCount = newsheet.getLastRowNum() - newsheet.getFirstRowNum();
		//comenzar a escribir a partir de la última fila
		XSSFRow row = newsheet.getRow(0);
		XSSFRow newRow = newsheet.createRow(rowCount);
		
		for (int i = 0; i < row.getLastCellNum(); i++) {
			XSSFCell newCell = newRow.createCell(i);
			newCell.setCellValue(dataToWrite[i]);
		}
		inputStream.close();
		//Escribir en el archivo
		FileOutputStream outputStream = new FileOutputStream(file);
		newWorkbook.write(outputStream);
		outputStream.close();
	}
	//escribir un valor en una celda especifica
	public void writeCellValue(String filepath, String sheetname, int rownumber, int cellnumber, String resulttext) throws IOException {
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newsheet = newWorkbook.getSheet(sheetname);
		XSSFRow row = newsheet.getRow(rownumber);
		//comenzar a escribir a partir de la primera celda-1(es decir columna b del excel)
		XSSFCell firstCell = row.getCell(cellnumber-1);
		System.out.println("First cell value is: " + firstCell.getStringCellValue());
		XSSFCell nextCell = row.createCell(cellnumber);
		nextCell.setCellValue(resulttext);
		System.out.println("nextCell Value: " + nextCell.getStringCellValue());
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		newWorkbook.write(outputStream);
		outputStream.close();
	}
}