package com.revature.DAO;

import com.revature.model.Person;
import com.revature.model.TimeListenedDTO;

import java.sql.*;
import java.util.ArrayList;

public class PersonDAO implements PersonDAOInterface {

    Connection con;
    public PersonDAO(Connection con){
        this.con = con;
    }



    public Person insertPerson(Person person) throws SQLException {

        PreparedStatement ps = con.prepareStatement("insert into person(first_name,last_name) values(?,?)RETURNING person_id_pk");
        ps.setString(1,person.getFirst_name());
        ps.setString(2, person.getLast_name());

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("person_id_pk");
            person.setPerson_id_pk(id); // Assuming Album class has a setId method
        }

        return person;
    }

    public Person getPersonById(int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("select * from person where person_id_pk = ?");
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        Person person = null;
        while(rs.next()){
            person = new Person(
                rs.getInt("person_id_pk"),
                rs.getString("first_name"),
                rs.getString("last_name")
            );
        }
        return person;

    }

    @Override
    public Person updatePerson(Person person) throws SQLException {
        PreparedStatement ps;

        if(person.getFirst_name() != null) {
            ps = con.prepareStatement("update person set first_name = ? where person_id_pk = ?");
            ps.setInt(2,person.getPerson_id_pk());
            ps.setString(1,person.getFirst_name());
            ps.executeUpdate();
        }
        if(person.getLast_name() != null) {
            ps = con.prepareStatement("update person set last_name = ? where person_id_pk = ?");
            ps.setInt(2,person.getPerson_id_pk());
            ps.setString(1,person.getLast_name());
            ps.executeUpdate();
        }

        return getPersonById(person.getPerson_id_pk());

    }
    public ArrayList<TimeListenedDTO> lengthOfCollections() throws SQLException {
        PreparedStatement ps = con.prepareStatement(
                "select person.person_id_pk,person.first_name,person.last_name,sum(album.duration)as length_of_collection\n" +
                "from person,album,owns\n" +
                "where person.person_id_pk =owns.person_id_fk and album.album_id_pk = owns.album_id_fk \n" +
                "group by person.person_id_pk \n" +
                "order by length_of_collection desc");
        ResultSet rs = ps.executeQuery();
        ArrayList<TimeListenedDTO> timeListenedDTOArrayList = new ArrayList<>();
        while(rs.next()){
            timeListenedDTOArrayList.add(new TimeListenedDTO(
                    rs.getInt("person_id_pk"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("length_of_collection")

            ));
        }
        return timeListenedDTOArrayList;
    }

}
