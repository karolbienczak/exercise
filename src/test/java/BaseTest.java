import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {
    private static final String API_URI = "http://dummy.restapiexample.com/";
    private static final String API_PATH = "api/v1";

    @BeforeSuite
    public void setUp(){
        RestAssured.baseURI = API_URI;
        RestAssured.basePath = API_PATH;
    }
}
