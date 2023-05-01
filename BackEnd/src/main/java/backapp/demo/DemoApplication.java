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
        new Data( "George", "Bluth","george.bluth@reqres.in", "https://reqres.in/img/faces/1-image.jpg"),
        new Data( "Janet", "Weaver","janet.weaver@reqres.in", "https://reqres.in/img/faces/2-image.jpg"),
        new Data( "Emma", "Wong","emma.wong@reqres.in", "https://reqres.in/img/faces/3-image.jpg"),
        new Data( "Eve", "Holt","eve.holt@reqres.in", "https://reqres.in/img/faces/4-image.jpg"),
        new Data( "Charles", "Morris","charles.morris@reqres.in", "https://reqres.in/img/faces/5-image.jpg"),
        new Data( "Tracey", "Ramos","tracey.ramos@reqres.in", "https://reqres.in/img/faces/6-image.jpg")
      )
    );

    userRepository.saveAll(Arrays.asList(
      new User("natalie", "gomez", "ngomez.cep@gmail.com", "12345678"),
      new User("Natalie", "gomez", "ngomez1.cep@gmail.com", "12345678"),
      new User("NAtalie", "gomez", "ngomez2.cep@gmail.com", "12345678"),
      new User("NATalie", "gomez", "ngomez3.cep@gmail.com", "12345678"),
      new User("NATAlie", "gomez", "ngomez4.cep@gmail.com", "12345678")
      )
    );
  }
 
}

  
 
