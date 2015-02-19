package com.example.library;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by albertomendezhernandez on 26/12/14.
 */

@RestController
@RequestMapping("/movie")
public class MovieController {
    private static Logger logger = Logger.getLogger(Application.class);

    @Autowired
    MovieDAO movieDAO;

    /*@RequestMapping(method = GET, params = "id")
    public List<Movie> getById(String id) {
        if (id != null) {
            return movieDAO.getById(id);
        } else {
            logger.error("ERROR no se ha encontrado ninguna película del " + id);
        }

        return new ArrayList<Movie>();
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Movie> getAllData(){
        return movieDAO.getAllData();
    }

    @RequestMapping("/tematica")
    public List<Map<String, Object>> getTematicas(){
        return movieDAO.getTematicas();
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteMovie(@RequestParam(value = "id")long id){
        movieDAO.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateMovie(@RequestBody Movie movie){
        movieDAO.updateMovie(movie);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Movie createMovie(@RequestBody Movie movie){
        return movieDAO.createMovie(movie);
    }*/
    @RequestMapping(method = RequestMethod.GET, params = "actor")
    public List<Movie> getAllMoviesWithNationalities(String actor){
        return movieDAO.findByActorWithNationality(actor);
    }

    @RequestMapping(method = RequestMethod.GET, params = "tematica")
    public List<Movie> getFindByTematica(String tematica){
        return movieDAO.findByTematica(tematica);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"tematica", "nacionalidad"})
     public List<Movie> findByTematicayNacionalidad(String tematica, String nacionalidad){
        return movieDAO.findByTematicayNacionalidad(tematica, nacionalidad);
    }
    @RequestMapping(method = RequestMethod.GET, params = {"tematica", "nacionalidad", "nombre", "apellido"})
    public List<Movie> findByTematicayNacionalidadyNombre(String tematica, String nacionalidad, String nombre, String apellido){
        return movieDAO.findByTematicayNacionalidadyNombre(tematica, nacionalidad, nombre, apellido);
    }



    /*
    public List<Movie> findByTematicayNacionalidadyNombre(String tematica, String nacionalidad, String nombre, String apellido)
     */
}
