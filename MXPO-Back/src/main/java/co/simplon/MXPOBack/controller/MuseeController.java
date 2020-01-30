package co.simplon.MXPOBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBack.repository.MuseeRepository;

@RestController
@CrossOrigin("*")
public class MuseeController {

	@Autowired
	private MuseeRepository museeRepository;
	
}
