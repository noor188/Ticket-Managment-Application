package com.ticket.Ticket_Managment_System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "Name is required")
    private String name;

    @NotNull
    @NotBlank(message = "email is required")
    @Size(min = 3, max = 50, message = "email must be between 3 and 50 character")
    private String email;


    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Task> tasks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @NotBlank(message = "Name is required") String getName() {
        return name;
    }

    public void setName(@NotNull @NotBlank(message = "Name is required") String name) {
        this.name = name;
    }

    public @NotNull @NotBlank(message = "email is required") @Size(min = 3, max = 50, message = "email must be between 3 and 50 character") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @NotBlank(message = "email is required") @Size(min = 3, max = 50, message = "email must be between 3 and 50 character") String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}