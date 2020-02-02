import com.github.javafaker.Faker;
import employee.Employee;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class AddEmployeeTest extends BaseTest {
    private Employee employee;
    private Faker faker;
    @BeforeTest
    public void createData(){
        faker= new Faker();
        employee = new Employee();

        employee.setName(faker.name().firstName());
        employee.setAge(faker.number().numberBetween(18,99));
        employee.setSalary(faker.number().numberBetween(1000,10000));
    }
    @Test
    public void addEmployeeTest() throws InterruptedException {
       Integer addedEmployeeId = RestService.getRestService().getEmployeeInterface().createEmployee(employee).
                then()
                .body("status",equalTo("success"))
                .rootPath("data")
                .body("name",equalTo(employee.getName()))
                .body("age",equalTo(employee.getAge()))
                .body("salary",equalTo(employee.getSalary()))
                .statusCode(200)
                .log().all()
                .extract()
                .path("data.id");

        RestService.getRestService().getEmployeeInterface().getEmployee(addedEmployeeId).
                then()
                .body("status",equalTo("success"))
                .rootPath("data")
                .body("employee_name",equalTo(employee.getName()))
                .body("employee_age",equalTo(employee.getAge()))
                .body("employee_salary",equalTo(employee.getSalary()))
                .body("id",equalTo(addedEmployeeId))
                .statusCode(200)
                .log().all();

    }

}
