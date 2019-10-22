package edu.javaproject.cityregister.dao;

import edu.javaproject.cityregister.domain.PersonRequest;
import edu.javaproject.cityregister.domain.PersonResponse;
import edu.javaproject.cityregister.exception.PersonCheckException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/***
 * That class is data access object.
 * That class get access to data in our dictionaries in city_register database
 * (tables: cr_address, cr_address_person, cr_district, cr_person, cr_street)
  */
public class PersonCheckDao {
    // TODO: 22/10/2019 Write  SQL request
    private static final String SQL_REQUEST =
            "SELECT temporal  FROM cr_address_person ap " +
            "INNER JOIN cr_person p ON p.person_id = ap.person_id " +
            "INNER JOIN cr_address a ON a.address_id = ap.address_id " +
            "WHERE " +
            "UPPER(p.sur_name) = UPPER(?) and UPPER(p.given_name) = UPPER(?) and UPPER(patronymic) = UPPER(?) " +
            "  and p.date_of_birth = ? and a.street_code = ? " +
            "  and UPPER(a.building) = UPPER(?) and UPPER(a.extension) = UPPER(?) and UPPER(a.apartment) = UPPER(?) ";

    /**
     * Get response on {@link PersonRequest} about Person
     * from cr_register database (GRN)
     * @param request
     * @return
     */
    public PersonResponse checkPerson(PersonRequest request) throws PersonCheckException {
        PersonResponse response = new PersonResponse();

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(SQL_REQUEST)){

            // TODO: 23/10/2019 set stmt params

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                response.setRegistered(true);
                response.setTemporal(rs.getBoolean("temporal"));
            }
        } catch (SQLException e){
            throw new PersonCheckException(e);
        }

        return response;
    }

    private Connection getConnection() throws SQLException {
        return ConnectionBuilder.getConnection();
    }
}
