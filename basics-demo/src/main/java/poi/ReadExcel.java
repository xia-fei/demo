package poi;

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
    private String filePath = WriteExcel.class.getResource("/").getFile() + "workbook.xls";
    private Workbook wb =WorkbookFactory.create(new File(filePath));;
    private Sheet sheet=wb.getSheetAt(0);

    public ReadExcel() throws IOException, InvalidFormatException {
    }

    @Test
    public void read1() {
        Cell cell=sheet.getRow(1).getCell(3);
        System.out.println(cell);
    }



}



