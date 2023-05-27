package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepository employeeRepositoryImpl;


    public Employee signUp(Employee employee) {
        return employeeRepositoryImpl.save(employee);
    }

    public List<Employee> getAllData() {
        return employeeRepositoryImpl.findAll();
    }

    public boolean signIn(String empEmailId, String empPassword) {
        boolean flag = false;

        for (Employee employee : getAllData()) {
            if (employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {

                flag = true;
                break;
            }
        }

        return flag;
    }


    public Optional<Employee> getDataById(int empId) {
        return employeeRepositoryImpl.findById(empId);

    }

    public List<Employee> getDataByEmpName(String empName) {
        return employeeRepositoryImpl.findByEmpName(empName);
    }

    public Employee getDataByEmailId(String empEmailId) {
        return getAllData().stream().filter(emp -> emp.getEmpEmailId().equals(empEmailId)).collect(Collectors.toList()).get(0);
    }

    public Employee getDataByContactNumber(long empContactNumber) {
        return employeeRepositoryImpl.findByEmpContactNumber(empContactNumber);
    }

    public List<Employee> saveBulkOfData(List<Employee> employeeList) {
        return employeeRepositoryImpl.saveAll(employeeList);
    }

    public List<Employee> getDataByDOB(String empDOB) {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        List<Employee> employees = new ArrayList<>();

        for (Employee employee : getAllData()) {

            String dbDOB = simpleDateFormat.format(employee.getEmpDOB());

            if (empDOB.equals(dbDOB)) {
                employees.add(employee);
            }
        }

        return employees;
    }

    public List<Employee> sortByName() {
        return getAllData().stream().sorted(Comparator.comparing(Employee::getEmpName)).collect(Collectors.toList());
    }

    public List<Employee> sortBySalary() {
        return getAllData().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).collect(Collectors.toList());

    }

    public List<Employee> sortByDOB() {
        return getAllData().stream().sorted(Comparator.comparing(Employee::getEmpDOB)).collect(Collectors.toList());
    }

    public List<Employee> getDataByUsingAnyInput(String input) {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");


        List<Employee> employeeList = new LinkedList<>();
        for (Employee employee : getAllData()) {

            String dbDOB = simpleDateFormat.format(employee.getEmpDOB());
            if (employee.getEmpName().equals(input)
                    || String.valueOf(employee.getEmpId()).equals(input)
                    || employee.getEmpEmailId().equals(input)
                    || String.valueOf(employee.getEmpContactNumber()).equals(input)
                    || dbDOB.equals(input)) {
                employeeList.add(employee);
            }
        }

        return employeeList;
    }

    public boolean isEligibleForLoan(int empId) {

        boolean flag = false;

        for (Employee employee : getAllData()) {
            if (employee.getEmpId() == empId && employee.getEmpSalary() >= 50000) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    public List<Employee> filterDataBySalary(double empSalary) {
        return getAllData().stream().filter(emp -> emp.getEmpSalary() >= empSalary).collect(Collectors.toList());
    }

    public Employee updateData(Employee employee) {
        return employeeRepositoryImpl.save(employee);
    }

    public void deleteDataById(int empId) {
        employeeRepositoryImpl.deleteById(empId);
    }

    public void deleteAllData() {
        employeeRepositoryImpl.deleteAll();
    }

}
