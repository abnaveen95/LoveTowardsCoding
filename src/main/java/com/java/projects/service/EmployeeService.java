package com.java.projects.service;

import com.java.projects.entity.Employee;
import com.java.projects.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.time.LocalDate;

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
        double total_salary=0;
        Optional<Employee> optional= employeeRepository.findById(empid);

        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
            Date dateOfJoining = employee.getDOJ();
            LocalDate currentDate = LocalDate.now();
            int monthsOfService = (currentDate.getYear() - dateOfJoining.getYear()) * 12 + currentDate.getMonthValue() - dateOfJoining.getMonth();

            total_salary=employee.getSalary()*monthsOfService;
            if(total_salary<=250000)
            {
             employee.setTax_amount(0);
             employee.setCess_amount(0);
            }
            else
                if(total_salary>250000 && total_salary <=500000)
                {
                   double tax = (total_salary- 250000) * 0.05;
                    employee.setTax_amount(tax);
                    employee.setCess_amount(tax*cessRate);
                }
                else
                    if(total_salary>500000 && total_salary <=1000000)
                    {
                        double tax =250000 * 0.05 + (total_salary - 500000) * 0.1;
                        employee.setTax_amount(tax);
                        employee.setCess_amount(tax*cessRate);
                    }
                    else
                        if(total_salary>1000000)
                        {
                            double tax = 250000 * 0.05 + 500000 * 0.2 + (total_salary- 1000000) * 0.2;
                            employee.setTax_amount(tax);

                            //since total_salary> 2500000 collecting extra 2% from the tax
                            if(total_salary>2500000) {
                                employee.setCess_amount((tax * cessRate) +(tax * 0.02));
                            }
                            else
                                employee.setCess_amount(tax * cessRate);
                        }
        } else {
            throw new RuntimeException(" Employee not found for id :: " + empid);
        }
        return employee;
    }
}
