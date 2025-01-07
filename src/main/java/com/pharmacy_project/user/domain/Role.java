package com.pharmacy_project.user.domain;

public enum Role {

    ADMIN("Administrator"),
    MANAGER("Manager"),
    ATTENDANT("Attendant");

    private final String jobTitle;

    Role(String role) {
        this.jobTitle = role;
    }

    public String getRole() {
        return jobTitle;
    }
}


