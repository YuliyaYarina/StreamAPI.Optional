package SkyProSpringStreamAPIOptionalDemo.controller;

import SkyProSpringStreamAPIOptionalDemo.Employee;
import SkyProSpringStreamAPIOptionalDemo.service.DeportmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DeportmentController {

    private final DeportmentService deportmentService;

    public DeportmentController(DeportmentService deportmentService) {
        this.deportmentService = deportmentService;
    }

    ///departments/all?departmentId=5
    @GetMapping()
    public List<Employee> getAllByDepartment(@RequestParam int x){
        return deportmentService.getAllByDepartment(x);
    }

}
