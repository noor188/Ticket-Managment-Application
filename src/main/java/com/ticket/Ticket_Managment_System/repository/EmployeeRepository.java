package com.ticket.Ticket_Managment_System.repository;
import com.ticket.Ticket_Managment_System.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
