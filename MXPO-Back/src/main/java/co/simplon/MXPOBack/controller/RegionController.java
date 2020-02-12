package co.simplon.MXPOBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBack.model.Region;
import co.simplon.MXPOBack.repository.RegionRepository;


@RestController
@CrossOrigin("*")
public class RegionController {
	
	@Autowired
	private RegionRepository regionRepository;
	
	@GetMapping("/regions")
	public List<Region> getAllRegion() {
		return regionRepository.findAll();
	}
	
}
