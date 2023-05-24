package com.dima;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
            Song s = findSong(title);
            if(s == null) {
                songs.add(new Song(title, duration));
                return true;
            }
            return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        if(trackNumber < 0 || trackNumber > songs.size() - 1) {
            return false;
        }

        Song songToAdd = songs.get(trackNumber);
        if(playlist.contains(songToAdd)) {
            return false;
        }
        playlist.add(songToAdd);
        return true;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song song = findSong(title);
        System.out.println(song);
        if(song == null || playlist.contains(song)) {
            return false;
        }
        playlist.add(song);
        return true;
    }



    private Song findSong(String title) {
        int index = songs.indexOf(new Song(title, 0));
        if(index == -1) return null;
        return songs.get(index);
    }
}
