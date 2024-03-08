package com.ozzyjpa.demojpa.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Field")
public class FieldWorker extends Worker{

    private Double workAreaType;

    public FieldWorker(String firstName, String lastName, String email, Double workAreaType) {
        super(firstName, lastName, email);
        this.workAreaType = workAreaType;
    }

    public FieldWorker() {

    }

    public Double getWorkAreaType() {
        return workAreaType;
    }

    public void setWorkAreaType(Double workAreaType) {
        this.workAreaType = workAreaType;
    }
}
