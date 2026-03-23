package com.genos.sdet;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class WriteDataInToExcel {

    public static void main(String[] args)
    {
        WebDriver driver = null;

        try 
        {
            FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"//resources//testdata.xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sheet2");

            XSSFRow row1 = sheet.createRow(0);
            row1.createCell(0).setCellValue("Batter");
            row1.createCell(1).setCellValue("Bowler");
            row1.createCell(2).setCellValue("All-Rounder");

            XSSFRow row2 = sheet.createRow(1);
            row2.createCell(0).setCellValue("samson");
            row2.createCell(1).setCellValue("Noor");
            row2.createCell(2).setCellValue("Overton");

            XSSFRow row3 = sheet.createRow(2);
            row3.createCell(0).setCellValue("Rohit");
            row3.createCell(1).setCellValue("Bumrah");
            row3.createCell(2).setCellValue("Santner");

            XSSFRow row4 = sheet.createRow(3);
            row4.createCell(0).setCellValue("Virat");
            row4.createCell(1).setCellValue("Hazlewood");
            row4.createCell(2).setCellValue("Krunal");

            workbook.write(file);
            workbook.close();
            file.close();


        } 
        catch (Exception e) 
        {
            System.err.println("Test Failed :" + e.getMessage());
            e.printStackTrace();
        }

        finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Browser closed successfully");
            }
        }
    }
    
}
