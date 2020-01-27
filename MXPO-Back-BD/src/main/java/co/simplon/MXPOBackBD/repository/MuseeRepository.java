package co.simplon.MXPOBackBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.MXPOBackBD.model.Musee;

@Repository
public interface MuseeRepository extends JpaRepository<Musee, String> {}