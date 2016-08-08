package wordPress.util;

import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class DataProviders {

    @DataProvider(name = "getJson")
    public static Iterator<Object[]> remoteServiceDataProvider(Method m) throws ParseException, IOException {

        DataSource sourceAnnotation = m.getAnnotation(DataSource.class);
        final String jsonFile = sourceAnnotation.json();


        Collection<Object[]> dp = new ArrayList<Object[]>() {
            {
                BufferedReader br = new BufferedReader(new FileReader(jsonFile));
                try {
                    String line = br.readLine();
                    while (line != null) {
                        add(new Object[]{line});
                        //add(new Object[]{line,br.readLine() });
                        line = br.readLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    br.close();
                }
            }
        };

        return dp.iterator();
    }

    @DataProvider(name = "ExcelData", parallel = false)



  public static Object[][] credentials(Method m)  throws ParseException, IOException{
        DataSource sourceAnnotation = m.getAnnotation(DataSource.class);
        final String excelFile = sourceAnnotation.xls();


        Object[][] testObjArray = ExcelUtils.getTableArray(excelFile, "Лист1");
        return testObjArray;
    }

}

