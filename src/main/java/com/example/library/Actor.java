package com.example.library;

import java.sql.Date;

/**
 * Created by albertomendezhernandez on 23/1/15.
 */
public class Actor {
    private long id;
    private String firstName;
    private String secondName;
    private String sex;
    private Date birthDate;

    public Actor() {
    }

    public Actor(long id, String firstName, String secondName, String sex, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.sex = sex;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;

        Actor actor = (Actor) o;

        if (id != actor.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
