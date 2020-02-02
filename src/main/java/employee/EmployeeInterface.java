package employee;

import io.restassured.response.Response;

public interface EmployeeInterface {

    Response createEmployee(Employee employee);

    Response getEmployee(Integer id);
}
