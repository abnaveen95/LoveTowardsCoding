package com.java.projects.controller;

import com.java.projects.entity.Employee;
import com.java.projects.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @Produces(MediaType.APPLICATION_JSON)
    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee e)
    {
        return employeeService.saveEmployee(e);
    }

    @Produces(MediaType.APPLICATION_JSON)
    @GetMapping("/getTaxDetailsOfEmployee/{empid}")
    public Employee getTaxDetailsOfEmployee(@PathVariable long empid)
    {
        return employeeService.getTaxDetailsOfEmployee(empid);
    }
}
