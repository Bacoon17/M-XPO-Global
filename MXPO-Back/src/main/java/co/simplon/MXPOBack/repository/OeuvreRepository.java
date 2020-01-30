package co.simplon.MXPOBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.MXPOBack.model.Oeuvre;

@Repository
public interface OeuvreRepository extends JpaRepository<Oeuvre, Integer> {}