package dev.learning;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

// Route
//RestControll is the controller to control data responding from an api endpoint
// in this case, "/api/v1/movies" is the endpoint for front-end to make request
//  to get all movies from database along with the http status of OK.

// @GetMapping indecate it is a get request, and it should response a ResponseEntity which
//    hold a list of movies
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {

        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
    
     
}


//Controller: take http request from an ulr endpoint  --->
//Service: according to the request, provides method to fetch or modify data from database  --->
//Repository: accpet the method from Service layer to communicate with database.