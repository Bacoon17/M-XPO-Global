package co.simplon.MXPOBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.MXPOBack.model.ThemeOeuvre;

@Repository
public interface ThemeOeuvreRepository extends JpaRepository<ThemeOeuvre, Integer> {}
