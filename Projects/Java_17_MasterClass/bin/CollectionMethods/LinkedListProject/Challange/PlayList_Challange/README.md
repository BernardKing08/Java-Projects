# Playlist Program

## Overview

This program implements a basic playlist system for managing albums and songs. It includes two main classes: `Album` and `Song`. The `Album` class manages a collection of `Song` objects and supports adding songs, finding songs, and managing playlists. The `Song` class represents individual songs with a title and duration.

## Classes

### 1. `Album`

The `Album` class contains:
- **Fields**:
  - `name`: A `String` representing the name of the album.
  - `artist`: A `String` representing the artist of the album.
  - `songs`: An `ArrayList` of `Song` objects representing the songs in the album.

- **Constructor**:
  - `Album(String name, String artist)`: Initializes the album with the given name and artist, and instantiates the `songs` list.

- **Methods**:
  - `boolean addSong(String title, double duration)`: Adds a song with the given title and duration to the album. Returns `true` if the song was added successfully, or `false` otherwise.
  - `Song findSong(String title)`: Searches for a song by title. Returns the `Song` object if found, or `null` if not found. (Private method)
  - `boolean addToPlayList(int trackNumber, LinkedList<Song> playList)`: Adds a song to the playlist based on its track number in the album. Returns `true` if the song was added successfully, or `false` otherwise.
  - `boolean addToPlayList(String title, LinkedList<Song> playList)`: Adds a song to the playlist based on its title. Returns `true` if the song was added successfully, or `false` otherwise.

### 2. `Song`

The `Song` class contains:
- **Fields**:
  - `title`: A `String` representing the title of the song.
  - `duration`: A `double` representing the duration of the song in minutes.

- **Constructor**:
  - `Song(String title, double duration)`: Initializes the song with the given title and duration.

- **Methods**:
  - `String getTitle()`: Returns the title of the song.
  - `String toString()`: Returns a `String` in the format `"title: duration"`.

## Sample Input

```java
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<>();
        
        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);
        
        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        albums.add(album);
        
        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList);  // Does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList);  // There is no track 24
    }
}
