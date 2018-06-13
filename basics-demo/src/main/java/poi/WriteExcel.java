package poi;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.junit.After;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @author 夏飞
 */
public class WriteExcel {
    private String filePath = WriteExcel.class.getResource("/").getFile() + "workbook.xls";
    private Workbook wb = new HSSFWorkbook();;
    private Sheet sheet=wb.createSheet("1");

    @Test
    public void write1() {

        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow(1);

        // Aqua background
        CellStyle style = wb.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
        style.setFillPattern(FillPatternType.BIG_SPOTS);
        Cell cell = row.createCell(1);
        cell.setCellValue("X");
        cell.setCellStyle(style);

        // Orange "foreground", foreground being the fill foreground not the font color.
        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell = row.createCell(2);
        cell.setCellValue("X");
        cell.setCellStyle(style);


    }

    @After
    public void write() {
        try (java.io.OutputStream fileOut = new FileOutputStream(filePath)) {
            wb.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件路径"+filePath);
    }

}
