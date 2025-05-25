package br.com.brfilmes.repository;

import br.com.brfilmes.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// principal objetivo foi facilitar o uso do banco de dados a utilização do banco de dados
// Gerencia o catálogo de filmes no banco
// findByGenre - filtro por categoria
// findByTitle - implementa busca por nome
// Métodos ignoram maiúsc/minúsc para melhor UX

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByGenreContainingIgnoreCase(String genre);
    List<Movie> findByTitleContainingIgnoreCase(String title);
}
