package co.simplon.MXPOBackBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.MXPOBackBD.model.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, String> {}
