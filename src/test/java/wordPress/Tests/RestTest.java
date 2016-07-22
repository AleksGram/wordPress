package wordPress.Tests;


import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestTest extends JerseyTest {

    @Override
    protected AppDescriptor configure() {
        return new WebAppDescriptor.Builder().build();
    }

    public  JSONObject createJsoneObject(String resourse, String path){
        WebResource webResource = client().resource(resourse);
                JSONObject name = webResource.path(path)
                .get(JSONObject.class);
        return name;
    }
    public  JSONObject createJsoneObject(){
        String resourse="https://public-api.wordpress.com";
        String path="/rest/v1.1/sites/sergeywebdrivertest.wordpress.com/posts/180/likes/";

        WebResource webResource = client().resource(resourse);
        JSONObject name = webResource.path(path)
                .get(JSONObject.class);
        return name;
    }

    @Test
    public void testUserFetchesSucces1() throws JSONException {
        JSONObject json= createJsoneObject();
        Assert.assertEquals(json.get("found"), 1);

        JSONObject json1 = createJsoneObject();
        Assert.assertEquals(json1.get("found"), 0);
    }

    @Test
    public void testPosts() throws JSONException {

       JSONObject json=createJsoneObject("https://public-api.wordpress.com",
               "/rest/v1.1/sites/sergeywebdrivertest.wordpress.com/posts");
        JSONArray array = (JSONArray) json.get("posts");

        for (int i = 0; i < array.length(); i++) {

            JSONObject jsonActual = (JSONObject) array.get(i);
            Assert.assertEquals(jsonActual.get("site_ID"), 110509491);
            //System.out.println(jsonActual.get("site_ID"));


        }

    }
}
