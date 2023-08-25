package SkyProSpringStreamAPIOptionalDemo.service;

import SkyProSpringStreamAPIOptionalDemo.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class DeportmentService {
private EmployeeService employeeService;
    public DeportmentService() {
        this.employeeService = new EmployeeService();
    }

    public List<Employee> getAllByDepartment(int dep){
        return employeeService.getAll().stream()
                .filter(emp -> emp.getDepartment() == dep)
                .toList();
    }

}
