package com.revature.beans;

import java.util.Objects;

public class Results {

    private int resultId;
    private int formId;
    private float grade;

    public Results(){}

    public Results(int resultId, int formId, float grade) {
        this.resultId = resultId;
        this.formId = formId;
        this.grade = grade;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results = (Results) o;
        return getResultId() == results.getResultId() &&
                getFormId() == results.getFormId() &&
                Float.compare(results.getGrade(), getGrade()) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(getResultId(), getFormId(), getGrade());
    }

    @Override
    public String toString() {
        return "Results{" +
                "resultId=" + resultId +
                ", formId=" + formId +
                ", grade=" + grade +
                '}';
    }

}
