package co.simplon.MXPOBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBack.repository.RegionRepository;

@RestController
@CrossOrigin("*")
public class RegionController {
	
	@Autowired
	private RegionRepository regionRepository;
	
}
