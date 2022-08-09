package com.cognizant.excel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelReader {

	/** Creates a new instance of POIExcelReader */
	public ExcelReader() {
	}

	/**
	 * This method is used to write the sheet to a File.
	 *
	 * @param HSSFSheet
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings("unchecked")
	public void writeSheetToCSVFile(HSSFSheet sheet, String folderLocation, String delimeter, Boolean ignoreFirstRow) throws IOException {
		BufferedWriter bufferWriter = null;
		FileOutputStream fos = null;
		File fout = null;
		try {
			Iterator rows = sheet.rowIterator();
			int rowCounter = 0;			
			fout = new File(folderLocation+"\\"+sheet.getSheetName().replace(' ', '_')+"_DATA.txt");
			fos = new FileOutputStream(fout);	 
			bufferWriter = new BufferedWriter(new OutputStreamWriter(fos));
			
			while (rows.hasNext()) {			
				HSSFRow row = (HSSFRow) rows.next();
				if (ignoreFirstRow && rowCounter == 0) {
					rowCounter++;
					continue;
				}
				// display row number in the console.
				//System.out.println("Row No.: " + row.getRowNum());
				// once get a row its time to iterate through cells.
				Iterator cells = row.cellIterator();
				StringBuffer rowToBeWritten = new StringBuffer();
				while (cells.hasNext()) {
					HSSFCell cell = (HSSFCell) cells.next();
					/*
					 * Now we will get the cell type and display the values
					 * accordingly.
					 */
					switch (cell.getCellType()) {
					case HSSFCell.CELL_TYPE_NUMERIC: {
						// cell type numeric.
						rowToBeWritten.append(cell.getNumericCellValue()).append(delimeter);
						break;
					}

					case HSSFCell.CELL_TYPE_STRING: {
						// cell type string.
						HSSFRichTextString richTextString = cell.getRichStringCellValue();
						rowToBeWritten.append(cell.getRichStringCellValue()).append(delimeter);
						break;
					}
					default: {
						// types other than String and Numeric.
						break;
					}
				 }
				}
				if(rowToBeWritten.length() > 0 ){
					bufferWriter.write(rowToBeWritten.substring(0, rowToBeWritten.length()-1));
					bufferWriter.newLine();
				}
				rowCounter++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			bufferWriter.close();
			fos.close();
		}
	}

	public void writeExceltoFiles(String xlsPath, String directory, String delimeter) {
		InputStream inputStream = null;		
		
		try {
			inputStream = new FileInputStream(xlsPath);
		} catch (FileNotFoundException e) {
			System.out.println("File not found in the specified path.");
			e.printStackTrace();
		}
		POIFSFileSystem fileSystem = null;
		HSSFSheet currentSheet = null;
		try {
			fileSystem = new POIFSFileSystem(inputStream);
			HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);
			// workBook.getNumberOfSheets()
			for (int sheetIndex = 0; sheetIndex < workBook.getNumberOfSheets(); sheetIndex++){
				//Get the current sheet
				currentSheet = workBook.getSheetAt(sheetIndex);
				if(sheetIndex > 0)
					writeSheetToCSVFile(currentSheet, directory, delimeter,true);
				else
					writeSheetToCSVFile(currentSheet, directory, delimeter,false);
				//break;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The main executable method to test displayFromExcel method.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		ExcelReader poiExample = new ExcelReader();
		String delimeter = ",";
		String folderName = "C:\\Raju\\hadoop\\weatherData";
		String xlsPath = "C:\\Raju\\hadoop\\imd_district-wise_rainfalldata_2004-2010.xls";
		poiExample.writeExceltoFiles(xlsPath, folderName, delimeter);
	}
}