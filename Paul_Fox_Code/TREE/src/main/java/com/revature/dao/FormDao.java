package com.revature.dao;

import com.revature.beans.Form;

import java.util.List;

public interface FormDao {

    Form getById(int id);

    List<Form> getByName(Form form);

    void newForm(Form form);

    void updateForm(Form form);

    void deleteForm(Form form);

}
