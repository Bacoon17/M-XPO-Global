package co.simplon.MXPOBack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.MXPOBack.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, String> {
	
}