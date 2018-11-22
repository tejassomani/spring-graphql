package com.tej.models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Instructor {

    private int id;
    private String firstName;
    private String lastName;
    private Profile profile;
    private Date dob;
    private List<Class> aClasses;

    public Instructor() {
    }


    public Instructor(int id, String firstName, String lastName, Date dob, Profile profile, List<Class> aClasses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.profile = profile;
        this.aClasses = aClasses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Profile getProfile() {
        return this.profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Class> getaClasses() {
        return aClasses;
    }

    public void setaClasses(List<Class> aClasses) {
        this.aClasses = aClasses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instructor)) return false;
        Instructor instructor = (Instructor) o;
        return id == instructor.id &&
                Objects.equals(firstName, instructor.firstName) &&
                Objects.equals(lastName, instructor.lastName) &&
                Objects.equals(dob, instructor.dob) &&
                Objects.equals(profile, instructor.profile) &&
                Objects.equals(aClasses, instructor.aClasses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, dob, profile, aClasses);
    }

}

