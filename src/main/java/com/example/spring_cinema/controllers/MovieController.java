package com.example.spring_cinema.controllers;

import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;



//    @PostMapping
//    public ResponseEntity<Reply> newMovie(){
//        Reply reply = movieService.getNewMovie();
//        return new ResponseEntity<>(reply, HttpStatus.CREATED);
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable long id){
        Movie movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Movie>>getAllMovies(){
        List<Movie> allMovies = movieService.getAllMovies();
        return new ResponseEntity<>(allMovies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie>getMovie(){
        List<Movie> allMovies =  movieService.getAllMovies();
        return new ResponseEntity<>(new Movie(), HttpStatus.CREATED);
    }


}
