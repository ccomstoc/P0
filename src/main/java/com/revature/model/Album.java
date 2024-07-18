package com.revature.model;

public class Album {

    private int album_id_pk;
    private String album_name;
    private String artist_name;
    private int year_released;
    private String duration; //Format of postgres interval: '3 hours 2 minutes 1 second'

    public Album(int album_id_pk, String album_name, String artist_name, int year_released, String duration) {
        this.album_id_pk = album_id_pk;
        this.album_name = album_name;
        this.artist_name = artist_name;
        this.year_released = year_released;
        this.duration = duration;
    }
}
