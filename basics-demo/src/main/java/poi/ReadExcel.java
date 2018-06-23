package poi;

import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class ReadExcel {
    private String filePath = WriteExcel.class.getResource("/").getFile() + "workbook-read.xls";
    private Workbook wb =WorkbookFactory.create(new File(filePath));;
    private Sheet sheet=wb.getSheetAt(0);

    public ReadExcel() throws IOException, InvalidFormatException {
    }
    @Test
    public void read2() {
        Cell cell=sheet.getRow(1).getCell(0);
        System.out.println(getCellString(cell));
        cell=sheet.getRow(1).getCell(1);
        System.out.println(getCellString(cell));
    }

    @Test
    public void read1() {
        Cell cell=sheet.getRow(1).getCell(3);
        System.out.println(cell);
    }

    public String getCellString(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellTypeEnum()) {
            case STRING:
                return cell.getRichStringCellValue().getString();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    DataFormatter dataFormatter = new DataFormatter();
                    return dataFormatter.formatCellValue(cell);
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return cell.toString();
        }
    }



}



