package com.revature.services;

import com.revature.beans.Form;
import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDaoJdbcPg;

public class ReimbursementService {

    private static ReimbursementDaoJdbcPg reimDao = new ReimbursementDaoJdbcPg();
    private static FormService myFormService = new FormService();

    public Reimbursement getById(int reimbursementId){

        return reimDao.getById(reimbursementId);

    }

    public Reimbursement getByEmployee(int employeeId){

        return reimDao.getByEmployee(employeeId);

    }

    public void newReimbursement(Reimbursement reimbursement){

        reimDao.newReimbursement(reimbursement);

    }

    public void updateReimbursement(Reimbursement reimbursement){

        reimDao.updateReimbursement(reimbursement);

    }

    public void deleteReimbursement(Reimbursement reimbursement){

        reimDao.deleteReimbursement(reimbursement);

    }

    public float getRemainingReimbursement(Reimbursement reimbursement){

        reimbursement.setReimbursementRemainder(reimbursement.getReimbursementTotal() - reimbursement.getReimbursementUsed());
        return reimbursement.getReimbursementRemainder();

    }

    public void useReimbursementMoney(Reimbursement reimbursement){

        float total = reimbursement.getReimbursementTotal();
        float remainder = reimbursement.getReimbursementRemainder();
        float used = reimbursement.getReimbursementUsed();
        Form form = myFormService.getByEmployeeId(reimbursement.getEmployeeId());
        if(remainder - form.getCost() >= 0.00f) {
            remainder = remainder - form.getCost();
            used = used + form.getCost();
        }
        else if(remainder == 0.00f)
            System.out.println("No remaining reimbursement funds to use");
        else {
            System.out.println("Not enough funds to cover entire reimbursement.  Using what is left");
            used = used + remainder;
            remainder = 0.00f;
        }

        reimbursement.setReimbursementUsed(used);
        reimbursement.setReimbursementRemainder(remainder);
        reimDao.updateReimbursement(reimbursement);


    }

}
