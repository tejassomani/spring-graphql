package com.tej.models;

import java.util.Date;
import java.util.Objects;

public class Class {

    private int id;
    private String title;
    private Date dateCreated;
    private String classInfo;

    public Class() {
    }

    public Class(int id, String title, Date dateCreated, String text) {
        this.id = id;
        this.title = title;
        this.dateCreated = dateCreated;
        this.classInfo = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Class)) return false;
        Class aClass = (Class) o;
        return id == aClass.id &&
                Objects.equals(title, aClass.title) &&
                Objects.equals(dateCreated, aClass.dateCreated) &&
                Objects.equals(classInfo, aClass.classInfo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, dateCreated, classInfo);
    }
}
