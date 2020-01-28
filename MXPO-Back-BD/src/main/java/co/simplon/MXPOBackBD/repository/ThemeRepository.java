package co.simplon.MXPOBackBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.MXPOBackBD.model.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Integer> {}