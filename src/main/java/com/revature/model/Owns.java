package com.revature.model;

import java.util.Objects;

public class Owns {

    private int owns_index_pk;
    private int person_id_fk;
    private int album_id_fk;

    private Person person;
    private Album album;

    public Owns(){

    }

    public Owns(int owns_index_pk, int person_id_fk, int album_id_fk) {
        this.owns_index_pk = owns_index_pk;
        this.person_id_fk = person_id_fk;
        this.album_id_fk = album_id_fk;
    }

    public int getOwns_index_pk() {
        return owns_index_pk;
    }

    public void setOwns_index_pk(int owns_index_pk) {
        this.owns_index_pk = owns_index_pk;
    }

    public int getPerson_id_fk() {
        return person_id_fk;
    }

    public void setPerson_id_fk(int person_id_fk) {
        this.person_id_fk = person_id_fk;
    }

    public int getAlbum_id_fk() {
        return album_id_fk;
    }

    public void setAlbum_id_fk(int album_id_fk) {
        this.album_id_fk = album_id_fk;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Owns{" +
                "owns_index_pk=" + owns_index_pk +
                ", person_id_fk=" + person_id_fk +
                ", album_id_fk=" + album_id_fk +
                ", person=" + person +
                ", album=" + album +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owns owns = (Owns) o;
        return owns_index_pk == owns.owns_index_pk && person_id_fk == owns.person_id_fk && album_id_fk == owns.album_id_fk && Objects.equals(person, owns.person) && Objects.equals(album, owns.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owns_index_pk, person_id_fk, album_id_fk, person, album);
    }
}
