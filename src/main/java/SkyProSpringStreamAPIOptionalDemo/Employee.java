package SkyProSpringStreamAPIOptionalDemo;

import java.util.List;
import java.util.Objects;

public class Employee {

    private static int idGenerator = 1;
    private final int id;
    private final String fullName;
    private int department;
    private int selary;

    public Employee(String fullName, int department, int selary) {
        this.id = idGenerator++;
        this.fullName = fullName;
        this.department = department;
        this.selary = selary;
    }

    public static int getIdGenerator() {
        return idGenerator;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSelary() {
        return selary;
    }

    @Override
    public String toString() {
        return String.format("id: %d, ФИО: %s, ЗП: %d, № отдела: %d", id, fullName, selary, department);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && department == employee.department && selary == employee.selary && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, department, selary);
    }
}
