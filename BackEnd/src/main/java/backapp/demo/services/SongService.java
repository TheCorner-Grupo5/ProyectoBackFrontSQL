package backapp.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import backapp.demo.interfaces.SongServiceInterface;
import backapp.demo.models.Data;
import backapp.demo.models.Response;
import backapp.demo.models.Support;
import backapp.demo.repositories.SongRepository;

@Service
public class SongService implements SongServiceInterface{
    @Autowired
    private SongRepository songRepository;

    public Response getJSONSongs() {
        Response response = new Response(1, 6, 12, 2);
        Support support = new Support("https://reqres.in/#support-heading", 
        "To keep ReqRes free, contributions towards server costs are appreciated!");
        response.setSupport(support);
        response.setData(songRepository.findAll());

        return response;
    }


    public List<Data> getAllSongs(){
        return songRepository.findAll();
    }


    public Data addSong(Data data) {
        if (songRepository.existsByEmail(data.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The element already exists in the repository");
        } else {
            return songRepository.save(data);
        }
    }
    

    public Data deleteSong(int id) {
        Data data = songRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Song not found"));
        songRepository.delete(data);
        return data;
    }


    public Data updateSong(Data data) {
        Data dataToUpdate = songRepository.findById(data.getId())
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
        return songRepository.save(dataToUpdate);
    }

  

}
