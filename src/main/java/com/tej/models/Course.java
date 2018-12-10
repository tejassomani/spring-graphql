package com.tej.models;

import com.base.annotations.GqlSchemaTypeDef;
import com.base.annotations.GqlSchemaField;

import java.util.Date;
import java.util.Objects;

@GqlSchemaTypeDef
public class Course {

    @GqlSchemaField private Integer id;
    @GqlSchemaField private String title;
    @GqlSchemaField private Date dateCreated;
    @GqlSchemaField private String courseInfo;

    public Course() {
    }

    public Course(int id, String title, Date dateCreated, String text) {
        this.id = id;
        this.title = title;
        this.dateCreated = dateCreated;
        this.courseInfo = text;
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

    public String getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course aCourse = (Course) o;
        return id == aCourse.id &&
                Objects.equals(title, aCourse.title) &&
                Objects.equals(dateCreated, aCourse.dateCreated) &&
                Objects.equals(courseInfo, aCourse.courseInfo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, dateCreated, courseInfo);
    }
}
