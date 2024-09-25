package utilities.API_Utilities;

import java.util.HashMap;

public class TestData {
    HashMap<String, HashMap<String, Object>> reqBody = new HashMap<>();


    public HashMap hubRequestBody() {

        HashMap<String, Object> requestBody = new HashMap<>();

        requestBody.put("name", "Test Hub");
        requestBody.put("phone", "01000000004");
        requestBody.put("address", "Houston, Texas");

        return requestBody;
    }

}
