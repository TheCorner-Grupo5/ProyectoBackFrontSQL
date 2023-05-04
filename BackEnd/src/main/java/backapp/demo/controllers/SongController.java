package backapp.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backapp.demo.interfaces.SongServiceInterface;
import backapp.demo.models.Data;
import backapp.demo.models.Response;
import backapp.demo.services.SongService;

@RestController
@CrossOrigin
@RequestMapping("/api")


public class SongController implements SongServiceInterface {


    @Autowired
    private SongService songService;


    @GetMapping("/JSON-Songs")
    public Response getJSONSongs() {
        return songService.getJSONSongs();
    }

    @GetMapping("/getSongs")
    public List<Data> getAllSongs(){
        return songService.getAllSongs();
    }


    @PostMapping("/addSong")
    public Data addSong(@RequestBody Data data) {
        return songService.addSong(data);
    }
    
    @DeleteMapping("/deleteSong")
    public Data deleteSong(@RequestParam int id) {
        return songService.deleteSong(id);
    }

    @PutMapping("/updateSong")
    public Data updateSong(@RequestBody Data data) {
        return songService.updateSong(data);
    }

  

}
