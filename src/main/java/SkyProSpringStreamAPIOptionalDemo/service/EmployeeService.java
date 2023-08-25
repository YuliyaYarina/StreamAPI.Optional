package SkyProSpringStreamAPIOptionalDemo.service;

import SkyProSpringStreamAPIOptionalDemo.Employee;
import SkyProSpringStreamAPIOptionalDemo.EmployeeServiceI;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;







@Service
public class EmployeeService {

    private final Map<String, Employee> employees;

    private static final String[] NAMES ={"Александр", "Евгений", "Артем", "Андрей", "Михаил"};
    private static final String[] SURNAMES ={"Алексеев", "Иванов", "Попов", "Пупкин", "Горбачев"};
    private static final String[] PATRONYMIC_NAMES ={"Александрович", "Евгеньевич", "Петрович", "Андреевич", "Михайлович"};

    private static final Random RANDOM = new Random(14);
    private static List<Employee> getEmployee;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }



    private static Employee generateEmployee() {
                String fullName = SURNAMES[RANDOM.nextInt(SURNAMES.length)] +
                " " + NAMES[RANDOM.nextInt(NAMES.length)] +
                " " + PATRONYMIC_NAMES[RANDOM.nextInt(PATRONYMIC_NAMES.length)];
        int minDepartment = 1;
        int maxDepartment = 5;
        int department = minDepartment + RANDOM.nextInt(maxDepartment - minDepartment +1);
        int minSalary = 30_000;
        int maxSalary = 80_000;
        int salary = minSalary + RANDOM.nextInt(maxSalary - minSalary +1);
        return new Employee(
                fullName,
                department,
                salary
        );
    }
    public void ZapolnenieColl(int x){
//        employees.put()
        for (int i = 0; i < x; i++) {
            Employee employee = generateEmployee();
            employees.put(employee.getFullName(),employee);
        }
    }
    public  Collection<Employee> getAll(){
        return employees.values();
    }

//    @Override
//    public Employee addEmployee(String fullName, int salary, int department) {
//
//        validateInput(fullName);
//
//        if (employeeMap.containsKey(fullName)) {
//            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
//        }
//        employeeMap.put((fullName),new Employee(fullName, salary, department));
//        return employeeMap.get(fullName);
//    }
    private int calculateTotalSalaries() {
        int sum = 0;
        for (Employee value : employees.values()) {
            sum += value.getSelary();
        }
        return sum;
    }

    private Employee findEmployeeWitMinSalary() {
        Employee employee = null;
        int minSalary = Integer.MAX_VALUE;
        for (Employee value : employees.values()) {
            if (value.getSelary() < minSalary) {
                minSalary = value.getSelary();
                employee = value;
            }
        }
        return employee;
    }

}
