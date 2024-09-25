package config_Requirements;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataReader {

    private Workbook workbook;
    private Sheet sheet;

    public ExcelDataReader(String filePath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            workbook = new XSSFWorkbook(fis); // XLSX formatı için
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCellData(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        return cell.getStringCellValue();
    }

    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public int getColumnCount(int rowNum) {
        return sheet.getRow(rowNum).getPhysicalNumberOfCells();
    }
}
