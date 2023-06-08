package com.dima.model;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class DataSource {
    public static final String DB_NAME = "music.db";

    public static final String CONNECTION_STRING = "jdbc:sqlite:D:/TimBuchalka/MusicDB/src/main/resources/database/" + DB_NAME;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTISTS_ID = "_id";
    public static final String COLUMN_ARTISTS_NAME = "name";

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUMS_ID = "_id";
    public static final String COLUMN_ALBUMS_NAME = "name";
    public static final String COLUMN_ALBUMS_ARTIST = "artist";

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONGS_ID = "_id";
    public static final String COLUMN_SONGS_TRACK = "track";
    public static final String COLUMN_SONGS_TITLE = "title";
    public static final String COLUMN_SONGS_ALBUM = "album";

    public static final String QUERY_ALBUMS_BY_ARTIST_START =
            new StringBuilder("SELECT %s.%s, %s.%s FROM %s".formatted(TABLE_ARTISTS, COLUMN_ARTISTS_NAME, TABLE_ALBUMS, COLUMN_ALBUMS_NAME, TABLE_ALBUMS))
                    .append(" INNER JOIN %s ON %s.%s = %s.%s".formatted(TABLE_ARTISTS, TABLE_ALBUMS, COLUMN_ALBUMS_ARTIST, TABLE_ARTISTS, COLUMN_ARTISTS_ID))
                    .append(" WHERE %s.%s LIKE ".formatted(TABLE_ARTISTS, COLUMN_ARTISTS_NAME)).toString();

    public static final String QUERY_ALABUMS_BY_ARTIST_SORT = "ORDER BY %s.%s ".formatted(TABLE_ALBUMS, COLUMN_ALBUMS_NAME);

    public enum Order {
        NONE,
        ASC,
        DESC
    }

    private Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean close() {
        try {
            if (conn != null) {
                conn.close();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close database " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public List<Artist> queryArtists(Order order) {
        StringBuilder sbQuery = new StringBuilder("SELECT * FROM ");
        sbQuery.append(TABLE_ARTISTS);
        if (order != Order.NONE) {
            sbQuery.append(" ORDER BY " + COLUMN_ARTISTS_NAME);
            sbQuery.append(" COLLATE NOCASE ");
            sbQuery.append(order.name());

        }
        List<Artist> artists = null;
        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sbQuery.toString())) {
            artists = new ArrayList<>();
            while (results.next()) {
                artists.add(new Artist(results.getInt(COLUMN_ARTISTS_ID),
                        results.getString(COLUMN_ARTISTS_NAME)));
            }
        } catch(SQLException e) {
            System.out.println("Query failed " + e.getMessage());
            e.printStackTrace();
        } finally {
            return artists;
        }
    }

    public List<Artist> queryArtists() {
        return queryArtists(Order.ASC);
    }

    public List<String> queryAlbumsForArtist(String artistName, Order order) {
//        StringBuilder sb = new StringBuilder("SELECT %s.%s, %s.%s FROM %s".formatted(TABLE_ARTISTS, COLUMN_ARTISTS_NAME, TABLE_ALBUMS, COLUMN_ALBUMS_NAME, TABLE_ALBUMS));
//        sb.append(" INNER JOIN %s ON %s.%s = %s.%s".formatted(TABLE_ARTISTS, TABLE_ALBUMS, COLUMN_ALBUMS_ARTIST, TABLE_ARTISTS, COLUMN_ARTISTS_ID));
//        sb.append(" WHERE %s.%s LIKE '%s%%'".formatted(TABLE_ARTISTS,COLUMN_ALBUMS_NAME, artistName));
        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
        sb.append("'%s%%' ".formatted(artistName));

        if (order != Order.NONE) {
            sb.append(QUERY_ALABUMS_BY_ARTIST_SORT + order.name());
        }
        System.out.println(sb);

        List<String> albums = null;

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {
            albums = new ArrayList<>();
            while(results.next()) {
                albums.add(results.getString(1) + " " + results.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("Couldn't query albums " + e.getMessage());
            e.printStackTrace();
        } finally {
            return albums;
        }
    }
}
