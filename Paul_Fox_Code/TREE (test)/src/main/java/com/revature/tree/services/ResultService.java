package com.revature.tree.services;

import com.revature.tree.beans.Result;
import com.revature.tree.dao.ResultDaoJdbcPg;

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
