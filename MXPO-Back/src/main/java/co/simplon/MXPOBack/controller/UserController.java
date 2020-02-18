package co.simplon.MXPOBack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.MXPOBack.model.User;
import co.simplon.MXPOBack.repository.UserRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * permet a un utilisateur de se creer un compte
     * @param newUser
     * @return
     */
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Optional<User> create(@RequestBody User newUser) {

        Optional<User> reponse = null;

        if( !userRepository.findByMail(newUser.getMail()).isPresent()) {
            reponse = Optional.of(userRepository.saveAndFlush(newUser)) ;
        }

        return reponse;
    }

    /**
     * affiche la liste des utilisateurs
     * @return
     */
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<User> display() {
        return userRepository.findAll();
    }


    /**
     * permet a l'utilisateur de mettre son compte a jour.
     * @param majUser
     * @return
     */
    @PostMapping("/update")
    @ResponseStatus (code = HttpStatus.OK)
    public Optional<User> update(@RequestBody User majUser) {


        return Optional.of(userRepository.save(majUser));
    }


    /**
     * Permet a l'utilisateur de se connecter a son compte.
     * @param mail
     * @param mdp
     * @return
     */
    @RequestMapping("/login")
    @ResponseStatus (code = HttpStatus.OK)
    public Optional<User> login(@RequestParam (value = "mail") String mail,
                                      @RequestParam(value = "mdp") String mdp) {
        
        Optional<User> reponse = null;
        Optional<User> userMail = userRepository.findByMail(mail);


        if (userMail.isPresent() && userMail.get().getMdp().equals(mdp)) {
            reponse = userMail ;
        }
           return reponse;
    }

}