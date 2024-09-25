package base;

import config_Requirements.ConfigLoader;
import config_Requirements.ExcelDataReader;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;

public abstract class BaseTest {

    protected static ConfigLoader configLoader;
    protected static ExcelDataReader excelData;

    protected static JsonPath repJP;
    protected static Response response;
    protected static HashMap map;

    protected JSONObject requestBody;

    public BaseTest() {
        requestBody = new JSONObject();
        map = new HashMap<>();
        configLoader = new ConfigLoader();
        excelData = new ExcelDataReader("src/test/resources/testData/testData.xlsx", "Data");
    }
}
