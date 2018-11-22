package com.tej.models;

import java.util.Date;
import java.util.Objects;

public class Profile {

    private  String bio;
    private  Date activeSince;

    public Profile() {
    }

    public Profile(String bio, Date activeSince) {
        this.bio = bio;
        this.activeSince = activeSince;
    }

    public String getBio() {
        return bio;
    }

    public Date getActiveSince() {
        return activeSince;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setActiveSince(Date activeSince) {
        this.activeSince = activeSince;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile = (Profile) o;
        return Objects.equals(bio, profile.bio) &&
                Objects.equals(activeSince, profile.activeSince);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bio, activeSince);
    }
}
