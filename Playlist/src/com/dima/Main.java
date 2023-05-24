package com.dima;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Album album = new Album("NEW ROCK", "Dima");
        album.addSong("No new road", 2.37);
        album.addSong("Highway", 3.01);
        LinkedList<Song> playlist = new LinkedList<>();
        album.addToPlayList(0, playlist);
        album.addToPlaylist("Highway", playlist);
        System.out.println(playlist);
    }
}
