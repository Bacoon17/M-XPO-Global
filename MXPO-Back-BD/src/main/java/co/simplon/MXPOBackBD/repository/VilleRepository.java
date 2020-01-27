package co.simplon.MXPOBackBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.MXPOBackBD.model.Ville;

@Repository
public interface VilleRepository extends JpaRepository<Ville, String> {}
