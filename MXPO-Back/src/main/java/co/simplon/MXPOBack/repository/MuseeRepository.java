package co.simplon.MXPOBack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.MXPOBack.model.Musee;

@Repository
public interface MuseeRepository extends JpaRepository<Musee, String> {
	
	List<Musee> findByCodeVille(String codeVille);
	
	
	
}
