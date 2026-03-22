package br.com.vanzele.encurtador.repository;

import br.com.vanzele.encurtador.model.Url;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {

    Optional<Url> findByCodigo(String codigo);
    Optional<Url> findByUrlOriginal(String urlOriginal);
}
