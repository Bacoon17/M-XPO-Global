package co.simplon.MXPOBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.MXPOBack.model.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, String> {}