package com.services;

public class Delegate {
    private ServiceLookup lookup = new ServiceLookup();
    private Service businessService;
    private String serviceTypeName;

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public void doTask() {
        businessService = lookup.serviceLookup(this.serviceTypeName);
        businessService.doProcess();
    }
}
