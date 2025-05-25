package br.com.brfilmes.service;

import br.com.brfilmes.model.Movie;
import br.com.brfilmes.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Gerencia lógica do catálogo de filmes
// Centraliza buscas e filtros de filmes
// Implementa regras para exibição e pesquisa


@Service
public class MovieService {

    private final MovieRepository movieRepository;
    
    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }
    
    public List<Movie> searchMoviesByTitle(String title) {
        if (title == null || title.isEmpty()) {
            return getAllMovies();
        }
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }
    
    public List<Movie> getMoviesByGenre(String genre) {
        if (genre == null || genre.isEmpty()) {
            return getAllMovies();
        }
        return movieRepository.findByGenreContainingIgnoreCase(genre);
    }
}
