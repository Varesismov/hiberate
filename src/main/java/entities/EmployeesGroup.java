package entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class EmployeesGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //inkrementacja id przy tworzeniu
    private int id;

    private String group_name;

    private double group_max_size;
    @OneToMany(mappedBy = "employeesGroup",cascade = CascadeType.PERSIST)
    private List<Employee> employee_list;

    public void addEmployee(Employee employee){
        if(this.group_max_size < employee_list.size()){
            System.err.println("za mało miejsca");;
        }
        else{
            employee_list.add(employee);
            employee.setEmployeesGroup(this);
        }
    }
    public EmployeesGroup() {
        this.employee_list = new ArrayList<>();



    }

    public EmployeesGroup(String group_name, double group_max_size, List<Employee> employee_list) {
        this.group_name = group_name;
        this.group_max_size = group_max_size;
        this.employee_list = employee_list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public double getGroup_max_size() {
        return group_max_size;
    }

    public void setGroup_max_size(double group_max_size) {
        this.group_max_size = group_max_size;
    }

    public List<Employee> getEmployee_list() {
        return employee_list;
    }

    public void setEmployee_list(List<Employee> employee_list) {
        this.employee_list = employee_list;
    }
}
