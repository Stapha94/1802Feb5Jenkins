package com.revature.tree.dao;

import com.revature.tree.beans.Result;

public interface ResultDao {

    Result getById(int resultId);

    void newResult(Result result);

    void updateResult(Result result);

    void deleteResult(Result result);

}
