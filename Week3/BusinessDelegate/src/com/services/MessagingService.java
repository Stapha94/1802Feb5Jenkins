package com.services;

public class MessagingService implements Service{
    @Override
    public void doProcess() {
        System.out.println("Messaging service processing request");
    }
}
