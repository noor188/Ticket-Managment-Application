package com.ticket.Ticket_Managment_System.repository;

import com.ticket.Ticket_Managment_System.model.Employee;
import com.ticket.Ticket_Managment_System.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    public Task findByEmployee(Employee employee);
    public List<Task> getTasksByEmployee(Employee employee);
}
