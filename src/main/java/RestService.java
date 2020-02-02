import employee.EmployeeInterface;
import employee.EmployeeService;

public class RestService {
    private EmployeeInterface employeeInterface;

    private RestService(){
        employeeInterface = new EmployeeService();
    }

    public static RestService getRestService() {
        return new RestService();
    }

    public EmployeeInterface getEmployeeInterface() {
        return employeeInterface;
    }
}
