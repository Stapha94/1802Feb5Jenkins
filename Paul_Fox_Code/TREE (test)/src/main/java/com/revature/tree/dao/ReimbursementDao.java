package com.revature.tree.dao;

import com.revature.tree.beans.Reimbursement;

public interface ReimbursementDao {

    Reimbursement getById(int reimbursementId);

    Reimbursement getByEmployee(int employeeId);

    void newReimbursement(Reimbursement reimbursement);

    void updateReimbursement(Reimbursement reimbursement);

    void deleteReimbursement(Reimbursement reimbursement);

}
