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
import backapp.demo.models.Response;
import backapp.demo.models.Support;
import backapp.demo.repositories.DataRepository;

@RestController
@RequestMapping("/api")
public class SongController {
    @Autowired
    private DataRepository dataRepository;

   
    @GetMapping("/JSON-Songs")
    public ResponseEntity<Response> getJSONSongs() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*"); 

        Response response = new Response(1, 6, 12, 2);
        Support support = new Support("https://reqres.in/#support-heading", 
        "To keep ReqRes free, contributions towards server costs are appreciated!");
        response.setSupport(support);
        response.setData(dataRepository.findAll());

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @GetMapping("/songs")
    public List<Data> getAllSongs(){
        return dataRepository.findAll();
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
    
    // @DeleteMapping("/deleteSong")
    // public Data deleteSong(@RequestParam int id) {
    //     dataRepository.delete(dataRepository.findById(id));
    //     return data;
    // }

    // @PutMapping("/updateSong")
    // public Data updateSong(@RequestBody Data data) {

    //     return dataToUpdate;
    // }

  

}
