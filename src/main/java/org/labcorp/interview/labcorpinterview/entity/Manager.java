package org.labcorp.interview.labcorpinterview.entity;

public class Manager extends SalariedEmployee {
    private final float MAX_VACATION_DAYS = 30.0f;
    private float vacationDays;

    public Manager() {
        super();
    }

    public float getVacationDays() {

        return vacationDays;
    }

    public void work(int days) {
        if (days < 0 || days > 260) {
            throw new IllegalArgumentException("Invalid number of workdays");
        }
        vacationDays += MAX_VACATION_DAYS / 260 * days;
    }

    public void takeVacation(float days) {
        if (days < 0 || days > vacationDays) {
            throw new IllegalArgumentException("Invalid number of vacation days");
        }
        vacationDays -= days;
    }
}

