package com.ozzyjpa.demojpa.entities;

import javax.persistence.*;

@Entity
//@DiscriminatorValue(value="Admin")
public class AdminWorkerTablePerClass extends WorkerTablePerClass{

    private String adminLevel;

    public AdminWorkerTablePerClass(String firstName, String lastName, String email, String adminLevel) {
        super(firstName, lastName, email);
        this.adminLevel = adminLevel;
    }

    public AdminWorkerTablePerClass() {
    }

    public String getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
    }
}
