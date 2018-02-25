package com.revature.services;

import com.revature.beans.Form;
import com.revature.beans.Reimbursement;
import com.revature.dao.FormDaoJdbcPg;

public class FormService {

    private static FormDaoJdbcPg formDao = new FormDaoJdbcPg();
    private static ReimbursementService reimService = new ReimbursementService();

    public Form getById(int formId){

        return formDao.getById(formId);

    }

    public Form getByEmployeeId(int employeeId){

        return formDao.getByEmployeeId(employeeId);

    }

    public void newForm(Form form){

        formDao.newForm(form);

    }

    public void updateForm(Form form){

        formDao.updateForm(form);

    }

    public void deleteForm(Form form){

        formDao.deleteForm(form);

    }

    public void calculateProjectedReimbursement(Form form){

        float projectedReimbursement = 0.00f;
        float cost = form.getCost();
        Reimbursement employeeReimbursement = reimService.getByEmployee(form.getEmployeeId());
        if(employeeReimbursement.getReimbursementRemainder() >= cost)
            projectedReimbursement = (employeeReimbursement.getReimbursementRemainder() - cost);
        else
            projectedReimbursement = employeeReimbursement.getReimbursementRemainder();
        form.setProjectedReimbursement(projectedReimbursement);
        formDao.updateForm(form);

    }

    public void approveForm(Form form){



    }

}
