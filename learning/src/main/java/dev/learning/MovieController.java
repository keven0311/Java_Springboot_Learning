package dev.learning;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }
}

// Route
//RestControll is the controller to control data responding from an api endpoint
// in this case, "/api/v1/movies" is the endpoint for front-end to make request
//  to get all movies from database along with the http status of OK.

// @GetMapping indecate it is a get request, and it should response a ResponseEntity which
//    hold a list of movies