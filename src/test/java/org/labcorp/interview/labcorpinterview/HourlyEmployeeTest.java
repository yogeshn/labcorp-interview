package org.labcorp.interview.labcorpinterview;

import org.junit.jupiter.api.Test;
import org.labcorp.interview.labcorpinterview.entity.Employee;
import org.labcorp.interview.labcorpinterview.entity.HourlyEmployee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HourlyEmployeeTest {
    @Test
    void testWork() {
        Employee employee = new HourlyEmployee();
        employee.work(130);
        assertEquals(5.0f, employee.getVacationDays());
    }
    @Test
    void testMaxVacationDays() {
        Employee employee = new HourlyEmployee();
        employee.work(260);
        assertEquals(10.0f, employee.getVacationDays());
    }

    @Test
    void testInvalidWorkDays() {
        Employee employee = new HourlyEmployee();
        assertThrows(IllegalArgumentException.class, () -> employee.work(-1));
    }

    @Test
    void testExcessiveWorkDays() {
        Employee employee = new HourlyEmployee();
        assertThrows(IllegalArgumentException.class, () -> employee.work(300));
    }

}