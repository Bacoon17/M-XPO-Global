package co.simplon.MXPOBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.MXPOBack.model.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Integer> {}