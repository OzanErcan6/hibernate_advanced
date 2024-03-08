package com.ozzyjpa.demojpa.entities;

//import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value="Field") no need
public class FieldWorkerTablePerClass extends WorkerTablePerClass{

    private Double workAreaType;

    public FieldWorkerTablePerClass(String firstName, String lastName, String email, Double workAreaType) {
        super(firstName, lastName, email);
        this.workAreaType = workAreaType;
    }

    public FieldWorkerTablePerClass() {

    }

    public Double getWorkAreaType() {
        return workAreaType;
    }

    public void setWorkAreaType(Double workAreaType) {
        this.workAreaType = workAreaType;
    }
}
