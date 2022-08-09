package org.excelfiles.com;

import java.io.*;
import org.apache.poi.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFiles {

	public ReadExcelFiles() {
		// TODO Auto-generated constructor stub
	}
	
	//método para leer un archivo espeífico de excel
	public void readExcel (String filepath, String sheetname) throws IOException {
		//filepath = ruta donde se encuentra el archivo;
		//sheetname = nombre de la hoja de donde se obtendra la información;
		//Crear un objeto de tipo file;
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		//Crear un objeto donde se guardara el archivo de excel
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		//Crear un objeto donde guarda la hoja de excel con la cual se trabajará;
		XSSFSheet newSheet = newWorkbook.getSheet(sheetname);
		//Establecer una variable para contar las filas de datos que posee el archivo;
		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
		//Ciclo for que se finalizará cuando haya leído la totalidad del archivo
		for (int i = 0; i < rowCount; i++) {
			//Crear un objeto fila que leerá el contenido de cada fila
			XSSFRow row = newSheet.getRow(i);
			//Iterar por cada celda de la fila
			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.println(row.getCell(j).getStringCellValue() + "||");
			}
		}
	}
	
	//método para leer una celda específica
	public String getCellValue(String filepath, String sheetname, int rownumber, int cellnumber) throws IOException {
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet = newWorkbook.getSheet(sheetname);
		XSSFRow row = newSheet.getRow(rownumber);
		XSSFCell cell = row.getCell(cellnumber);
		return cell.getStringCellValue();
	}

}
