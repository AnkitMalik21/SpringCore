package com.hcl.Bidir.ManyToMany;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_project",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> projects = new HashSet<>();

    public Employee() {
    }

    public Employee(String name) {
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

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    // Convenience methods to maintain bidirectional relationship

    public void addProject(Project project) {
        this.projects.add(project);
        project.getEmployees().add(this);  // Maintain both sides
    }

    public void removeProject(Project project) {
        this.projects.remove(project);
        project.getEmployees().remove(this);
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
        // Avoid printing projects to prevent infinite recursion
    }

    // Optional: Override equals and hashCode based on id for Set correctness
}
