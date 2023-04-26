package backapp.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import backapp.demo.models.Data;
import backapp.demo.models.User;
import backapp.demo.repositories.DataRepository;
import backapp.demo.repositories.UserRepository;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

  @Autowired
  DataRepository dataRepository;

  @Autowired
  UserRepository userRepository;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Override 
  public void run(String... args) throws Exception {
    
    dataRepository.saveAll(Arrays.asList(
        new Data("george.bluth@reqres.in", "George", "Bluth", "https://reqres.in/img/faces/1-image.jpg"),
        new Data("janet.weaver@reqres.in", "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg"),
        new Data("emma.wong@reqres.in", "Emma", "Wong", "https://reqres.in/img/faces/3-image.jpg"),
        new Data("eve.holt@reqres.in", "Eve", "Holt", "https://reqres.in/img/faces/4-image.jpg"),
        new Data("charles.morris@reqres.in", "Charles", "Morris", "https://reqres.in/img/faces/5-image.jpg"),
        new Data("tracey.ramos@reqres.in", "Tracey", "Ramos", "https://reqres.in/img/faces/6-image.jpg")
      )
    );

    userRepository.saveAll(Arrays.asList(
      new User("natalie", "gomez", "ngomez.cep@gmail.com", "12345678")
      )
    );
  }
 
}

  
 
