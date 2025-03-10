package com.ticket.Ticket_Managment_System.service;

import com.ticket.Ticket_Managment_System.model.Employee;
import com.ticket.Ticket_Managment_System.model.Task;
import com.ticket.Ticket_Managment_System.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void saveTask(Task task){
        taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    public Task getTaskByEmployee(Employee employee){
        return taskRepository.findByEmployee(employee);
    }

    public void deleteTask(Task task){
        taskRepository.delete(task);
    }

    public void updateTaskStatus(Long taskId, String status){
        Task task = getTaskById(taskId);
        task.setStatus(status);
        taskRepository.save(task);
    }

    public List<Task> getTasksByEmployee(Employee employee){
        return taskRepository.getTasksByEmployee(employee);
    }
}
