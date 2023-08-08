package springbootBackend.example.springbootBackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springbootBackend.example.springbootBackend.model.Employee;

import java.util.List;

@Service
public interface EmployeeService {
    public Employee saveEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee , long id);

    void deleteEmployee(long id);
}
