package br.com.brfilmes.repository;

import br.com.brfilmes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
// principal objetivo foi facilitar o uso do banco de dados a utilização do banco de dados
// Interface para acesso ao banco de dados dos usuários
// Herda JpaRepository para operações CRUD básicas
// findByEmail - busca p/ login
// existsByEmail - verifica duplicatas no cadastro

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}