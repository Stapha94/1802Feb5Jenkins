package com.client;

import com.services.Delegate;

public class Client {
    Delegate businessService;

    public Client(Delegate businessService) {
        this.businessService = businessService;
    }

    public void doTask() {
        businessService.doTask();
    }
}
