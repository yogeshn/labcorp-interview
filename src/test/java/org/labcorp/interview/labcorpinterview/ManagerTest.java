package org.labcorp.interview.labcorpinterview;

import org.junit.jupiter.api.Test;
import org.labcorp.interview.labcorpinterview.entity.Employee;
import org.labcorp.interview.labcorpinterview.entity.Manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManagerTest {
    @Test
    void testWork() {
        Employee employee = new Manager();
        employee.work(130);
        assertEquals(15.0f, employee.getVacationDays());
    }
    @Test
    void testMaxVacationDays() {
        Manager manager = new Manager();
        manager.work(260);
        assertEquals(30.0f, manager.getVacationDays());
    }

    @Test
    void testInvalidWorkDays() {
        Manager manager = new Manager();
        assertThrows(IllegalArgumentException.class, () -> manager.work(-1));
    }

    @Test
    void testExcessiveWorkDays() {
        Manager manager = new Manager();
        assertThrows(IllegalArgumentException.class, () -> manager.work(300));
    }

    @Test
    void testTakeVacation() {
        Manager manager = new Manager();
        manager.work(260);
        manager.takeVacation(5.0f);
        assertEquals(25.0f, manager.getVacationDays());
    }

    @Test
    void testInvalidVacationDays() {
        Manager manager = new Manager();
        manager.work(260);
        assertThrows(IllegalArgumentException.class, () -> manager.takeVacation(-1.0f));
    }

    @Test
    void testInsufficientVacationDays() {
        Manager manager = new Manager();
        manager.work(260);
        assertThrows(IllegalArgumentException.class, () -> manager.takeVacation(31.0f));
    }

}
