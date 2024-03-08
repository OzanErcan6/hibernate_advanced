package com.ozzyjpa.demojpa.entities;

import javax.persistence.*;

@Entity
@Table(name="workerTablePerClass")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name="USER_TYPE", discriminatorType = DiscriminatorType.STRING) // no need
public abstract class WorkerTablePerClass {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) // ids will hold in a seperate table select * from hibernate_sequence;
    @Column(name="id")
    private Long id;

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;

    public WorkerTablePerClass(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public WorkerTablePerClass() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
