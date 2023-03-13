package hh.healthhive.Controller;


import hh.healthhive.Model.User;
import hh.healthhive.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")

public class UserController {

        @Autowired
        private UserRepository repository;

        @PostMapping("/register")
        public String register(@RequestBody User user) {
            repository.save(user);
            return "Hi " + user.getUser_name() + " your Registration process successfully completed ur id is " + user.getIdUser();
        }

        @GetMapping("/getAllUsers")
        public List<User> findAllUsers() {
            return repository.findAll();
        }

        @GetMapping("/findUser/{email}")
        public List<User> findUser(@PathVariable String email) {
            return repository.findByEmail(email);
        }

        @DeleteMapping("/cancel/{id}")
        public List<User> cancelRegistration(@PathVariable int id) {
            repository.deleteById(id);
            return repository.findAll();
        }

}




