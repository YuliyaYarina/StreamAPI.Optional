package SkyProSpringStreamAPIOptionalDemo.controller;

import SkyProSpringStreamAPIOptionalDemo.Employee;
import SkyProSpringStreamAPIOptionalDemo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
///departments/max-salary?departmentId=5

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        System.out.println(responseEntity);
        return responseEntity;
    }
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping( "/")
    public String helloy(){
        return "hello";
    }



//    @GetMapping(path = "/max-salary")
//    public Employee maxSalary(@RequestParam Integer departmentId){
//        return employeeService.findEmployeeWitMaxSalary();
//    }
//
//    @GetMapping(path = "/min-salary")
//    public Employee minSalary(@RequestParam Integer departmentId){
//        return employeeService.findMinSalaryByDepartment(departmentId);
//    }
//
//    @GetMapping(path = "/all")
//    public Employee allDepartmentId(@RequestParam Integer departmentId){
//        return employeeService.getEmployeeByDepartment();
//    }
//
    @GetMapping(path = "/all")
    public Collection<Employee> all(){
        return employeeService.getAll();
    }
    @GetMapping(path = "/generate")
    public void generate(@RequestParam int x ){
        employeeService.ZapolnenieColl(x);
    }

}
