package com;

import com.client.Client;
import com.services.Delegate;

public class Main {

    public static void main(String[] args) {
        Delegate businessDelegate = new Delegate();
        businessDelegate.setServiceTypeName("data");

        Client client = new Client(businessDelegate);
        client.doTask();

        businessDelegate.setServiceTypeName("messaging");
        client.doTask();
    }
}
