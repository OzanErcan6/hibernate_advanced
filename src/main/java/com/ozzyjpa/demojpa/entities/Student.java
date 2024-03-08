package com.ozzyjpa.demojpa.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;

    @ElementCollection
    @CollectionTable(name="image", joinColumns = @JoinColumn(name="student_id"))
    @Column(name="file_name")
    private Set<String> images = new HashSet<String>();

    @ElementCollection
    @CollectionTable(name="hobbie")
    @OrderBy("hobby_name DESC") // default asc,  orders how data retrieved
    @Column(name="hobby_name")
    private Set<String> hobbies = new LinkedHashSet<String>();

    @ElementCollection
    @CollectionTable(name="grades")
    @MapKeyColumn(name="course_name")
    @Column(name="grade")
    @OrderBy("course_name")
    private Map<String, String> grades = new HashMap<String, String>();

    @ElementCollection
    @CollectionTable(name="sorted_grades")
    @MapKeyColumn(name="course_name")
    @Column(name="grade")
    @OrderBy
    private SortedMap<String, String> sortedGrades = new TreeMap<String, String>();

    @Embedded
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "BILLING_STREET")),
            @AttributeOverride(name = "city", column = @Column(name = "BILLING_CITY")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "BILLING_ZIPCODE"))
    })
    private Address billingAddress;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private Status status;


    public Student() {

    }
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }

    public Map<String, String> getGrades() {
        return grades;
    }

    public void setGrades(Map<String, String> grades) {
        this.grades = grades;
    }

    public Set<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<String> hobbies) {
        this.hobbies = hobbies;
    }

    public SortedMap<String, String> getSortedGrades() {
        return sortedGrades;
    }

    public void setSortedGrades(SortedMap<String, String> sortedGrades) {
        this.sortedGrades = sortedGrades;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", images=" + images +
                ", hobbies=" + hobbies +
                ", grades=" + grades +
                ", sortedGrades=" + sortedGrades +
                ", homeAddress=" + homeAddress +
                ", billingAddress=" + billingAddress +
                ", status=" + status +
                '}';
    }
}
