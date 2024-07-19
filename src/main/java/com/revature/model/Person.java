package com.revature.model;

import java.util.Objects;

public class Person {

    private int person_id_pk;

    private String first_name;
    private String last_name;

    public Person(){

    }

    public Person(int person_id_pk, String first_name, String last_name) {
        this.person_id_pk = person_id_pk;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public void setPerson_id_pk(int person_id_pk) {
        this.person_id_pk = person_id_pk;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getPerson_id_pk() {
        return person_id_pk;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_id_pk=" + person_id_pk +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return person_id_pk == person.person_id_pk && Objects.equals(first_name, person.first_name) && Objects.equals(last_name, person.last_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_id_pk, first_name, last_name);
    }
}
