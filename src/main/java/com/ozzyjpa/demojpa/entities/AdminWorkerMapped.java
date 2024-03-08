package com.ozzyjpa.demojpa.entities;

import javax.persistence.Entity;

@Entity
public class AdminWorkerMapped extends WorkerMapped{

    private String adminLevel;

    public AdminWorkerMapped(String firstName, String lastName, String email, String adminLevel) {
        super(firstName, lastName, email);
        this.adminLevel = adminLevel;
    }

    public AdminWorkerMapped() {
    }

    public String getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
    }
}
