//package hh.healthhive.Service;
//
//import hh.healthhive.Model.User;
//import hh.healthhive.Repository.UserRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//public class UserService {
//
//    private UserRepository userRepository;
//    private BCryptPasswordEncoder passwordEncoder;
//
//    public UserService (UserRepository userRepository){
//        this.userRepository = userRepository;
//        this.passwordEncoder = new BCryptPasswordEncoder();
//    }
//
//    public void registerUser(User user){
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//
//    }
//
//
//}
