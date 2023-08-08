package springbootBackend.example.springbootBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootBackend.example.springbootBackend.model.Employee;

public interface EmployeeRepository extends JpaRepository <Employee ,Long > {
}
