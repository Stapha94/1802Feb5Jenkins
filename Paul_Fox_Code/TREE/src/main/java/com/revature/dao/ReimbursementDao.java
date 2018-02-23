package com.revature.dao;

import com.revature.beans.Reimbursement;

public interface ReimbursementDao {

    Reimbursement getById(int reimbursementId);

    void newReimbursement(Reimbursement reimbursement);

    void updateReimbursement(Reimbursement reimbursement);

    void deleteReimbursement(Reimbursement reimbursement);

}
