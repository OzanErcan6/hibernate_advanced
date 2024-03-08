package com.ozzyjpa.demojpa.entities;

import javax.persistence.Entity;

@Entity
public class FieldWorkerMapped extends WorkerMapped{

    private Double workAreaType;

    public FieldWorkerMapped(String firstName, String lastName, String email, Double workAreaType) {
        super(firstName, lastName, email);
        this.workAreaType = workAreaType;
    }

    public FieldWorkerMapped() {

    }

    public Double getWorkAreaType() {
        return workAreaType;
    }

    public void setWorkAreaType(Double workAreaType) {
        this.workAreaType = workAreaType;
    }
}
