package com.example.library;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by albertomendezhernandez on 26/12/14.
 */
public class Movie {
    private long id;
    private String titulo;
    private Tematica tematica;
    private int taquilla;
    private int pubYear;
    public List<Nacionalidad> nacionalidadesMovie = new ArrayList<>();

    public Movie() {
    }

    public Movie(long id, String titulo, Tematica tematica, int taquilla, int pubYear, List<Nacionalidad> nacionalidadesMovie) {
        this.id = id;
        this.titulo = titulo;
        this.tematica = tematica;
        this.taquilla = taquilla;
        this.pubYear = pubYear;
        this.nacionalidadesMovie = nacionalidadesMovie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Tematica getTematica() {
        return tematica;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }

    public int getTaquilla() {
        return taquilla;
    }

    public void setTaquilla(int taquilla) {
        this.taquilla = taquilla;
    }

    public int getPubYear() {
        return pubYear;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }

    public List<Nacionalidad> getNacionalidadesMovie() {
        return nacionalidadesMovie;
    }

    public void setNacionalidadesMovie(List<Nacionalidad> nacionalidadesMovie) {
        this.nacionalidadesMovie = nacionalidadesMovie;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", tematica=" + tematica +
                ", taquilla=" + taquilla +
                ", pubYear=" + pubYear +
                ", nacionalidadesMovie=" + nacionalidadesMovie +
                '}';
    }
}
