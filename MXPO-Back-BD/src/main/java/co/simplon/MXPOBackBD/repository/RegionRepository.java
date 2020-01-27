package co.simplon.MXPOBackBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.MXPOBackBD.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, String> {}
