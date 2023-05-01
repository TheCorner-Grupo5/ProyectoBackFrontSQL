package backapp.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import backapp.demo.models.Response;
import backapp.demo.models.Support;
import backapp.demo.repositories.DataRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")

public class SongController {
    @Autowired
    private DataRepository dataRepository;

   
    // @GetMapping("/JSON-Songs")
    // public ResponseEntity<Response> getJSONSongs() {
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.add("Access-Control-Allow-Origin", "*"); 

    //     Response response = new Response(1, 6, 12, 2);
    //     Support support = new Support("https://reqres.in/#support-heading", 
    //     "To keep ReqRes free, contributions towards server costs are appreciated!");
    //     response.setSupport(support);
    //     response.setData(dataRepository.findAll());

    //     return new ResponseEntity<>(response, headers, HttpStatus.OK);
    // }

    @GetMapping("/JSON-Songs")
    public Response getJSONSongs() {
        Response response = new Response(1, 6, 12, 2);
        Support support = new Support("https://reqres.in/#support-heading", 
        "To keep ReqRes free, contributions towards server costs are appreciated!");
        response.setSupport(support);
        response.setData(dataRepository.findAll());

        return response;
    }

    @GetMapping("/getSongs")
    public List<Data> getAllSongs(){
        return dataRepository.findAll();
    }


    @PostMapping("/addSong")
    public Data addSong(@RequestBody Data data) {
        if (dataRepository.existsByEmail(data.getEmail())) {
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
        if (data.getFirstName() != null) {
            dataToUpdate.setFirstName(data.getFirstName());
        }
        if (data.getLastName() != null) {
            dataToUpdate.setLastName(data.getLastName());
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
