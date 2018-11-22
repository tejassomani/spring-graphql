package com.tej;

import com.tej.models.Class;
import com.tej.models.Instructor;
import com.tej.models.Profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DummyDataLoader {

    private static Map<Integer, Instructor> instructors = new HashMap<>();
    private static Map<Integer, Class> classes = new HashMap<>();

    public static Map<Integer, Instructor> getInstructors() {
        if (instructors.isEmpty()) {
            loadData();
        }
        return instructors;
    }

    public static Map<Integer, Class> getClasses() {
        return classes;
    }

    private static void loadData() {
        Profile profile1 = new Profile();
        profile1.setBio("Born in California, has been training since age 12");
        Instructor instructor1 = new Instructor();
        instructor1.setId(1);
        instructor1.setFirstName("Matt");
        instructor1.setLastName("Wilpers");
        instructor1.setProfile(profile1);
        instructor1.setaClasses(new ArrayList<>());
        instructors.put(1, instructor1);

        Profile profile2 = new Profile();
        profile2.setBio("HIIT");
        Instructor instructor2 = new Instructor();
        instructor2.setId(2);
        instructor2.setFirstName("John");
        instructor2.setLastName("Doe");
        instructor2.setProfile(profile2);
        instructor2.setaClasses(new ArrayList<>());
        instructors.put(2, instructor2);

        Profile profile3 = new Profile();
        profile3.setBio("Accomplished instructor with over 1000 completed rides");
        Instructor instructor3 = new Instructor();
        instructor3.setId(3);
        instructor3.setFirstName("Emma");
        instructor3.setLastName("Lwell");
        instructor3.setProfile(profile3);
        instructor3.setaClasses(new ArrayList<>());
        instructors.put(3, instructor3);

        Profile profile4 = new Profile();
        profile4.setBio("High Intensity Workout. Training since past 14 years");
        Instructor instructor4 = new Instructor();
        instructor4.setId(4);
        instructor4.setFirstName("Cody");
        instructor4.setLastName("Rigsby");
        instructor4.setProfile(profile4);
        instructor4.setaClasses(new ArrayList<>());
        instructors.put(4, instructor4);

        Class class1 = new Class();
        class1.setId(1);
        class1.setTitle("Beginner Ride");
        class1.setClassInfo("Perfect for beginners, slow build up");
        classes.put(1, class1);

        Class class2 = new Class();
        class2.setId(2);
        class2.setTitle("Low Impact");
        class2.setClassInfo("Suited for someone recovering from injury");
        classes.put(2, class2);

        Class class3 = new Class();
        class3.setId(3);
        class3.setTitle("Ride & Strength");
        class3.setClassInfo("Ride along with some strength and core training");
        classes.put(3, class3);

        Class class4 = new Class();
        class4.setId(4);
        class4.setTitle("Advanced Begginer");
        class4.setClassInfo("Beginners going to the next level. Work more, sweat more");
        classes.put(4, class4);

        instructor1.getaClasses().add(class1);
        instructor1.getaClasses().add(class2);

        instructor2.getaClasses().add(class3);

        instructor3.getaClasses().add(class4);
    }
}
