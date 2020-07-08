package com.guru99.demo.Excel_Export_And_FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadGuru99ExcelFile {
    public void readExcel(String filePath, String fileName, String sheetName) throws IOException{

        //Create an object of File class to open xlsx file
        File file = new File(fileName+"\\"+fileName); // Get path name which is contains file excel

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        Workbook guru99Workbook = null;

        //Find the file extension by splitting file name in substring and getting only extension name.
        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file
        if(fileExtensionName.equals(".xlsx")){
            //If it is xlsx file then create object of XSSFWorkbook class
            guru99Workbook = new XSSFWorkbook(inputStream);
        }

        //Check condition if the file is xls file
        else if(fileExtensionName.equals(".xls")){
            //If it is xls file then create object of HSSFWorkbook class
            guru99Workbook = new HSSFWorkbook(inputStream);
        }

        //Read sheet inside the workbook by its name
        Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

        //Find number of rows in excel file
        int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();

        //Create a loop over all the rows of excel file to read it
        for (int i = 0; i < rowCount+1; i++){
            Row row = guru99Sheet.getRow(i);
            //Create a loop to print cell values in a row
            for (int j = 0; j < row.getLastCellNum(); j++){
                //Print excel data in console
                System.out.println(row.getCell(j).getStringCellValue()+"|| ");
            }
            System.out.println();
        }
    }
}
