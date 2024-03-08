package entities;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //inkrementacja id przy tworzeniu
    private int id;



    private String first_name;

    private String last_name;

    private double salary;

    private double birth;

    @ManyToOne
    @JoinColumn(name = "employeesGroup")
    private EmployeesGroup employeesGroup;

    public Employee() {
    }

    public Employee(String first_name, String last_name, double salary, double birth, EmployeesGroup employeesGroup) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
        this.birth = birth;
        this.employeesGroup = employeesGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBirth() {
        return birth;
    }

    public void setBirth(double birth) {
        this.birth = birth;
    }

    public EmployeesGroup getEmployeesGroup() {
        return employeesGroup;
    }

    public void setEmployeesGroup(EmployeesGroup employeesGroup) {
        this.employeesGroup = employeesGroup;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", salary=" + salary +
                ", birth=" + birth +
                ", employeesGroup=" + employeesGroup +
                '}';
    }
}
