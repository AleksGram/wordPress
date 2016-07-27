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
import wordPress.TestNgTestBase;

public class RestTest extends TestNgTestBase {

    @Override
    protected AppDescriptor configure() {
        return new WebAppDescriptor.Builder().build();
    }



    @Test
    public void testUserFetchesSucces1() throws JSONException {
        JSONObject json= createJsoneObject("/rest/v1.1/sites/grammsite.wordpress.com/posts");
        Assert.assertEquals(json.get("found"), 1);

        JSONObject json1 = createJsoneObject("/rest/v1.1/sites/grammsite.wordpress.com/posts");
        Assert.assertEquals(json1.get("found"), 0);
    }

    @Test
    public void testPosts() throws JSONException {

       JSONObject json=createJsoneObject("/rest/v1.1/sites/grammsite.wordpress.com/posts");
        JSONArray array = (JSONArray) json.get("posts");

        for (int i = 0; i < array.length(); i++) {

            JSONObject jsonActual = (JSONObject) array.get(i);
            Assert.assertEquals(jsonActual.get("site_ID"), 110509491);
            //System.out.println(jsonActual.get("site_ID"));


        }

    }
}
