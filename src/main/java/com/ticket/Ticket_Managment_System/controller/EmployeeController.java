package com.ticket.Ticket_Managment_System.controller;

import com.ticket.Ticket_Managment_System.model.Employee;
import com.ticket.Ticket_Managment_System.model.Task;
import com.ticket.Ticket_Managment_System.service.EmployeeService;
import com.ticket.Ticket_Managment_System.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TaskService taskService;


    @GetMapping
    public String getAllEmployees(Model model){
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping("/new")
    public String showEmployeeCreationForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEmployeeEditForm(@PathVariable Long id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    @GetMapping("/tasks")
    public String employeeTaskHub(Principal principal, Model model) {
        Employee employee = employeeService.findByEmail(principal.getName());
        List<Task> tasks = taskService.getTasksByEmployee(employee);
        model.addAttribute("tasks", tasks);
        model.addAttribute("employee", employee);
        return "task-hub";
    }

    // Employee updating the task status
    @PostMapping("/tasks/update-status")
    public String updateTaskStatus(@RequestParam Long taskId, @RequestParam String status) {
        taskService.updateTaskStatus(taskId, status);
        return "redirect:/employees/tasks";  // Redirect back to employee's task hub
    }
}
