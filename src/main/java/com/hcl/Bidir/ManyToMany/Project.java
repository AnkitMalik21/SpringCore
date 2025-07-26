package com.hcl.Bidir.ManyToMany;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL)
    private Set<Employee> employees = new HashSet<>();

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    // Getter and Setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    // Convenience methods for bidirectional relationship

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
        employee.getProjects().add(this);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
        employee.getProjects().remove(this);
    }

    @Override
    public String toString() {
        return "Project [id=" + id + ", name=" + name + "]";
        // Avoid printing employees to prevent recursion
    }

    // Optional: Override equals and hashCode based on id
}
