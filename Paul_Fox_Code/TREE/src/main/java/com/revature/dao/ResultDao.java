package com.revature.dao;

import com.revature.beans.Result;

public interface ResultDao {

    Result getById(int resultId);

    void newResult(Result result);

    void updateResult(Result result);

    void deleteResult(Result result);

}
