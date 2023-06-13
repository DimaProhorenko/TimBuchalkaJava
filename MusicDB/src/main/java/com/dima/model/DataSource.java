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

    public static final String ARTISTS_VIEW = "artists_view";
    public static final String COLUMN_ARTISTS_VIEW_ID = "_id";
    public static final String COLUMN_ARTISTS_VIEW_ARTIST = "artist";
    public static final String COLUMN_ARTISTS_VIEW_ALBUM = "album";
    public static final String COLUMN_ARITSTS_VIEW_TITLE = "title";
    public static final String COLUMN_ARTISTS_VIEW_TRACK = "track";

    public static final String QUERY_ALL_ARTISTS = "SELECT * FROM %s ".formatted(TABLE_ARTISTS);
    public static final String QUERY_ALL_ARTISTS_SORT = "ORDER BY %s COLLATE NOCASE ".formatted(COLUMN_ARTISTS_NAME);

    public static final String QUERY_ALBUMS_BY_ARTIST_START =
            new StringBuilder("SELECT %s.%s, %s.%s FROM %s".formatted(TABLE_ARTISTS, COLUMN_ARTISTS_NAME, TABLE_ALBUMS, COLUMN_ALBUMS_NAME, TABLE_ALBUMS))
                    .append(" INNER JOIN %s ON %s.%s = %s.%s".formatted(TABLE_ARTISTS, TABLE_ALBUMS, COLUMN_ALBUMS_ARTIST, TABLE_ARTISTS, COLUMN_ARTISTS_ID))
                    .append(" WHERE %s.%s LIKE ".formatted(TABLE_ARTISTS, COLUMN_ARTISTS_NAME)).toString();

    public static final String QUERY_ALABUMS_BY_ARTIST_SORT = "ORDER BY %s.%s COLLATE NOCASE ".formatted(TABLE_ALBUMS, COLUMN_ALBUMS_NAME);
    public static final String QUERY_SONG_INFO = "SELECT * FROM %s WHERE %s LIKE ?"
            .formatted(ARTISTS_VIEW, COLUMN_ARTISTS_VIEW_ARTIST);

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
//        StringBuilder sbQuery = new StringBuilder("SELECT * FROM ");
//        sbQuery.append(TABLE_ARTISTS);
        StringBuilder sb = new StringBuilder(QUERY_ALL_ARTISTS);
        if (order != Order.NONE) {
            sb.append(QUERY_ALL_ARTISTS_SORT);
            sb.append(order.name());

        }
        List<Artist> artists = null;
        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sb.toString())) {
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

    public Song querySongArtistInfo(String songName) {
        Song searchSong = null;
        StringBuilder sb = new StringBuilder("SELECT %s.%s, %s.%s, %s.%s, %s.%s, %s.%s FROM %s ".formatted(
                TABLE_SONGS, COLUMN_SONGS_ID,
                TABLE_ARTISTS, COLUMN_ARTISTS_NAME,
                TABLE_ALBUMS, COLUMN_ALBUMS_NAME,
                TABLE_SONGS, COLUMN_SONGS_TITLE,
                TABLE_SONGS, COLUMN_SONGS_TRACK,
                TABLE_SONGS
        ));
        sb.append("INNER JOIN %s ON %s.%s = %s.%s ".formatted(TABLE_ALBUMS,
                TABLE_SONGS, COLUMN_SONGS_ALBUM,
                TABLE_ALBUMS, COLUMN_ALBUMS_ID
                ));
        sb.append("INNER JOIN %s ON %s.%s = %s.%s ".formatted(
                TABLE_ARTISTS,
                TABLE_ALBUMS, COLUMN_ALBUMS_ARTIST,
                TABLE_ARTISTS, COLUMN_ARTISTS_ID
        ));
        sb.append("WHERE %s.%s LIKE '%s%%' ".formatted(
                TABLE_SONGS, COLUMN_SONGS_TITLE,
                songName
        ));
        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            searchSong = new Song(
                    results.getInt(1),
                    results.getString(2),
                    results.getString(3),
                    results.getString(4),
                    results.getInt(5)
            );
        } catch (SQLException e) {
            System.out.println("Couldn't query Info " + e.getMessage());
            e.printStackTrace();
        }
        return searchSong;
    }

    public List<Song> queryArtistInfo(final String artistName) {
        List<Song> songs = null;
//        String sql = "SELECT * FROM " + ARTISTS_VIEW + " WHERE artist LIKE '" + artistName + "%'";

        try (PreparedStatement stmt = conn.prepareStatement(QUERY_SONG_INFO)) {
            stmt.setString(1, artistName + "%");
            ResultSet results = stmt.executeQuery();
            songs = new ArrayList<>();
            while(results.next()) {
                Song song = new Song(
                        results.getInt(COLUMN_ARTISTS_VIEW_ID),
                        results.getString(COLUMN_ARTISTS_VIEW_ARTIST),
                        results.getString(COLUMN_ARTISTS_VIEW_ALBUM),
                        results.getString(COLUMN_ARITSTS_VIEW_TITLE),
                        results.getInt(COLUMN_ARTISTS_VIEW_TRACK)
                );
                songs.add(song);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return songs;
    }

    public void printTableMetaData(String tableName) {
        String query = "SELECT * FROM " + tableName;
        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(query)) {
            ResultSetMetaData meta = results.getMetaData();
            int numOfCols = meta.getColumnCount();
            for (int i = 1; i <= numOfCols; i++) {
                System.out.printf("Column %d -> %s(%s)\n", i, meta.getColumnName(i), meta.getColumnClassName(i));
            }
        } catch (SQLException e) {
            System.out.printf("Couldn't query %s table -> %s", tableName, e.getMessage());
            e.printStackTrace();
        }
    }
}
