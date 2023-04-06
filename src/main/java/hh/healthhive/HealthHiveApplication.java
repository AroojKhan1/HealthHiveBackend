package hh.healthhive;

import hh.healthhive.Model.User;
import hh.healthhive.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PropertySource("classpath:persistence-mysql.properties")
@SpringBootApplication(scanBasePackages = "hh.healthhive",exclude = HibernateJpaAutoConfiguration.class)
//@ComponentScan({"hh.healthhive"})
@EntityScan("hh.healthhive")
//@EnableJpaRepositories("hh.healthhive.Repository.TodoRepository")
@CrossOrigin(origins = "*")
public class HealthHiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthHiveApplication.class, args);
    }

}
