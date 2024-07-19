package com.revature.model;

import java.util.Objects;

public class Album {

    private int album_id_pk;
    private String album_name;
    private String artist_name;
    private int year_released;
    private String duration;

    //Format of postgres interval: '3 hours 2 minutes 1 second'

    public Album(){ // Default constructor for use with json conversions

    }

    public Album(int album_id_pk, String album_name, String artist_name, int year_released, String duration) {
        this.album_id_pk = album_id_pk;
        this.album_name = album_name;
        this.artist_name = artist_name;
        this.year_released = year_released;
        this.duration = duration;
    }

    //No id, for use when inserting, because id is serial
    public Album(String artist_name, String album_name, String duration, int year_released) {
        this.artist_name = artist_name;
        this.album_name = album_name;
        this.duration = duration;
        this.year_released = year_released;
    }

    public int getAlbum_id_pk() {
        return album_id_pk;
    }

    public void setAlbum_id_pk(int album_id_pk) {
        this.album_id_pk = album_id_pk;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public int getYear_released() {
        return year_released;
    }

    public void setYear_released(int year_released) {
        this.year_released = year_released;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Album{" +
                "album_id_pk=" + album_id_pk +
                ", album_name='" + album_name + '\'' +
                ", artist_name='" + artist_name + '\'' +
                ", year_released=" + year_released +
                ", duration='" + duration + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return album_id_pk == album.album_id_pk && year_released == album.year_released && Objects.equals(album_name, album.album_name) && Objects.equals(artist_name, album.artist_name) && Objects.equals(duration, album.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(album_id_pk, album_name, artist_name, year_released, duration);
    }
}
