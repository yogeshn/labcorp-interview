package org.labcorp.interview.labcorpinterview.controller;

import org.labcorp.interview.labcorpinterview.entity.HourlyEmployee;
import org.labcorp.interview.labcorpinterview.entity.Manager;
import org.labcorp.interview.labcorpinterview.entity.SalariedEmployee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
Write classes in Java to represent 3 different types of Employee – hourly employees, salaried
employees, and managers (also considered salaried employees)
Each employee has a floating-point property for number of vacation days accumulated for the work year
(defined as 260 workdays) which cannot be a negative value and is not writable externally. Upon
creation its value should be set to 0.
Hourly employees accumulate 10 vacation days during the work year.
Salaried employees accumulate 15 vacation days during the work year.
Managers accumulate 30 vacation days during the work year.
Each employee has a Work() method that takes a single integer parameter that defines the number of
days worked which should be a value between 0 and 260. When this method is called, the number of
vacation days accumulated should be updated appropriately.
Each employee also has a TakeVacation() method that takes a single floating-point parameter that
defines the number of vacation days used. When this method is called, the number of vacation days
accumulated should be updated appropriately.
An employee cannot work more than the number of workdays in a work year and cannot take more
vacation than is available.
Your application should create a list of 10 instances of each type of employee on startup. No database is
required. Please ensure your controllers defined assuming a UI will be making the calls to them and have
proper error handling.
 */
@RestController
public class EmployeeController {
    private List<HourlyEmployee> hourlyEmployees = new ArrayList<>();
    private List<SalariedEmployee> salariedEmployees = new ArrayList<>();
    private List<Manager> managers = new ArrayList<>();

    public EmployeeController() {
        for (int i = 0; i < 10; i++) {
            hourlyEmployees.add(new HourlyEmployee());
            salariedEmployees.add(new SalariedEmployee());
            managers.add(new Manager());
        }
    }

    @GetMapping("/hourly-employees/{index}/vacation-days")
    public float getHourlyEmployeeVacationDays(@PathVariable int index) {
        if (index < 0 || index >= hourlyEmployees.size()) {
            throw new IllegalArgumentException("Invalid employee index");
        }
        return hourlyEmployees.get(index).getVacationDays();
    }

    @PutMapping("/hourly-employees/{index}/work/{days}")
    public void workHourlyEmployee(@PathVariable int index, @PathVariable int days) {
        if (index < 0 || index >= hourlyEmployees.size()) {
            throw new IllegalArgumentException("Invalid employee index");
        }
        hourlyEmployees.get(index).work(days);
    }

    @PutMapping("/hourly-employees/{index}/vacation/{days}")
    public void takeVacationHourlyEmployee(@PathVariable int index, @PathVariable float days) {
        if (index < 0 || index >= hourlyEmployees.size()) {
            throw new IllegalArgumentException("Invalid employee index");
        }
        hourlyEmployees.get(index).takeVacation(days);
    }

    @GetMapping("/salaried-employees/{index}/vacation-days")
    public float getSalariedEmployeeVacationDays(@PathVariable int index) {
        if (index < 0 || index >= salariedEmployees.size()) {
            throw new IllegalArgumentException("Invalid employee index");
        }
        return salariedEmployees.get(index).getVacationDays();
    }

    @PutMapping("/salaried-employees/{index}/work/{days}")
    public void workSalaryEmployee(@PathVariable int index, @PathVariable int days) {
        if (index < 0 || index >= salariedEmployees.size()) {
            throw new IllegalArgumentException("Invalid employee index");
        }
        salariedEmployees.get(index).work(days);
    }

    @PutMapping("/salaried-employees/{index}/vacation/{days}")
    public void takeVacationsalariedEmployee(@PathVariable int index, @PathVariable float days) {
        if (index < 0 || index >= salariedEmployees.size()) {
            throw new IllegalArgumentException("Invalid employee index");
        }
        salariedEmployees.get(index).takeVacation(days);
    }

    @GetMapping("/manager/{index}/vacation-days")
    public float getManagerVacationDays(@PathVariable int index) {
        if (index < 0 || index >= managers.size()) {
            throw new IllegalArgumentException("Invalid employee index");
        }
        return managers.get(index).getVacationDays();
    }

    @PutMapping("/manager/{index}/work/{days}")
    public void workManager(@PathVariable int index, @PathVariable int days) {
        if (index < 0 || index >= managers.size()) {
            throw new IllegalArgumentException("Invalid employee index");
        }
        managers.get(index).work(days);
    }

    @PutMapping("/manager/{index}/vacation/{days}")
    public void takeVacationManager(@PathVariable int index, @PathVariable float days) {
        if (index < 0 || index >= managers.size()) {
            throw new IllegalArgumentException("Invalid employee index");
        }
        managers.get(index).takeVacation(days);
    }
}