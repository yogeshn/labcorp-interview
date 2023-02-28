package org.labcorp.interview.labcorpinterview.entity;

public abstract class Employee {
    private float vacationDays;

    public Employee() {
        this.vacationDays = 0.0f;
    }

    public float getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(float vacationDays) {
        this.vacationDays = vacationDays;
    }

    public abstract void work(int daysWorked);

    public abstract void takeVacation(float vacationDaysTaken);


}
