package com.example.day4assignspringemployeepayroll.service;

import com.example.day4assignspringemployeepayroll.dto.EmployeeDTO;
import com.example.day4assignspringemployeepayroll.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements iEmployeeService{
    private List<Employee> employeeList = new ArrayList<>();
//    @Autowired
//    private EmployeeRepository employeeRepository;
//    @Override
//    public String EmployeeMessage(){
//        return "Hello World!";
//    }
//    //    *****UC2*****
//    @Override
//    public Employee findEmployeeById(Integer id) {
//        return employeeRepository.findById(id).orElse(null);
//    }
//    @Override
//    public Employee saveEmployees(Employee employee){
//        return employeeRepository.save(employee);
//    }
//    @Override
//    public List<Employee> findEmployees() {
//        return employeeRepository.findAll();
//    }
//    @Override
//    public Employee editEmployee(Employee employee, Integer id) {
//        Employee existingGreet = employeeRepository.findById(id).orElse(null);
//        if (existingGreet != null) {
//            existingGreet.setName(employee.getName()); ;
//            return employeeRepository.save(existingGreet);
//        }else return null;
//    }
//    @Override
//    public String deleteEmployee(Integer id) {
//        employeeRepository.deleteById(id);
//        return "Data Deleted";
//    }

    //UC4
//    @Override
//    public List<Employee> getEmployeeData() {
//        List<Employee> empDataList = new ArrayList<>();
//        empDataList.add(new Employee(1, new EmployeeDTO("Roshni", "female", "Engg.", 35000)));
//        return empDataList;
//    }
//    @Override
//    public Employee getEmployeePayrollDataById(int empId) {
//        Employee  empData= null;
//        empData= new Employee (1, new EmployeeDTO("Roshni", "female", "Eng", 35000));
//        return empData;
//    }
//    @Override
//    public Employee createEmployeePayrollData(EmployeeDTO employeeDTO){
//        Employee empData= null;
//        empData= new Employee(1, employeeDTO);
//        return empData;
//    }
//    @Override
//    public Employee updateEmployeePayrollData(EmployeeDTO employeeDTO) {
//        Employee empData= null;
//        empData = new Employee(1, employeeDTO);
//        return empData;
//    }
//
//    public void deleteEmployeePayrollData(int empID) {
//    }

    @Override
    public List<Employee> getEmployeeData() {
        return employeeList;
    }
    @Override
    public Employee getEmployeePayrollDataById(int empId) {
        return employeeList.get(empId-1);
    }
    @Override
    public Employee createEmployeePayrollData(EmployeeDTO employeeDTO){
        Employee empData= null;
        empData= new Employee(employeeList.size()+1, employeeDTO);
        employeeList.add(empData);
        return empData;
    }
    @Override
    public Employee updateEmployeePayrollData(int empId, EmployeeDTO employeeDTO) {
        Employee empData = this.getEmployeePayrollDataById(empId);
        empData.setName(employeeDTO.name);
        empData.setSalary(employeeDTO.salary);
        employeeList.set(empId - 1, empData);
        return empData;
    }
    @Override
    public void deleteEmployeePayrollData(int empID) {
        employeeList.remove(empID-1);
    }
}
