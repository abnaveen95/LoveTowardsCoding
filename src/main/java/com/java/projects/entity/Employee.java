package com.java.projects.entity;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue
    private int emp_id;

    @NotBlank(message = "first_Name is mandatory")
    @Column(name="first_name")
    private String firstname;

    @NotBlank(message = "last_Name is mandatory")
    @Column(name="last_name")
    private String LastName;
    @NotBlank(message = "email is mandatory")
    @NonNull
    @Column(name="email")
    private String Email;

    @NotBlank(message = "PhoneNumber is mandatory")
    @Column(name="phoneNumber")
    private List<Integer> PhoneNumber;

    @NotBlank(message = "Doj is mandatory")
    @Column(name="DOJ")
    private Date DOJ;


    @NotBlank(message = "salary is mandatory")
    @Column(name="Salary")
    private int Salary;


    private double tax_amount;
    private double cess_amount;

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public List<Integer> getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(List<Integer> phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Date getDOJ() {
        return DOJ;
    }

    public void setDOJ(Date DOJ) {
        this.DOJ = DOJ;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public double getTax_amount() {
        return tax_amount;
    }

    public void setTax_amount(double tax_amount) {
        this.tax_amount = tax_amount;
    }

    public double getCess_amount() {
        return cess_amount;
    }

    public void setCess_amount(double cess_amount) {
        this.cess_amount = cess_amount;
    }

}
