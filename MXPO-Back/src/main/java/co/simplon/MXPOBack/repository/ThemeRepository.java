package co.simplon.MXPOBack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.MXPOBack.model.Musee;
import co.simplon.MXPOBack.model.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Integer> {
	
	 
	
}