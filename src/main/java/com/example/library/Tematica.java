package com.example.library;

/**
 * Created by albertomendezhernandez on 23/1/15.
 */
public class Tematica {
    private long id;
    private String nameTematica;

    public Tematica() {
    }

    public Tematica(long id, String nameTematica) {
        this.id = id;
        this.nameTematica = nameTematica;
    }

    public long getId() {
        return id;
    }

    public String getNameTematica() {
        return nameTematica;
    }

    @Override
    public String toString() {
        return "Tematica{" +
                "id=" + id +
                ", nameTematica='" + nameTematica + '\'' +
                '}';
    }
}
