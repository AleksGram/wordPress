package wordPress.util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Грам on 08.08.2016.
 */
public class ReadExcel {
    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

    public static Object[][] getTableArray(String FilePath, String SheetName)  {

        Object[][] tabArray = null;

        try {

            FileInputStream ExcelFile = new FileInputStream(FilePath);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            int startRow = 0;

            int startCol = 0;

            int ci, cj;

            int totalRows = ExcelWSheet.getLastRowNum();

            // you can write a function as well to get Column count

            int totalCols = 2;

            tabArray = new Object[totalRows +1][totalCols];

            ci = 0;

            for (int i = startRow; i <= totalRows; i++, ci++) {

                cj = 0;

                for (int j = startCol; j < totalCols; j++, cj++) {


                int dataType = getDataType(i, j);
                    if(dataType==1) {


                        tabArray[ci][cj] = getStringData(i, j);

                        System.out.print(tabArray[ci][cj]);
                    }
                    else{
                        tabArray[ci][cj] = getDoubleData(i, j);
                    }

                }

            }

        } catch (FileNotFoundException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        } catch (IOException e) {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return (tabArray);

    }

    public static int getDataType(int RowNum, int ColNum) throws Exception {



        Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);


        int dataType = Cell.getCellType();

        return dataType;



    }

    public static String getStringData(int RowNum, int ColNum ){
        Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
        String CellData = Cell.getStringCellValue();
        return CellData;
    }

    public static Double getDoubleData(int RowNum, int ColNum ){
        Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
        Double CellData = Cell.getNumericCellValue();
        return CellData;
    }

}



