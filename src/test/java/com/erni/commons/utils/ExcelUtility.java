package com.erni.commons.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for Excel file manipulation
 * 
 * @author faju
 *
 */
public class ExcelUtility {

    private static final Logger logger = LoggerFactory.getLogger(ExcelUtility.class);

    /**
     * Reads test data from the specified Excel file.
     *
     * @param filePath   The path of the Excel file.
     * @param sheetName  The name of the Excel sheet containing the test data.
     * @return A list of maps representing test data, where each map represents a row of data.
     * @throws IOException If an error occurs while reading the Excel file.
     */
    public static List<Map<String, String>> readTestDataFromExcel(String filePath, String sheetName) throws IOException {
        List<Map<String, String>> testDataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet with name '" + sheetName + "' not found.");
            }

            Row headerRow = sheet.getRow(0);
            List<String> columnHeaders = new ArrayList<>();
            for (Cell cell : headerRow) {
                columnHeaders.add(cell.getStringCellValue());
            }

            for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
                Row dataRow = sheet.getRow(rowIndex);
                Map<String, String> rowData = new HashMap<>();
                for (int columnIndex = 0; columnIndex < columnHeaders.size(); columnIndex++) {
                    Cell cell = dataRow.getCell(columnIndex, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    String header = columnHeaders.get(columnIndex);
                    String cellValue = cell == null ? "" : cell.getStringCellValue();
                    rowData.put(header, cellValue);
                }
                testDataList.add(rowData);
            }
        } catch (IOException e) {
            logger.error("Error reading test data from Excel: {}", e);
        }

        return testDataList;
    }
}
