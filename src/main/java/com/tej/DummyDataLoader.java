package com.tej;

import com.tej.models.Course;
import com.tej.models.Instructor;
import com.tej.models.Profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DummyDataLoader {

    private static Map<Integer, Instructor> instructors = new HashMap<>();
    private static Map<Integer, Course> courses = new HashMap<>();

    public static Map<Integer, Instructor> getInstructors() {
        if (instructors.isEmpty()) {
            loadData();
        }
        return instructors;
    }

    public static Map<Integer, Course> getCourses() {
        return courses;
    }

    private static void loadData() {
        Profile profile1 = new Profile();
        profile1.setBio("Born in California, has been training since age 12");
        Instructor instructor1 = new Instructor();
        instructor1.setId(1);
        instructor1.setFirstName("Matt");
        instructor1.setLastName("Wilpers");
        instructor1.setProfile(profile1);
        instructor1.setCourses(new ArrayList<>());
        instructors.put(1, instructor1);

        Profile profile2 = new Profile();
        profile2.setBio("HIIT");
        Instructor instructor2 = new Instructor();
        instructor2.setId(2);
        instructor2.setFirstName("John");
        instructor2.setLastName("Doe");
        instructor2.setProfile(profile2);
        instructor2.setCourses(new ArrayList<>());
        instructors.put(2, instructor2);

        Profile profile3 = new Profile();
        profile3.setBio("Accomplished instructor with over 1000 completed rides");
        Instructor instructor3 = new Instructor();
        instructor3.setId(3);
        instructor3.setFirstName("Emma");
        instructor3.setLastName("Lwell");
        instructor3.setProfile(profile3);
        instructor3.setCourses(new ArrayList<>());
        instructors.put(3, instructor3);

        Profile profile4 = new Profile();
        profile4.setBio("High Intensity Workout. Training since past 14 years");
        Instructor instructor4 = new Instructor();
        instructor4.setId(4);
        instructor4.setFirstName("Cody");
        instructor4.setLastName("Rigsby");
        instructor4.setProfile(profile4);
        instructor4.setCourses(new ArrayList<>());
        instructors.put(4, instructor4);

        Course course1 = new Course();
        course1.setId(1);
        course1.setTitle("Beginner Ride");
        course1.setCourseInfo("Perfect for beginners, slow build up");
        courses.put(1, course1);

        Course course2 = new Course();
        course2.setId(2);
        course2.setTitle("Low Impact");
        course2.setCourseInfo("Suited for someone recovering from injury");
        courses.put(2, course2);

        Course course3 = new Course();
        course3.setId(3);
        course3.setTitle("Ride & Strength");
        course3.setCourseInfo("Ride along with some strength and core training");
        courses.put(3, course3);

        Course course4 = new Course();
        course4.setId(4);
        course4.setTitle("Advanced Begginer");
        course4.setCourseInfo("Beginners going to the next level. Work more, sweat more");
        courses.put(4, course4);

        instructor1.getCourses().add(course1);
        instructor1.getCourses().add(course2);

        instructor2.getCourses().add(course3);

        instructor3.getCourses().add(course4);
    }
}
