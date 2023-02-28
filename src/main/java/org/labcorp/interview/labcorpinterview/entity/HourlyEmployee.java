package org.labcorp.interview.labcorpinterview.entity;

public class HourlyEmployee extends Employee {
    private final float MAX_VACATION_DAYS = 10.0f;
    private float vacationDays;

    public HourlyEmployee() {
        this.vacationDays = 0.0f;
    }

    public float getVacationDays() {

        return vacationDays;
    }

    @Override
    public void work(int days) {
        if (days < 0 || days > 260) {
            throw new IllegalArgumentException("Invalid number of workdays");
        }
        vacationDays += MAX_VACATION_DAYS / 260 * days;
    }

    public void takeVacation(float days) {
        if (days < 0) {
            throw new IllegalArgumentException("Invalid number of vacation days");
        }
        if (days > vacationDays) {
            throw new IllegalArgumentException("Not enough vacation days available");
        }
        vacationDays -= days;
    }
}
