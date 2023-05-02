package backapp.demo.interfaces;

import java.util.List;

import backapp.demo.models.Data;
import backapp.demo.models.Response;

public interface SongServiceInterface {

    public Response getJSONSongs();

    public List<Data> getAllSongs();

    public Data addSong(Data data);

    public Data deleteSong(int id); 

    public Data updateSong(Data data); 
}
