package com.services;

public class ServiceLookup {
    public Service serviceLookup(String serviceName) {
        if(serviceName.equalsIgnoreCase("data")) {
            return new DataService();
        } else {
            return new MessagingService();
        }
    }
}
