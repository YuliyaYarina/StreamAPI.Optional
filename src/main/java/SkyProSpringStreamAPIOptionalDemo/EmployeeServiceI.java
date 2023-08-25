package SkyProSpringStreamAPIOptionalDemo;

import java.util.List;
import java.util.Map;

public interface EmployeeServiceI {
    String printEmployees();
    String removeEmployee(String lastName, String firstName, String patronymicName);
    String findEmployee(String lastName, String firstName, String patronymicNam);
    Employee findMaxSalaryByDepartment(String department);
    Employee findMinSalaryByDepartment(String department);
    List<Employee> getEmployeeByDepartment(String department);
    Map<String,List<Employee>> getEmployeesByDepartmentsAll();
}
