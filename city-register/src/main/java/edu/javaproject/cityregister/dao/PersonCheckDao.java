package edu.javaproject.cityregister.dao;

import edu.javaproject.cityregister.domain.PersonRequest;
import edu.javaproject.cityregister.domain.PersonResponse;
import edu.javaproject.cityregister.exception.PersonCheckException;

import java.sql.*;

/***
 * That class is data access object.
 * That class get access to data in our dictionaries in city_register database
 * (tables: cr_address, cr_address_person, cr_district, cr_person, cr_street)
  */
public class PersonCheckDao {
    private static final String SQL_REQUEST =
            "SELECT temporal  FROM cr_address_person ap " +
            "INNER JOIN cr_person p ON p.person_id = ap.person_id " +
            "INNER JOIN cr_address a ON a.address_id = ap.address_id " +
            "WHERE " +
            "CURRENT_DATE >= ap.start_date AND (CURRENT_DATE <= ap.end_date OR ap.end_date is null) " +
            "  and UPPER(p.sur_name) = UPPER(?) and UPPER(p.given_name) = UPPER(?) and UPPER(patronymic) = UPPER(?) " +
            "  and p.date_of_birth = ? and a.street_code = ? " +
            "  and UPPER(a.building) = UPPER(?) ";

    //Set that params below depends on if value of
    // extension and apartment in cr_address table are null/not null
//            "  and UPPER(a.extension) = UPPER(?) " +
//            "  and UPPER(a.apartment) = UPPER(?) ";


    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }
    //Get connection with DB using ConncectionBuilder interface
    private Connection getConnection() throws SQLException, ClassNotFoundException {
        return connectionBuilder.getConnection();
    }

    /**
     * Get response on {@link PersonRequest} about Person from cr_register database (GRN)
     * @param request Data to get request about Person in GRN (city_register DB).
     * @return response to Person request
     */
    public PersonResponse checkPerson(PersonRequest request) throws PersonCheckException {
        PersonResponse response = new PersonResponse();

        //Correct SQL_REQUEST depends on if value of
        // extension and apartment in cr_address table are null/not null
        StringBuffer sql = new StringBuffer(SQL_REQUEST);
        if (request.getExtension() != null) {
            sql.append(" and UPPER(a.extension) = UPPER(?) ");
        } else{
            sql.append(" and a.extension is null ");
        }

        if (request.getApartment() != null) {
            sql.append(" and UPPER(a.apartment) = UPPER(?) ");
        } else{
            sql.append(" and a.apartment is null ");
        }

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql.toString())){

            int count = 1;

            stmt.setString(count++, request.getSurName());
            stmt.setString(count++, request.getGivenName());
            stmt.setString(count++, request.getPatronymic());
            stmt.setDate(count++, Date.valueOf(request.getDateOfBirth()));
            stmt.setInt(count++, request.getStreetCode());
            stmt.setString(count++, request.getBuilding());
            //set necessary count-th param depends on if value of
            // extension and apartment in cr_address table are null/not null
            if (request.getExtension() != null) {
                stmt.setString(count++, request.getExtension());
            }
            if (request.getApartment() != null) {
                stmt.setString(count++, request.getApartment());
            }

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                response.setRegistered(true);
                response.setTemporal(rs.getBoolean("temporal"));
            }
        } catch (SQLException | ClassNotFoundException e){
            throw new PersonCheckException(e);
        }

        return response;
    }
}
