package com.revature.model;

import java.sql.Time;
import java.util.Objects;

public class TimeListenedDTO {

    private int person_id_pk;
    private String first_name;
    private String last_name;
    private String duration;

    public TimeListenedDTO(){

    }

    public TimeListenedDTO(int person_id_pk, String first_name, String last_name, String duration) {
        this.person_id_pk = person_id_pk;
        this.first_name = first_name;
        this.last_name = last_name;
        this.duration = duration;
    }

    public int getPerson_id_pk() {
        return person_id_pk;
    }

    public void setPerson_id_pk(int person_id_pk) {
        this.person_id_pk = person_id_pk;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "TimeListenedDTO{" +
                "person_id_pk=" + person_id_pk +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeListenedDTO that = (TimeListenedDTO) o;
        return person_id_pk == that.person_id_pk && Objects.equals(first_name, that.first_name) && Objects.equals(last_name, that.last_name) && Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_id_pk, first_name, last_name, duration);
    }
}
