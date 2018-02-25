package com.revature.beans;

import java.util.Objects;

public class Reimbursement {

    private int reimbursementId;
    private float reimbursementTotal = 1000.00f;
    private float reimbursementUsed = 0.00f;
    private float reimbursementRemainder = 1000.00f;
    private int employeeId;

    public Reimbursement(){}

    public Reimbursement(int reimbursementId, float reimbursementTotal, float reimbursementUsed, float reimbursementRemainder, int employeeId) {
        this.reimbursementId = reimbursementId;
        this.reimbursementTotal = reimbursementTotal;
        this.reimbursementUsed = reimbursementUsed;
        this.reimbursementRemainder = reimbursementRemainder;
        this.employeeId = employeeId;
    }

    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public float getReimbursementTotal() {
        return reimbursementTotal;
    }

    public void setReimbursementTotal(float reimbursementTotal) {
        this.reimbursementTotal = reimbursementTotal;
    }

    public float getReimbursementUsed() {
        return reimbursementUsed;
    }

    public void setReimbursementUsed(float reimbursementUsed) {
        this.reimbursementUsed = reimbursementUsed;
    }

    public float getReimbursementRemainder() {
        return reimbursementRemainder;
    }

    public void setReimbursementRemainder(float reimbursementRemainder) {
        this.reimbursementRemainder = reimbursementRemainder;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return getReimbursementId() == that.getReimbursementId() &&
                Float.compare(that.getReimbursementTotal(), getReimbursementTotal()) == 0 &&
                Float.compare(that.getReimbursementUsed(), getReimbursementUsed()) == 0 &&
                Float.compare(that.getReimbursementRemainder(), getReimbursementRemainder()) == 0 &&
                getEmployeeId() == that.getEmployeeId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getReimbursementId(), getReimbursementTotal(), getReimbursementUsed(), getReimbursementRemainder(), getEmployeeId());
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementId=" + reimbursementId +
                ", reimbursementTotal=" + reimbursementTotal +
                ", reimbursementUsed=" + reimbursementUsed +
                ", reimbursementRemainder=" + reimbursementRemainder +
                ", employeeId=" + employeeId +
                '}';
    }

}
