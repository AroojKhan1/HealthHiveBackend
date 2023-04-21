package hh.healthhive.Controller;


import hh.healthhive.Model.Role;
import hh.healthhive.Model.User;
import hh.healthhive.Repository.RoleRepository;
import hh.healthhive.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "*")
@Validated

public class UserController {

        @Autowired
        private UserRepository repository;

        @Autowired
        private RoleRepository roleRepository;

        @PostMapping("/register")
        public ResponseEntity<String> register(@Valid @RequestBody User user) {


            String suc= "Hi " + user.getUser_name() + "Welcome to the Hive! Login using your username & password";
            try {
                Role role = new Role();
                role.setRole(user.getRole());
                repository.save(user);
                role.setUser(user);
                roleRepository.save(role);
                user.getRoles().add(role);

                // Return success response
                String message = ""+suc;
                return new ResponseEntity<>(message, HttpStatus.OK);
            } catch (Exception e) {
                String errorMessage = "An error occurred while registering the user.";
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
            }
        }

        @GetMapping("/getAllUsers")
        public List<User> findAllUsers() {
            return repository.findAll();
        }

        @GetMapping("/findUser/{email}")
        public List<User> findUser(@PathVariable String email) {
            return repository.findByEmail(email);
        }

//    @GetMapping("/findUserbyid/{id}")
//    public User findUserbyid(@PathVariable Long id) {
//        System.out.println(id);
////        String name = String.valueOf(repository.findNameByUserId(id));
//        return repository.findByUserId(id);
//    }

//    @GetMapping("/findUserbyid/{id}")
//    public ResponseEntity<Map<String, String>> findUserbyid(@PathVariable Long id) {
//        String name = String.valueOf(repository.findByUserId(id));
//        Map<String, String> response = new HashMap<>();
//        response.put("name", name);
//        return ResponseEntity.ok().body(response);
//    }
        @DeleteMapping("/cancel/{id}")
        public List<User> cancelRegistration(@PathVariable int id) {
            repository.deleteById(id);
            return repository.findAll();
        }

}




