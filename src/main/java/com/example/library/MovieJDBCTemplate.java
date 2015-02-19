package com.example.library;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository(value = "movieDAO")
public class MovieJDBCTemplate implements MovieDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

   /* @Override
    public List<Movie> getById(String id) {
        return jdbcTemplate.query("SELECT * FROM movies WHERE id = ?", new Object[]{id}, new MovieMapper());
    }

    @Override
    public List<Movie> getAllData() {
        return jdbcTemplate.query("SELECT * FROM movies",new Object[]{}, new MovieMapper());
    }

    @Override
    public List<Map<String, Object>> getTematicas() {
        return jdbcTemplate.queryForList("SELECT DISTINCT tematica FROM movies");
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update("DELETE FROM movies WHERE id = ?", new Object[]{id});
    }

    @Override
    public void updateMovie(Movie movie) {
        jdbcTemplate.update("UPDATE movies SET titulo = ?, tematica = ?, taquilla = ?, pubYear = ? WHERE id = ?",
                movie.getTitulo(), movie.getTematica(), movie.getTaquilla(), movie.getPubYear(), movie.getId());
    }

    @Override
    public Movie createMovie(Movie movie) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("movies");
        jdbcInsert.setGeneratedKeyName("id");
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("titulo", movie.getTitulo());
        args.put("tematica", movie.getTematica());
        args.put("taquilla", movie.getTaquilla());
        args.put("pubYear", movie.getPubYear());
        long movieId = jdbcInsert.executeAndReturnKey(args).longValue();
        return new Movie(movieId, movie.getTitulo(), movie.getTematica(), movie.getTaquilla(), movie.getPubYear());
    }*/

    @Override
    public List<Movie> findByActorWithNationality(String actor) {
        String sql = "SELECT m.id AS id_movie, m.title, m.id_tematica, t.tematica, \n" +
                "\t\tn.id AS id_nationality, n.nacionalidad\n" +
                "FROM actors AS a\n" +
                "  INNER JOIN actors_movies AS am ON a.id = am.actor_id\n" +
                "  INNER JOIN movies AS m ON am.movie_id = m.id\n" +
                "  INNER JOIN tematica AS t ON t.id = m.id_tematica\n" +
                "  INNER JOIN nationality_movies AS nm ON nm.movie_id = m.id\n" +
                "  INNER JOIN nationality AS n ON n.id = nm.nationality_id\n" +
                "WHERE a.first_name LIKE ? ORDER BY m.numSells DESC";
        return jdbcTemplate.query(sql, new Object[]{'%'+actor+'%'},(ResultSet rs) -> {
            Map<Long, Movie> map = new HashMap<Long, Movie>();
            Movie movie = null;

            while (rs.next()) {
                Long id = rs.getLong("id_movie");
                movie = map.get(id);

                if (movie == null) {
                    movie = new Movie();
                    movie.setId(id);
                    movie.setTitulo(rs.getString("title"));
                    Tematica tematica = new Tematica(
                            rs.getLong("id_tematica"),
                            rs.getString("tematica"));
                    movie.setTematica(tematica);
                    movie.setNacionalidadesMovie(
                            new ArrayList<Nacionalidad>());
                    map.put(id, movie);
                }

                Long nacionalidadId = rs.getLong("id_nationality");
                if (nacionalidadId > 0) {
                    Nacionalidad nacionalidad = new Nacionalidad();
                    nacionalidad.setId(nacionalidadId);
                    nacionalidad.setNameNacionalidad(rs.getString("nacionalidad"));
                    movie.getNacionalidadesMovie().add(nacionalidad);

                }
            }
            return new ArrayList<Movie>(map.values());

        });
    }

    public List<Movie> findByTematica(String tematica) {
        String sql = "SELECT * FROM movies AS m\n"+
        "INNER JOIN tematica AS t ON t.id = m.id_tematica\n"+
        "WHERE t.tematica LIKE ?;";
        return jdbcTemplate.query(sql, new Object[]{'%'+tematica+'%'}, new MovieMapper());
    }

    public List<Movie> findByTematicayNacionalidad(String tematica, String nacionalidad) {
        String sql = "SELECT * FROM movies AS m "+
                "INNER JOIN tematica AS t ON t.id = m.id_tematica "+
                "INNER JOIN nationality_movies AS nm ON nm.movie_id = m.id "+
                "INNER JOIN nationality AS n ON n.id = nm.nationality_id "+
                "WHERE t.tematica LIKE ? AND n.nacionalidad LIKE ? AND m.publishedDate BETWEEN '1990-01-01' AND '1990-12-31';";
        return jdbcTemplate.query(sql, new Object[]{'%'+tematica+'%', '%'+nacionalidad+'%'},(ResultSet rs) ->{


            Map<Long, Movie> map = new HashMap<Long, Movie>();
            Movie movie = null;

            while (rs.next()) {
                Long id = rs.getLong("movie_id");
                movie = map.get(id);

                if (movie == null) {
                    movie = new Movie();
                    movie.setId(id);
                    movie.setTitulo(rs.getString("title"));
                    Tematica tematica2 = new Tematica(
                            rs.getLong("id_tematica"),
                            rs.getString("tematica"));
                    movie.setTematica(tematica2);
                    movie.setNacionalidadesMovie(
                            new ArrayList<Nacionalidad>());
                    map.put(id, movie);
                }

                Long nacionalidadId = rs.getLong("nationality_id");
                if (nacionalidadId > 0) {
                    Nacionalidad nacionalidad2 = new Nacionalidad();
                    nacionalidad2.setId(nacionalidadId);
                    nacionalidad2.setNameNacionalidad(rs.getString("nacionalidad"));
                    movie.getNacionalidadesMovie().add(nacionalidad2);

                }
            }
            return new ArrayList<Movie>(map.values());
        });

    }

    public List<Movie> findByTematicayNacionalidadyNombre(String tematica, String nacionalidad, String nombre, String apellido) {
        String sql = "SELECT * FROM movies AS m "+
                "INNER JOIN tematica AS t ON t.id = m.id_tematica "+
                "INNER JOIN nationality_movies AS nm ON nm.movie_id = m.id "+
                "INNER JOIN nationality AS n ON n.id = nm.nationality_id "+
                "INNER JOIN actors_movies AS am ON m.id = am.movie_id " +
                "INNER JOIN actors AS a ON a.id = am.actor_id " +
                "WHERE t.tematica LIKE ? " +
                "AND n.nacionalidad LIKE ? " +
                "AND a.first_name LIKE ? " +
                "AND a.second_name LIKE ? " +
                "AND m.publishedDate BETWEEN '1990-01-01' AND CURRENT_DATE; ";

        return jdbcTemplate.query(sql, new Object[]{'%'+tematica+'%', '%'+nacionalidad+'%', '%'+nombre+'%', '%'+apellido+'%'},(ResultSet rs) ->{

            Map<Long, Movie> map = new HashMap<Long, Movie>();
            Movie movie = null;

            while (rs.next()) {
                Long id = rs.getLong("movie_id");
                movie = map.get(id);

                if (movie == null) {
                    movie = new Movie();
                    movie.setId(id);
                    movie.setTitulo(rs.getString("title"));
                    Tematica tematica2 = new Tematica(
                            rs.getLong("id_tematica"),
                            rs.getString("tematica"));
                    movie.setTematica(tematica2);
                    movie.setNacionalidadesMovie(
                            new ArrayList<Nacionalidad>());
                    map.put(id, movie);
                }

                Long nacionalidadId = rs.getLong("nationality_id");
                if (nacionalidadId > 0) {
                    Nacionalidad nacionalidad2 = new Nacionalidad();
                    nacionalidad2.setId(nacionalidadId);
                    nacionalidad2.setNameNacionalidad(rs.getString("nacionalidad"));
                    movie.getNacionalidadesMovie().add(nacionalidad2);

                }
            }
            return new ArrayList<Movie>(map.values());
        });

    }



}

