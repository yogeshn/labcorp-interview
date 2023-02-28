package org.labcorp.interview.labcorpinterview;

import org.junit.jupiter.api.Test;
import org.labcorp.interview.labcorpinterview.entity.Employee;
import org.labcorp.interview.labcorpinterview.entity.SalariedEmployee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SalariedEmployeeTest {
    @Test
    void testWork() {
        Employee employee = new SalariedEmployee();
        employee.work(195);
        assertEquals(11.25f, employee.getVacationDays());
    }

    @Test
    void testMaxVacationDays() {
        Employee employee = new SalariedEmployee();
        employee.work(260);
        assertEquals(15.0f, employee.getVacationDays());
    }

    @Test
    void testInvalidWorkDays() {
        Employee employee = new SalariedEmployee();
        assertThrows(IllegalArgumentException.class, () -> employee.work(-1));
    }

    @Test
    void testExcessiveWorkDays() {
        Employee employee = new SalariedEmployee();
        assertThrows(IllegalArgumentException.class, () -> employee.work(300));
    }

}
