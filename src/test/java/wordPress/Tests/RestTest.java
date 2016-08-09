package wordPress.Tests;


import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import wordPress.TestNgTestBase;
import wordPress.util.DataProviders;
import wordPress.util.DataSource;
import wordPress.util.ExcelUtils;
import wordPress.util.WriteRead;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RestTest extends TestNgTestBase {

    @Override
    protected AppDescriptor configure() {
        return new WebAppDescriptor.Builder().build();
    }


    @Test(enabled = false)
    public void testUserFetchesSucces1() throws JSONException {
        JSONObject json = createJsoneObject("/rest/v1.1/sites/grammsite.wordpress.com/posts");
        Assert.assertEquals(json.get("found"), 1);

        JSONObject json1 = createJsoneObject("/rest/v1.1/sites/grammsite.wordpress.com/posts");
        Assert.assertEquals(json1.get("found"), 0);
    }

    @Test(enabled = false)
    public void testPosts() throws JSONException {

        JSONObject json = createJsoneObject("/rest/v1.1/sites/grammsite.wordpress.com/posts");
        JSONArray array = (JSONArray) json.get("posts");

        for (int i = 0; i < array.length(); i++) {

            JSONObject jsonActual = (JSONObject) array.get(i);
            Assert.assertEquals(jsonActual.get("site_ID"), 110509491);
            //System.out.println(jsonActual.get("site_ID"));


        }

    }

    @Test(dataProvider = "getJson", dataProviderClass = DataProviders.class)
    @DataSource(json = "src\\test\\resources/posts.json")

    public void testWordPressAPI(String expectedJson) throws IOException, JSONException {
        // WriteRead wr = new WriteRead();
        JSONObject json = createJsoneObject("/rest/v1.1/sites/grammsite.wordpress.com/posts");

        /* To write a file

        wr.writeJson("src\\test\\resources/posts.json", json);

        System.out.println("Successfully Copied JSON Object to File...");
        System.out.println("\nJSON Object: " + json);
*/
        //TO Read json

        // JSONObject jsonExp = wr.readJson("src\\test\\resources/posts.json");

        JSONObject jsonExp = new JSONObject(expectedJson);
        Assert.assertEquals(json.getJSONArray("posts").getJSONObject(0).getJSONObject("author").get("ID"),
            jsonExp.getJSONArray("posts").getJSONObject(0).getJSONObject("author").get("ID"), "Good message to understand");

    }


    @Test(dataProvider = "ExcelData", dataProviderClass = DataProviders.class)
    @DataSource(xls = "src\\test\\resources\\ApiData.xlsx")

    public void testWeatherAPI(String resourceUrl, String pathRequest, String querPar1, String querVal1,
                               String querPar2, String querVal2, String expValue) throws JSONException {

       /* WebResource webResource = client().resource("http://api.openweathermap.org");
        JSONObject json =
                webResource.path("/data/2.5/weather").queryParam("id",idValue)
                        .queryParam("APPID","c5ab9ff131b9aa83256a683780587926")
                        .get(JSONObject.class);*/
        JSONObject json = createJsnObjWithQuerPar(resourceUrl, pathRequest, querPar1, querVal1, querPar2, querVal2);
        Assert.assertEquals(expValue, json.get("name"));

    }


}
