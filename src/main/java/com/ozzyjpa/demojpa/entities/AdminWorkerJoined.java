package com.ozzyjpa.demojpa.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Admin")
public class AdminWorkerJoined extends WorkerJoined{

    private String adminLevel;

    public AdminWorkerJoined(String firstName, String lastName, String email, String adminLevel) {
        super(firstName, lastName, email);
        this.adminLevel = adminLevel;
    }

    public AdminWorkerJoined() {
    }

    public String getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
    }
}
