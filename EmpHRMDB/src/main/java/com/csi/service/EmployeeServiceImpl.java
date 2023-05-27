package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;


    public Employee signUp(Employee employee) {
        return employeeDaoImpl.signUp(employee);
    }

    public List<Employee> getAllData() {
        return employeeDaoImpl.getAllData();
    }

    public boolean signIn(String empEmailId, String empPassword) {


        return employeeDaoImpl.signIn(empEmailId, empPassword);
    }


    public Optional<Employee> getDataById(int empId) {
        return employeeDaoImpl.getDataById(empId);

    }

    public List<Employee> getDataByEmpName(String empName) {
        return employeeDaoImpl.getDataByEmpName(empName);
    }

    public Employee getDataByEmailId(String empEmailId) {
        return employeeDaoImpl.getDataByEmailId(empEmailId);
    }

    public Employee getDataByContactNumber(long empContactNumber) {
        return employeeDaoImpl.getDataByContactNumber(empContactNumber);
    }

    public List<Employee> saveBulkOfData(List<Employee> employeeList) {
        return employeeDaoImpl.saveBulkOfData(employeeList);
    }

    public List<Employee> getDataByDOB(String empDOB) {


        return employeeDaoImpl.getDataByDOB(empDOB);
    }

    public List<Employee> sortByName() {
        return employeeDaoImpl.sortByName();
    }

    public List<Employee> sortBySalary() {
        return employeeDaoImpl.sortBySalary();

    }

    public List<Employee> sortByDOB() {
        return employeeDaoImpl.sortByDOB();
    }

    public List<Employee> getDataByUsingAnyInput(String input) {


        return employeeDaoImpl.getDataByUsingAnyInput(input);
    }

    public boolean isEligibleForLoan(int empId) {


        return employeeDaoImpl.isEligibleForLoan(empId);
    }

    public List<Employee> filterDataBySalary(double empSalary) {
        return employeeDaoImpl.filterDataBySalary(empSalary);
    }

    public Employee updateData(Employee employee) {
        return employeeDaoImpl.updateData(employee);
    }

    public void deleteDataById(int empId) {
        employeeDaoImpl.deleteDataById(empId);
    }

    public void deleteAllData() {
        employeeDaoImpl.deleteAllData();
    }

}
