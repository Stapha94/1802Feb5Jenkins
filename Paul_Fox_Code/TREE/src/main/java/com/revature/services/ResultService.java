package com.revature.services;

import com.revature.beans.Result;
import com.revature.dao.ResultDaoJdbcPg;

public class ResultService {

    private static ResultDaoJdbcPg myResultDao = new ResultDaoJdbcPg();

    public Result getById(int resultId){

        return myResultDao.getById(resultId);

    }

    public void newResult(Result result){

        myResultDao.newResult(result);

    }

    public void updateResult(Result result){

        myResultDao.updateResult(result);

    }

    public void deleteResult(Result result){

        myResultDao.deleteResult(result);

    }
}
