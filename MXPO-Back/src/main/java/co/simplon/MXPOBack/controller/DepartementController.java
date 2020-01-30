package co.simplon.MXPOBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBack.repository.DepartementRepository;

@RestController
@CrossOrigin("*")
public class DepartementController {

	@Autowired
	private DepartementRepository departementRepository;
	
}
