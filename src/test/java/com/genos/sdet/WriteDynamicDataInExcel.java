package com.genos.sdet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class WriteDynamicDataInExcel {
    
    public static void main(String[] args)
    {
        WebDriver driver = null;
        try 
        {
            String filePath = System.getProperty("user.dir")+"//resources//testdata.xlsx";
            File fileObj = new File(filePath);
            XSSFWorkbook workbook;

            if (fileObj.exists()) {
                try (FileInputStream fis = new FileInputStream(fileObj)) {
                    workbook = new XSSFWorkbook(fis);
                }
            } else {
                workbook = new XSSFWorkbook();
            }

            String sheetName = "Sheet3"; // choose the desired sheet name
            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                sheet = workbook.createSheet(sheetName);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of rows to write: ");
            int numRows = scanner.nextInt();    

            System.out.print("Enter the number of columns to write: ");
            int numCols = scanner.nextInt();    
            scanner.nextLine(); // Consume the newline character
            for (int i = 0; i < numRows; i++) {
                XSSFRow row = sheet.createRow(i);
                for (int j = 0; j < numCols; j++) {
                    System.out.print("Enter value for cell (" + i + ", " + j + "): ");
                    String cellValue = scanner.nextLine();
                    row.createCell(j).setCellValue(cellValue);
                }
            }

            FileOutputStream file = new FileOutputStream(filePath);
            workbook.write(file);
            workbook.close();
            file.close();   


        } 
        catch (Exception e) 
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
