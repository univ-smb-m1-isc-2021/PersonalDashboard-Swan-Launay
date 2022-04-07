package me.nakashita.personal_dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    /*
    @Autowired
    UserRepository userRepository;
    */


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        /*
        User user = new User();
        user.setUsername("ADMIN");
        user.setPassword("ADMIN");
        userRepository.save(user);
        */

    }

}
