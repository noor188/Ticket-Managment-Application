package com.ticket.Ticket_Managment_System.controller;

import com.ticket.Ticket_Managment_System.model.Employee;
import com.ticket.Ticket_Managment_System.model.Task;
import com.ticket.Ticket_Managment_System.service.EmployeeService;
import com.ticket.Ticket_Managment_System.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String getAllTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "task-list";
    }

    @GetMapping("/new")
    public String showTaskCreationForm(Model model){
        Task task = new Task();
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("task", task);
        model.addAttribute("employees", employees);
        return "task-form";
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task") Task task){
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String showTaskEditForm(@PathVariable Long id, Model model){
        Task task = taskService.getTaskById(id);
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("task", task);
        model.addAttribute("employees", employees);
        return "task-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id){
        Task task = taskService.getTaskById(id);
        taskService.deleteTask(task);
        return "redirect:/tasks";
    }
}
