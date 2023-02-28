package org.labcorp.interview.labcorpinterview;

import org.junit.jupiter.api.Test;
import org.labcorp.interview.labcorpinterview.entity.Employee;
import org.labcorp.interview.labcorpinterview.entity.HourlyEmployee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeTest {
    @Test
    void testGetVacationDays() {
        Employee employee = new HourlyEmployee();
        assertEquals(0.0f, employee.getVacationDays(), 0.001f);
    }
    @Test
    void testTakeVacation() {
        Employee employee = new HourlyEmployee();
        employee.work(260);
        employee.takeVacation(5.0f);
        assertEquals(5.0f, employee.getVacationDays(), 0.001f);
    }

    @Test
    void testInvalidVacationDays() {
        Employee employee = new HourlyEmployee();
        employee.work(260);
        assertThrows(IllegalArgumentException.class, () -> employee.takeVacation(-1.0f));
    }

    @Test
    void testInsufficientVacationDays() {
        Employee employee = new HourlyEmployee();
        employee.work(260);
        assertThrows(IllegalArgumentException.class, () -> employee.takeVacation(11.0f));
    }

}