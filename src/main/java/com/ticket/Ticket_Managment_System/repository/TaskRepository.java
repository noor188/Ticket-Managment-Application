package com.ticket.Ticket_Managment_System.repository;

import com.ticket.Ticket_Managment_System.model.Employee;
import com.ticket.Ticket_Managment_System.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    public Task findByEmployee(Employee employee);
}
