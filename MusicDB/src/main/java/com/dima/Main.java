package com.dima;

import com.dima.model.Artist;
import com.dima.model.DataSource;

import javax.xml.crypto.Data;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataSource ds = new DataSource();
        ds.open();
        List<Artist> artists = ds.queryArtists(DataSource.Order.DESC);
//        artists.forEach(System.out::println);
        List<String> albums = ds.queryAlbumsForArtist("Iron", DataSource.Order.ASC);
        if (albums != null) {
            albums.forEach(System.out::println);
        }
        ds.close();
    }
}
