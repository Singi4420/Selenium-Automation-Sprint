package com.genos.sdet;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ReadDataFromExcel {


    public static void main(String[] args)
    {
        WebDriver driver = null;

        try
        {
           

            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//resources//testdata.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheet("Sheet2");
            int lastRowNum = sheet.getLastRowNum();
            System.out.println("Total rows in the sheet: " + lastRowNum);   
            int lastCellNum = sheet.getRow(1).getLastCellNum();
            System.out.println("Total columns in the sheet: " + lastCellNum);

            for( int i=0; i<=lastRowNum; i++)
            {
                XSSFRow row =sheet.getRow(i);
                for(int j=0; j<lastCellNum; j++)
                {
                   XSSFCell cellValue= row.getCell(j);
                    
                    System.out.print(cellValue.toString() +  "\t"); // Print cell value followed by a tab space
                }
                System.out.println(); // Print a new line after each row
            }

            workbook.close();
            file.close();



        }
        catch(Exception e)
        {
            System.err.println("Test Failed :" + e.getMessage());
            e.printStackTrace();

        }
        finally
        {
            if(driver != null)
            {
                driver.quit();
                System.out.println("Browser closed successfully");
            }
        }
    }
    
}
