package employee;

import io.restassured.http.Cookie;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public  class EmployeeService implements EmployeeInterface {
    private static Cookie cookie;

    public Response createEmployee(Employee employee){
        Response response = given()
                .body(employee)
                .when()
                .post("/create");
        cookie = response.getDetailedCookie("PHPSESSID");
        return response;
    }

    public Response getEmployee(Integer employeeId){
        Response response = given()
                .cookie(cookie)
                .pathParam("employeeId", employeeId)
                .when()
                .get("/employee/{employeeId}");
        return response;
    }
}
