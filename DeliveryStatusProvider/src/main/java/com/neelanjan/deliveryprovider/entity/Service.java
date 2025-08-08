package com.neelanjan.deliveryprovider.entity;

public class Service {
    private int serviceId;
    private String serviceName;
    private String serviceStatus;

  
    public Service() {
    }

    public Service(int serviceId, String serviceName, String serviceStatus) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceStatus = serviceStatus;
    }

    // Getters and Setters
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }
}
