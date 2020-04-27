import demo.EmployeeRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class Employee {
    @Test
    public void getEmployee(){
        Response response = RestAssured
                .given()
                .baseUri("http://dummy.restapiexample.com")
                .basePath("/api")
                .log()
                .all()
                .header("Content-type", "application/json")
                .get("/v1/employees");

        response.getBody().prettyPrint();
        System.out.println(response.getStatusCode());
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void createEmployee(){
//        String requestBody = "{\n" +
//                "  \"name\": \"Dana\",\n" +
//                "  \"salary\": \"123\",\n" +
//                "  \"age\": \"23\"\n" +
//                "}";

        EmployeeRequest employeeRequest = new EmployeeRequest();
        employeeRequest.setName("Aguunng");
        employeeRequest.setAge("20");
        employeeRequest.setSalary("5000");

        Response response = RestAssured
                .given()
                .baseUri("http://dummy.restapiexample.com")
                .basePath("/api")
                .log()
                .all()
                .header("Content-type", "application/json")
                .header("Accept", "*/*")
//                .body(requestBody)
                .post("/v1/create");

        response.getBody().prettyPrint();
        System.out.println(response.getStatusCode());
        Assert.assertEquals(200, response.getStatusCode());
    }
}
