package com.revature.dao;

import com.revature.beans.Form;

public interface FormDao {

    Form getById(int id);

    void newForm(Form form);

    void updateForm(Form form);

    void deleteForm(Form form);

}
