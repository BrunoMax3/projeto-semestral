package br.com.brfilmes.controller;

import br.com.brfilmes.model.Movie;
import br.com.brfilmes.service.MovieService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class MovieController {

    private final MovieService movieService;
    
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    
    @GetMapping("/")
    public String home() {
        return "redirect:/movies";
    }
    
    @GetMapping("/movies")
    public String listMovies(Model model, HttpSession session, 
                          @RequestParam(required = false) String title,
                          @RequestParam(required = false) String genre) {
        
        // Verificar se o usuário está logado
        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }
        // aqui temos um filtros de busca de filmes, busca com base no banco de dados
        List<Movie> movies;
        
        if (title != null && !title.isEmpty()) {
            movies = movieService.searchMoviesByTitle(title);
            model.addAttribute("searchTitle", title);
        } else if (genre != null && !genre.isEmpty()) {
            movies = movieService.getMoviesByGenre(genre);
            model.addAttribute("searchGenre", genre);
        } else {
            movies = movieService.getAllMovies();
        }
        
        model.addAttribute("movies", movies);
        return "movies";
    }
    
    @GetMapping("/movies/{id}")
    public String movieDetails(@PathVariable Long id, Model model, HttpSession session) {
        // Verificar se o usuário está logado
        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }
        
        Optional<Movie> movie = movieService.getMovieById(id);
        
        if (movie.isPresent()) {
            model.addAttribute("movie", movie.get());
            return "movie-details";
        } else {
            return "redirect:/movies";
        }
    }
}
