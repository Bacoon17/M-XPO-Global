package co.simplon.MXPOBack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.MXPOBack.model.Ville;

@Repository
public interface VilleRepository extends JpaRepository<Ville, String> {
	
	List<Ville> findByNomVille(String nomVille);
	List<Ville> findByCodeDepartement(String codeDepartement);
	
}

