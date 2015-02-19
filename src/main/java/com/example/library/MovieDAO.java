package com.example.library;

import java.util.List;
import java.util.Map;

/**
 * Created by albertomendezhernandez on 26/12/14.
 */
public interface MovieDAO {
    
   /* public List<Movie> getById(String year);

    public List<Movie> getAllData();

    public List<Map<String, Object>> getTematicas();
    
    public void deleteById(long id);

    public void updateMovie(Movie movie);

    public Movie createMovie(Movie movie);*/

    public List<Movie> findByActorWithNationality(String actor);
    public List<Movie> findByTematica(String tematica);
    public List<Movie> findByTematicayNacionalidad(String tematica, String nacionalidad);
    public List<Movie> findByTematicayNacionalidadyNombre(String tematica, String nacionalidad, String nombre, String apellido);
}
