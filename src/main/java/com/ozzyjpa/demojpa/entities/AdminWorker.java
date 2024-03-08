package com.ozzyjpa.demojpa.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Admin")
public class AdminWorker extends Worker{

    private String adminLevel;

    public AdminWorker(String firstName, String lastName, String email, String adminLevel) {
        super(firstName, lastName, email);
        this.adminLevel = adminLevel;
    }

    public AdminWorker() {
    }

    public String getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
    }
}
