
package wordPress.util;
import java.io.*;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * Created by Грам on 07.07.2016.
 */

public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

    public static Object[][] getTableArray(String FilePath, String SheetName)  {

        String[][] tabArray = null;

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

            tabArray = new String[totalRows +1][totalCols];

            ci = 0;

            for (int i = startRow; i <= totalRows; i++, ci++) {

                cj = 0;

                for (int j = startCol; j < totalCols; j++, cj++) {



                    tabArray[ci][cj] = getCellData(i, j);

                    System.out.print(tabArray[ci][cj]);

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

    public static String getCellData(int RowNum, int ColNum) throws Exception {



            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

            int dataType = Cell.getCellType();
        System.out.println("Data Type= "+dataType);








                String CellData = Cell.getStringCellValue();

                return CellData;



        }

    }



