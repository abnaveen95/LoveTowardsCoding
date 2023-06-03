package com.java.projects.service;

import com.java.projects.entity.Employee;
import com.java.projects.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee e)
    {
        return employeeRepository.save(e);
    }
    public Employee getTaxDetailsOfEmployee(long empid)
    {
        double cessRate = 0.04;
        Optional<Employee> optional= employeeRepository.findById(empid);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
            if(employee.getSalary()<=250000)
            {
             employee.setTax_amount(0);
            }
            else
                if(employee.getSalary()>250000 && employee.getSalary() <=500000)
                {
                   double tax = (employee.getSalary() - 250000) * 0.05;
                    employee.setTax_amount(tax);
                    employee.setCess_amount(tax*cessRate);
                }
                else
                    if(employee.getSalary()>500000 && employee.getSalary() <=1000000)
                    {
                        double tax =250000 * 0.05 + (employee.getSalary() - 500000) * 0.1;
                        employee.setTax_amount(tax);
                        employee.setCess_amount(tax*cessRate);
                    }
                    else
                        if(employee.getSalary()>1000000)
                        {
                            double tax = 250000 * 0.05 + 500000 * 0.2 + (employee.getSalary() - 1000000) * 0.2;
                            employee.setTax_amount(tax);
                            employee.setCess_amount(tax*cessRate);
                        }
        } else {
            throw new RuntimeException(" Employee not found for id :: " + empid);
        }
        return employee;
    }
}
