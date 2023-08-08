package springbootBackend.example.springbootBackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootBackend.example.springbootBackend.model.Employee;
import springbootBackend.example.springbootBackend.service.EmployeeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    build create employee REST API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
    return new ResponseEntity<Employee>(employeeService.saveEmployee(employee) , HttpStatus.CREATED);
    }

    // build get all  employees REST API
    @GetMapping
    private List<Employee> getEmployee(){
        return employeeService.getAllEmployees();
    }


    // build get employee by id REST API

    @GetMapping("{id}")
    public  ResponseEntity<Employee> getEmployeeId(@PathVariable("id") long employeeId){
        return  new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }
    //build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id ,
                                                @RequestBody  Employee employee){
      return new ResponseEntity<Employee>(employeeService.updateEmployee(employee , id) , HttpStatus.OK);
    }

    //build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){

      // delete employee from database
        employeeService.deleteEmployee(id);

        return new ResponseEntity<>("Employee deleted succesfully!.", HttpStatus.OK);
    }
}



