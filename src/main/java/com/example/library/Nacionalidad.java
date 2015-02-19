package com.example.library;

/**
 * Created by albertomendezhernandez on 23/1/15.
 */
public class Nacionalidad {
    private long id;
    private String nameNacionalidad;

    public Nacionalidad() {
    }

    public Nacionalidad(long id, String nameNacionalidad) {
        this.id = id;
        this.nameNacionalidad = nameNacionalidad;
    }

    public long getId() {
        return id;
    }

    public String getNameNacionalidad() {
        return nameNacionalidad;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNameNacionalidad(String nameNacionalidad) {
        this.nameNacionalidad = nameNacionalidad;
    }

    @Override
    public String toString() {
        return "Nacionalidad{" +
                "id=" + id +
                ", nameNacionalidad='" + nameNacionalidad + '\'' +
                '}';
    }
}
