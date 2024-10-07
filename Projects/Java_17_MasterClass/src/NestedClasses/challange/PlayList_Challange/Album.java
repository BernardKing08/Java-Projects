package NestedClasses.challange.PlayList_Challange;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    
    private String name; 
    private String artist;
    private SongList songs;

    public Album(String name, String artist){
        this.name = name; 
        this.artist = artist;
        this.songs = new SongList();
    }

    //Adds a song with the given title and duration to the album
    public boolean addSong(String title, double duration){
        if(songs.findSong(title) == null){    
            songs.add(new Song(title, duration));
            return true;
        }
        else{
            return false;
        }

    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        Song checkedSong = songs.findSong(trackNumber);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }
    
    // Adds a song to the playlist using song title
    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song song = songs.findSong(title);
        if (song != null) {
            playList.add(song);
            return true;
        }
        return false;
    }

    public static class SongList{
        private ArrayList<Song> songs;

        private SongList(){
            songs = new ArrayList<>();
        }

        private boolean add(Song song){
            if(!songs.contains(song)){
                songs.add(song); 
            }
            
            return true;
        }

        private Song findSong(String title){
            for(Song s : songs){
                if(s.getTitle().equals(title)){
                    return s;
                }
            }

            return null;
        }

        private Song findSong(int trackNumber){
            if (trackNumber > 0 && trackNumber <= songs.size()) {
                Song song = songs.get(trackNumber - 1);
                add(song);
                return song;
            }
            return null;
        }
    }
}
