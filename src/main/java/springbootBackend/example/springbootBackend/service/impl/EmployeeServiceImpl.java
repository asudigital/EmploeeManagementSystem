package springbootBackend.example.springbootBackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootBackend.example.springbootBackend.exception.ResourseNotFoundException;
import springbootBackend.example.springbootBackend.model.Employee;
import springbootBackend.example.springbootBackend.repository.EmployeeRepository;
import springbootBackend.example.springbootBackend.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new ResourseNotFoundException("Employee" , "id" , id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {

        // we need to check whether employee is exist in DB or not

        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                ()-> new ResourseNotFoundException("Employee", "Id" ,id )
        );
        existingEmployee.setFirstname(employee.getFirstname() );
        existingEmployee.setLastName((employee.getLastName()) );
        existingEmployee.setEmail(employee.getEmail());
        // save existing employee to DB
        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {

        // check whether a employee exist in a DB or not
        employeeRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("Employee","ID",id));

        employeeRepository.deleteById(id);
    }


}
