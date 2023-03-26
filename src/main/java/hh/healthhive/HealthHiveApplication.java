package hh.healthhive;

import hh.healthhive.Model.User;
import hh.healthhive.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
//@RestController
@CrossOrigin(origins = "*")
public class HealthHiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthHiveApplication.class, args);
    }

}
