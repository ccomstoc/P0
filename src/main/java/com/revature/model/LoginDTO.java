package com.revature.model;

import java.util.Objects;

public class LoginDTO {

    private String first_name;
    private String last_name;

    public LoginDTO(){

    }

    public LoginDTO(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
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

    @Override
    public String toString() {
        return "LoginDTO{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginDTO loginDTO = (LoginDTO) o;
        return Objects.equals(first_name, loginDTO.first_name) && Objects.equals(last_name, loginDTO.last_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name);
    }
}
