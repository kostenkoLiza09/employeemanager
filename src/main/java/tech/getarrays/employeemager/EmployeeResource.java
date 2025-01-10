package tech.getarrays.employeemager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemager.model.Employee;
import tech.getarrays.employeemager.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {


    private final EmployeeService employeeService;


    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee (){
        List<Employee> employeeList = employeeService.findAlEmployee();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);


    }

    @GetMapping("/add")
    public ResponseEntity<Employee> addEmployee (@RequestBody Employee e){
        Employee employee = employeeService.addEmployee(e);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("/update")
    public ResponseEntity<Employee> updateEmployee (@RequestBody Employee e){
        Employee updateEmployee = employeeService.updateEmployee(e);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee (@PathVariable("id") Long id){
       employeeService.deleteEmployee(id);
       return new ResponseEntity<>(HttpStatus.OK);
    }
}