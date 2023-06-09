package com.dima;

import com.dima.model.Artist;
import com.dima.model.DataSource;
import com.dima.model.Song;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataSource ds = new DataSource();
        ds.open();
        List<Artist> artists = ds.queryArtists(DataSource.Order.ASC);
//        if (artists != null) {
//            artists.forEach(System.out::println);
//        }
        List<String> albums = ds.queryAlbumsForArtist("Iron", DataSource.Order.ASC);
//        if (albums != null) {
//            albums.forEach(System.out::println);
//        }
        Song riverOfPain= ds.querySongArtistInfo("river of pain");

        List<Song> check = ds.queryArtistInfo("1000");

        if (check != null) {
            check.forEach(System.out::println);
        }

//        ds.printTableMetaData(DataSource.TABLE_SONGS);
        ds.close();
    }
}
