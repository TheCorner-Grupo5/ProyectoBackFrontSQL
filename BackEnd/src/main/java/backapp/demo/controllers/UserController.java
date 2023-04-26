package backapp.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import backapp.demo.models.Data;
import backapp.demo.repositories.UserRepository;


@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/users")
    public List<Data> getAllUsers(){
        return userRepository.findAll();
    }


    @PostMapping("/addSong")
    public Data addSong(@RequestBody Data data) {
        int counter = 0;
        for(Data dt: getAllSongs()){
            if(dt.equals(data)){
                counter++;
            }
        }
        if (counter > 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The element already exists in the repository");
        } else {
            return dataRepository.save(data);
        }
    }
    
    @DeleteMapping("/deleteSong")
    public Data deleteSong(@RequestParam int id) {
        Data data = dataRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Song not found"));
        dataRepository.delete(data);
        return data;
    }

    @PutMapping("/updateSong")
    public Data updateSong(@RequestBody Data data) {
        Data dataToUpdate = dataRepository.findById(data.getId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Song not found"));
        if (data.getFirst_name() != null) {
            dataToUpdate.setFirst_name(data.getFirst_name());
        }
        if (data.getLast_name() != null) {
            dataToUpdate.setLast_name(data.getLast_name());
        }
        if (data.getEmail() != null) {
            dataToUpdate.setEmail(data.getEmail());
        }
        if (data.getAvatar() != null) {
            dataToUpdate.setAvatar(data.getAvatar());
        }
        return dataRepository.save(dataToUpdate);
    }

  

}
