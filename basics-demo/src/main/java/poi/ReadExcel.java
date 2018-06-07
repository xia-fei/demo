package poi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;

import java.io.IOException;
import java.io.InputStream;


public class ReadExcel {

    public static void main(String[] args) throws IOException, InvalidFormatException {
        DataFormatter formatter = new DataFormatter();
        InputStream inputStream=ReadExcel.class.getResourceAsStream("demo.xlsx");
        Workbook wb = WorkbookFactory.create(inputStream);
        inputStream.close();

        Sheet sheet = wb.getSheetAt(0);
        for (Row row : sheet) {
            for (Cell cell : row) {
                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                System.out.print(cellRef.formatAsString());
                System.out.print(" - ");

                // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
                String text = formatter.formatCellValue(cell);
                System.out.println(text);

                // Alternatively, get the value and format it yourself
                switch (cell.getCellTypeEnum()) {
                    case STRING:
                        System.out.println(cell.getRichStringCellValue().getString());
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            System.out.println(cell.getDateCellValue());
                        } else {
                            System.out.println(cell.getNumericCellValue());
                        }
                        break;
                    case BOOLEAN:
                        System.out.println(cell.getBooleanCellValue());
                        break;
                    case FORMULA:
                        System.out.println(cell.getCellFormula());
                        break;
                    case BLANK:
                        System.out.println();
                        break;
                    default:
                        System.out.println();
                }
            }
        }
    }


}



