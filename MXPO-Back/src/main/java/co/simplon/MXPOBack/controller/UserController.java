package co.simplon.MXPOBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBack.repository.UserRepository;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
}
