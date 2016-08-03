package wordPress.util;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import wordPress.TestNgTestBase;

import java.io.*;

/**
 * Created by Грам on 03.08.2016.
 */
public class WriteRead {

    public void writeJson(String writePath, JSONObject json) throws IOException {
        FileWriter file = new FileWriter(writePath);
        file.write(json.toString());
        file.flush();
        file.close();
    }

    public JSONObject readJson(String readPath) throws IOException, JSONException {
        String expectedJson;
        BufferedReader br = new BufferedReader(new FileReader(readPath));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            expectedJson = sb.toString();
        } finally {
            br.close();
        }

       JSONObject jsonExp = new JSONObject(expectedJson);
        return jsonExp;

    }
}