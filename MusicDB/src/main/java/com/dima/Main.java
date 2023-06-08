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

        ds.printTableMetaData(DataSource.TABLE_SONGS);
        ds.close();
    }
}
