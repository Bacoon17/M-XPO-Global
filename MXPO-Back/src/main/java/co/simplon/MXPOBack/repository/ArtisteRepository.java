package co.simplon.MXPOBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.MXPOBack.model.Artiste;

@Repository
public interface ArtisteRepository extends JpaRepository<Artiste, Integer> {}
