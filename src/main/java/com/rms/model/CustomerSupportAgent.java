package com.rms.model;

public class CustomerSupportAgent {
    private String agentId;
    private String agentName;
    private String email;
    private String phoneNumber;

    public CustomerSupportAgent() {
    }

    public CustomerSupportAgent(String agentId, String agentName, String email, String phoneNumber) {
        this.agentId = agentId;
        this.agentName = agentName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
