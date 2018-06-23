package poi;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFSheet;
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
    private String filePath = WriteExcel.class.getResource("/").getFile() + "workbook-write.xls";
    private HSSFWorkbook wb = new HSSFWorkbook();
    ;
    private HSSFSheet sheet = wb.createSheet("1");

    /**
     * 品牌	商品名称	售价	采购价	供应商	属性:品牌	属性:规格	属性:速度级别	属性:载重系数	属性:原配标识	属性:轮辋保护	属性:防爆标识	属性:承载加强	属性:花纹	属性:轮胎特点	属性:轮辋直径	属性:断面宽	属性:扁平比	属性:防爆胎	属性:关联花纹	属性:车辆类型
     */
    @Test
    public void write3() {
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("品牌");
        row.createCell(1).setCellValue("商品名称");
        row.createCell(2).setCellValue("售价");
        row.createCell(3).setCellValue("采购价");
        row.createCell(4).setCellValue("供应商");
        row.createCell(5).setCellValue("属性:品牌");
        row.createCell(6).setCellValue("属性:规格");
        row.createCell(7).setCellValue("属性:速度级别");
        row.createCell(8).setCellValue("属性:车辆类型");
        row.createCell(9).setCellValue("属性:车辆类型 车辆类型");
        for (int i = 0; i < 10; i++) {
            sheet.autoSizeColumn(i);
        }


    }

    @Test
    public void write2() {
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("hehhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        sheet.autoSizeColumn(0);

    }

    @Test
    public void write1() {

        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow(1);

        // Aqua background
        CellStyle style = wb.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
        style.setFillPattern(FillPatternType.BIG_SPOTS);
        Cell cell = row.createCell(1);
        cell.setCellValue("Xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        cell.setCellStyle(style);

        // Orange "foreground", foreground being the fill foreground not the font color.
        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell = row.createCell(2);
        cell.setCellValue("X");
        cell.setCellStyle(style);
        sheet.autoSizeColumn(1);

    }

    @After
    public void write() {
        try (java.io.OutputStream fileOut = new FileOutputStream(filePath)) {
            wb.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件路径" + filePath);
    }

}
