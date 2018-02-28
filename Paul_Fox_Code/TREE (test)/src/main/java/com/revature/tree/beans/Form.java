package com.revature.tree.beans;

import java.util.Objects;

public class Form {

    private int formId;
    private String date;
    private String time;
    private String location;
    private String description;
    private float cost;
    private String eventType;
    private String gradingFormat;
    private String missedTime;
    private String attachments;
    private String approvalMsg;
    private boolean approvedBySupervisor;
    private boolean approvedByDeptHead;
    private boolean approvedByBenco;
    private float projectedReimbursement;
    private int employeeId;

    public Form(){}

    public Form(int formId, String date, String time, String location, String description, float cost, String eventType, String gradingFormat, String missedTime, String attachments, String approvalMsg, boolean approvedBySupervisor, boolean approvedByDeptHead, boolean approvedByBenco, float projectedReimbursement, int employeeId) {
        this.formId = formId;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.cost = cost;
        this.eventType = eventType;
        this.gradingFormat = gradingFormat;
        this.missedTime = missedTime;
        this.attachments = attachments;
        this.approvalMsg = approvalMsg;
        this.approvedBySupervisor = approvedBySupervisor;
        this.approvedByDeptHead = approvedByDeptHead;
        this.approvedByBenco = approvedByBenco;
        this.projectedReimbursement = projectedReimbursement;
        this.employeeId = employeeId;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getGradingFormat() {
        return gradingFormat;
    }

    public void setGradingFormat(String gradingFormat) {
        this.gradingFormat = gradingFormat;
    }

    public String getMissedTime() {
        return missedTime;
    }

    public void setMissedTime(String missedTime) {
        this.missedTime = missedTime;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public String getApprovalMsg() {
        return approvalMsg;
    }

    public void setApprovalMsg(String approvalMsg) {
        this.approvalMsg = approvalMsg;
    }

    public boolean isApprovedBySupervisor() {
        return approvedBySupervisor;
    }

    public void setApprovedBySupervisor(boolean approvedBySupervisor) {
        this.approvedBySupervisor = approvedBySupervisor;
    }

    public boolean isApprovedByDeptHead() {
        return approvedByDeptHead;
    }

    public void setApprovedByDeptHead(boolean approvedByDeptHead) {
        this.approvedByDeptHead = approvedByDeptHead;
    }

    public boolean isApprovedByBenco() {
        return approvedByBenco;
    }

    public void setApprovedByBenco(boolean approvedByBenco) {
        this.approvedByBenco = approvedByBenco;
    }

    public float getProjectedReimbursement() {
        return projectedReimbursement;
    }

    public void setProjectedReimbursement(float projectedReimbursement) {
        this.projectedReimbursement = projectedReimbursement;
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
        Form form = (Form) o;
        return getFormId() == form.getFormId() &&
                Float.compare(form.getCost(), getCost()) == 0 &&
                isApprovedBySupervisor() == form.isApprovedBySupervisor() &&
                isApprovedByDeptHead() == form.isApprovedByDeptHead() &&
                isApprovedByBenco() == form.isApprovedByBenco() &&
                Float.compare(form.getProjectedReimbursement(), getProjectedReimbursement()) == 0 &&
                getEmployeeId() == form.getEmployeeId() &&
                Objects.equals(getDate(), form.getDate()) &&
                Objects.equals(getTime(), form.getTime()) &&
                Objects.equals(getLocation(), form.getLocation()) &&
                Objects.equals(getDescription(), form.getDescription()) &&
                Objects.equals(getEventType(), form.getEventType()) &&
                Objects.equals(getGradingFormat(), form.getGradingFormat()) &&
                Objects.equals(getMissedTime(), form.getMissedTime()) &&
                Objects.equals(getAttachments(), form.getAttachments()) &&
                Objects.equals(getApprovalMsg(), form.getApprovalMsg());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFormId(), getDate(), getTime(), getLocation(), getDescription(), getCost(), getEventType(), getGradingFormat(), getMissedTime(), getAttachments(), getApprovalMsg(), isApprovedBySupervisor(), isApprovedByDeptHead(), isApprovedByBenco(), getProjectedReimbursement(), getEmployeeId());
    }

    @Override
    public String toString() {
        return "Form{" +
                "formId=" + formId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", eventType='" + eventType + '\'' +
                ", gradingFormat='" + gradingFormat + '\'' +
                ", missedTime='" + missedTime + '\'' +
                ", attachments='" + attachments + '\'' +
                ", approvalMsg='" + approvalMsg + '\'' +
                ", approvedBySupervior=" + approvedBySupervisor +
                ", approvedByDeptHead=" + approvedByDeptHead +
                ", approvedByBenco=" + approvedByBenco +
                ", projectedReimbursement=" + projectedReimbursement +
                ", employeeId=" + employeeId +
                '}';
    }
}
