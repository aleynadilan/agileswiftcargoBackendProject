package utilities.API_Utilities;

import java.util.HashMap;

public class TestData {

    public HashMap hubRequestBody() {

        HashMap<String, Object> requestBody = new HashMap<>();

        requestBody.put("name", "Updated Hub");
        requestBody.put("phone", "02589632141");
        requestBody.put("address", "Updated Hub address.");

        return requestBody;
    }

}
