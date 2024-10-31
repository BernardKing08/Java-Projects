package CollectionMethods.LinkedListProject.Challange.PlayList_Challange;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    
    private String name; 
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist){
        this.name = name; 
        this.artist = artist;
        songs = new ArrayList<Song>();
    }

    //Adds a song with the given title and duration to the album
    public boolean addSong(String title, double duration){
        if(findSong(title) == null){    
            songs.add(new Song(title, duration));
            return true;
        }
        else{
            return false;
        }

    }

    public Song findSong(String title){
        for(var s : songs){
            if(s.getTitle().equals(title)){
                return s;
            }
        }

        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        if (trackNumber > 0 && trackNumber <= songs.size()) {
            Song song = songs.get(trackNumber - 1);
            playList.add(song);
            return true;
        }
        return false;
    }
    
    // Adds a song to the playlist using song title
    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song song = findSong(title);
        if (song != null) {
            playList.add(song);
            return true;
        }
        return false;
    }
}
